package CS3354_Project_One_Package;

import java.util.*;

public class packageOrder {
    /**
     * Designed to show all the Pacakges within the array object
     * @param x imports the array of objects
     */

    public static void showAllPackages(List<Package> x) {

    }

    /**
     * This function is designed to go through several test in order to determine if certain conditions are met in order
     * to add a package with specific values to the array.
     * @param x the array that is transferred between functions
     * @return returns an object of type package to add to the array for further writing.
     */

    public static Package addNewPackage(List<Package> x) {

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


        boolean testEpoch = inputTester(trackingNumber, x);
        while(!testEpoch) {
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

    /**
     * Goes through and calls the removeTester function to go through and search for the proper package in the array and
     * returns false if the package has not been found.
     * @param x  the array that is transferred between functions
     * @return returns package location in the memory of the array to be deleted in the CS3354_Project_One_Package.shippingStore.java file
     */

    public static Package deletePackage(List<Package> x) {

        String trackingNumber;
        Scanner info = new Scanner(System.in);
        System.out.println("Please enter a Tracking Number (To delete package from inventory)");
        trackingNumber = info.nextLine();
        Package remvoingPackage = removeTester(trackingNumber, x);

        return remvoingPackage;
    }

    public static void searchForPackage(List<Package> x) {
// TODO: 9/14/17 help
    }

    public static void listWeightPackages(List<Package> x) {

    }

    /**
     * Function will compare the array to the user input text to see if their is a match and if so, return a true or
     * false value.
     * @param arr Passes through the string array mentioned in the previous function
     * @param item The user input that the function will compare.
     * @return returns a true or false value to check if it contains the said user text.
     */
    public static boolean contains(String[] arr, String item) {
        for (String n : arr) {
            if (n.contains(item)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Will test the users input to see if it matches the constraints dictated by the tracking number
     * @param y Users input
     * @param x array of CS3354_Project_One_Package.Package Objects
     * @return returns false if the input is valid; and if the info is true, where it doesn't meet the conditions then
     * it will re-prompt the user to re-enter the information again.
     */
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

    /**
     * Designed to check if the users input matches any information within the array, and if so pass the object to be
     * deleted.
     * @param y Users input
     * @param x array of CS3354_Project_One_Package.Package Objects
     * @return Passing object to be deleted.
     */
    public static Package removeTester(String y, List<Package> x) {

        Package removingPackage = new Package();

        for (int i = 0; i < x.size(); i++) {

            if (x.get(i).trackingNumber.matches(y)) {
                System.out.print("SUCCESS!");
                removingPackage = x.get(i);
                return removingPackage;

            }
        }
        System.out.println("ERROR! The TRACKING NUMBER '" + y +
                "' does not exist. Please enter a valid number \n");
        deletePackage(x);

        return removingPackage;
    }

}
