import java.util.*;

public class packageOrder {

    //Case1: Show's All Packages in the database
    public static void showAllPackages(List<Package> x) {


    }

    //Case2: Add a new package to the database (Type list)
    public static Package addNewPackage(List<Package> x) {
        /**
         * Have user input information
         */
        System.out.println("Please enter a Tracking Number");

        Package addingNew = new Package();
        String trackingNumber;
        String type;
        String specification;
        String mailingClass;
        float weight;
        int volume;

        // Array
        String[] typePackage = {"Postcard", "Letter", "Envelope", "Packet", "Box", "Crate", "Drum", "Roll", "Tube"};
        String[] specPackage = {"Fragile", "Books", "Catalogs", "Do-not-Bend", "n/a"};
        String[] mainPackage = {"First-Class", "Priority", "Retail", "Ground", "Metro"};

        //User input
        Scanner readInput = new Scanner(System.in);
        trackingNumber = readInput.nextLine();

        boolean wat = inputTester(trackingNumber, x);
        while(!wat) {
                System.out.println("Please the type of package");
                type = readInput.nextLine();
                    if (contains(typePackage, type)) {
                            System.out.println("Please enter the specification of package");
                            specification = readInput.nextLine();
                            if (contains(specPackage, specification)) {
                                    System.out.println("Please enter the mailing class of the mail");
                                    mailingClass = readInput.nextLine();
                                    if (contains(mainPackage, mailingClass)) {
                                            System.out.println("Please enter the weight of the package");
                                            weight = Float.parseFloat(readInput.nextLine());
                                            System.out.println("Please enter the volume of the package");
                                            volume = Integer.parseInt(readInput.nextLine());
                                            addingNew.trackingNumber = trackingNumber;
                                            addingNew.type = type;
                                            addingNew.specification = specification;
                                            addingNew.mailingClass = mailingClass;
                                            addingNew.weight = weight;
                                            addingNew.volume = volume;
                                            return addingNew;
                                    } else {
                                        System.out.println("Error Invalid Input. Please Try again \n");
                                    }

                            } else {
                                System.out.println("Error Invalid Input. Please Try again \n");

                            }

                    } else {
                        System.out.println("Error Invalid Input. Please Try again \n");
                    }
                }

        return addingNew;
    }

    //Case3: Delete a package from the database (type list)
    public static Package deletePackage(List<Package> x) {

        String trackingNumber;
        Scanner info = new Scanner(System.in);
        System.out.println("Please enter a Tracking Number (To delete package from inventory)");
        trackingNumber = info.nextLine();
        Package remvoingPackage = removeTester(trackingNumber, x);

        return remvoingPackage;
    }

    //Case4: Search for a package order given tracking number
    public static void searchForPackage(List<Package> x) {

    }

    //Case5: Show a list of packages with a given weight range
    public static void listWeightPackages(List<Package> x) {

    }

    public static boolean contains(String[] arr, String item) {
        for (String n : arr) {
            if (n.contains(item)) {
                return true;
            }
        }

        return false;
    }

    public static boolean inputTester(String y, List<Package> x) {
        boolean result = false;


        for (int i = 0; i < x.size(); i++) {

            if (x.get(i).trackingNumber.matches(y) || y.length() != 5) {

                System.out.println("ERROR! The TRACKING NUMBER '" + y +
                        "' is already in use. Or is not 5 characters. \n");
                result = true;
                addNewPackage(x);
            }
        }

        return result;
    }

    public static Package removeTester(String y, List<Package> x) {

        Package remvoingPackage = new Package();

        for (int i = 0; i < x.size(); i++) {

            if (x.get(i).trackingNumber.matches(y)) {
                System.out.print("SUCCESS!");
                remvoingPackage = x.get(i);
                return remvoingPackage;

            }
        }
        System.out.println("ERROR! The TRACKING NUMBER '" + y +
                "' does not exist. Please enter a valid number \n");
        deletePackage(x);

        return remvoingPackage;
    }

}
