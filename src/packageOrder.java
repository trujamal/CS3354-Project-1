import java.util.*;

public class packageOrder {

    //Case1: Show's All Packages in the database
    public static void showAllPackages(List<Package> x)
    {


    }

    //Case2: Add a new package to the database (Type list)
    public static List<Package> addNewPackage(List<Package> x)
    {
        /**
         * Have user input information
         */
        System.out.println("Please enter a Tracking Number");

        String trackingNumber;
        String type;
        String specification;
        String mailingClass;
        float weight;
        int volume;

        // Array
        String[] typePackage = {"Postcard","Letter","Envelope","Packet","Box","Crate","Drum","Roll", "Tube"};
        String[] specPackage = {"Fragile","Books","Catalogs","Do-not-Bend","n/a"};
        String[] mainPackage = {"First-Class","Priority","Retail","Ground","Metro"};

        //User input
        Scanner readInput = new Scanner(System.in);
        trackingNumber = readInput.nextLine();


        for (Package array : x)
        {
            boolean wat = inputTester(array, trackingNumber,x);
            System.out.println(wat);

            if(!wat)
            {
                System.out.println("Please the type of package");
                type = readInput.nextLine();
                if(contains(typePackage, type))
                {
                    System.out.println("Please the specification of package");
                    specification = readInput.nextLine();
                    if(contains(specPackage, specification))
                    {
                        System.out.println("Please enter the mailing class of the mail");
                        mailingClass = readInput.nextLine();
                        if(contains(mainPackage, mailingClass))
                        {
                            System.out.println("Please enter the weight of the package");
                            weight = Float.parseFloat(readInput.nextLine());
                            System.out.println("Please enter the volume of the package");
                            volume = Integer.parseInt(readInput.nextLine());
                            Package addingNew = new Package();
                            addingNew.trackingNumber = trackingNumber;
                            addingNew.type = readInput.nextLine();
                            addingNew.specification = readInput.nextLine();
                            addingNew.mailingClass = readInput.nextLine();
                            addingNew.weight = weight;
                            addingNew.volume = volume;
                            x.add(addingNew);
                        }
                    }
                }
            }
        }

        return x;
    }

    //Case3: Delete a package from the database (type list)
    public static List<Package> deletePackage(List<Package> x)
    {

        String trackingNumber;
        Scanner INFO = new Scanner(System.in);
        trackingNumber = INFO.nextLine();

        for (Package array : x)
        {
            if(array.trackingNumber == trackingNumber)
            {


            }
        }

        return x;
    }

    //Case4: Search for a package order given tracking number
    public static void searchForPackage(List<Package> x)
    {

    }

    //Case5: Show a list of packages with a given weight range
    public static void listWeightPackages(List<Package> x)
    {

    }

    public static boolean contains(String[] arr, String item)
    {
        for (String n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean inputTester(Package t, String y,List<Package> x) {
        boolean result;
        for (int i = 0; i < x.size(); i++) {

            Package halp;
            halp = x[i];
            if ( .[i].trackingNumber == y) {
                result = true;
                System.out.println("Thank you for subscribing to Hentai Weekly | Loli, Yuri, Furry, And More! For being the 1,000,000 customer, we would like to gift you a FREE Hentai Girl Tentacle Realistic Life-size Sex Doll and Lewd Body pillow FREE of charge! Have a horny day!");
                System.out.println("ERROR! The TRACKING NUMBER '" + y +
                        "' is already in use. Or is more than 5 characters. " +
                        "Please type in a different TRACKING NUMBER " +
                        "and try again.\n");
                addNewPackage(x);

            } else {
                result = false;
            }

        }
        return result;
    }


}
