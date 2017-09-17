package CS3354_Project_One_Package;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class packageOrder {
    /**
     * Designed to show all the Packages within the array object
     * @param x imports the array of objects
     */

    public static void showAllPackages() {
        Package currentPackage;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

        if (currentInventory.size() <= 0){
            System.out.println("ERROR! There's no inventory to display.");
        } else {
            System.out.format("%1$-10s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %n", "TRACKING #",
                    "TYPE", "SPECIFICATION", "CLASS", "WEIGHT", "VOLUME");
            System.out.println();
            for (int index = 0; index < currentInventory.size(); index++) {
                currentPackage = currentInventory.get(index);

                System.out.format("%1$-10s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %n",
                        currentPackage.gettrackingNumber(), currentPackage.gettype(),
                        currentPackage.getspecification(), currentPackage.getspecification(),
                        currentPackage.getmailingClass(),  currentPackage.getweight(),
                        currentPackage.getvolume());
            }
        }
    }




    /**
     * This function is designed to go through several test in order to determine if certain conditions are met in order
     * to add a package with specific values to the array.
     * @param x the array that is transferred between functions
     * @return returns an object of type package to add to the array for further writing.
     */

    public static Package addNewPackage(List<Package> x) {

        Package addingNew = new Package();
        addingNew.trackingNumber = userTextInputs(x,0);
        addingNew.type = userTextInputs(x,1);
        addingNew.specification = userTextInputs(x,2);
        addingNew.mailingClass = userTextInputs(x, 3);
        addingNew.weight = userFloatInputs(x);
        addingNew.volume = userIntegerInput(x);

        return addingNew;
    }

    /**
     * Gather's the users text input for the weight of a package, and checks to see if it meets the criteria of being
     * a float or not.
     * @param x package array
     * @return returns number to be added to the package.
     */

    public static Float userFloatInputs(List<Package> x)
    {
        Float val = Float.parseFloat("0");
        String stringValue;
        Scanner readInput = new Scanner(System.in);
        Boolean swatch = true;

        while(swatch == true) {
            System.out.println("Please enter the weight of the package");
            stringValue = readInput.nextLine();
                if (!stringValue.matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                    System.out.println("ERROR! The value" + stringValue +
                            "' is not a valid number. Please Try Again \n");
                } else if(stringValue.matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                    val = Float.parseFloat(stringValue);
                    return val;
                }
        }
        return val;
    }

    /**
     * Gather's the users text input for the volume of a package, and checks it to see if it meets the criteria of being
     * a digit or not.
     * @param x package array
     * @return returns number to be added to the package.
     */

    public static Integer userIntegerInput(List<Package> x)
    {
        int volume = Integer.parseInt("0");
        String stringValue;
        Scanner readInput = new Scanner(System.in);
        Boolean swatch = true;

        while(swatch == true) {
            System.out.println("Please enter the volume of the package");
            stringValue = readInput.nextLine();
            for (int i = 0; i < x.size(); i++) {
                if (!stringValue.matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                    System.out.println("ERROR! The value" + stringValue +
                            "' is not a valid volume. Please Try Again \n");
                } else if(stringValue.matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                    volume = Integer.parseInt(stringValue);
                    return volume;
                }
            }
        }
        return volume;
    }

    /**
     * Designed to test user inputs compared to an array of information
     * @param x Array of packages
     * @param version the position of text being called from the main function
     * @return returns the text that is being asked for
     */

    public static String userTextInputs(List<Package> x,int version)
    {
        // Declaring Arrays
        String[] typePackage = {"Postcard", "Letter", "Envelope", "Packet", "Box", "Crate", "Drum", "Roll", "Tube"};
        String[] specPackage = {"Fragile", "Books", "Catalogs", "Do-not-Bend", "n/a"};
        String[] mailPackage = {"First-Class", "Priority", "Retail", "Ground", "Metro"};

        Scanner readInput = new Scanner(System.in);
        String text = "";
        Boolean swatch = true;

        switch(version)
        {
            case 0:
                firstInput:
                while(swatch == true) {
                    System.out.println("Please enter a Tracking Number");
                    text = readInput.nextLine();
                    for (int i = 0; i < x.size(); i++) {
                        if (x.get(i).trackingNumber.matches(text) || text.length() != 5 || !text.matches("[A-Za-z0-9]+")) {
                            System.out.println("ERROR! The TRACKING NUMBER '" + text +
                                    "' is already in use. Or is invalid Please Try Again \n");
                            break;
                        } else if(i == (x.size()-1) && text.length() == 5 && text.matches("[A-Za-z0-9]+")) {
                            break firstInput;
                        }
                    }
                }
                return text;
            case 1:
                while (swatch) {
                    System.out.println("Please the type of Package");
                    text = readInput.nextLine();
                    if (contains(typePackage, text)) {
                        return text;
                    } else {
                        System.out.println("Error Invalid Input. Must contain \"Postcard\", \"Letter\", \"Envelope\"," +
                                " \"Packet\", \"Box\", \"Crate\", \"Drum\", \"Roll\", \"Tube\" Please Try again \n");
                    }
                }
                return text;
            case 2:
                while (swatch) {
                    System.out.println("Please enter the specification of Package");
                    text = readInput.nextLine();
                    if (contains(specPackage, text)) {
                        return text;
                    } else {
                        System.out.println("Error Invalid Input. Must contain \"Fragile\", \"Books\", \"Catalogs\"," +
                                " \"Do-not-Bend\", \"n/a\"  Please Try again \n");
                    }
                }
                return text;
            case 3:
                while (swatch) {
                    System.out.println("Please enter the mailing class of the package");
                    text = readInput.nextLine();
                    if (contains(mailPackage, text)) {
                        return text;
                    } else {
                        System.out.println("Error Invalid Input. Must contain \"First-Class\", \"Priority\", " +
                                "\"Retail\", \"Ground\", \"Metro\" Please Try again \n");
                    }
                }
                return text;
            case 4:
                break;
            default:

        }

        return text;
    }

    /**
     * Goes through and calls the removeTester function to go through and search for the proper package in the array and
     * returns false if the package has not been found.
     * @param x  the array that is transferred between functions
     * @return returns package location in the memory of the array to be deleted in the
     * CS3354_Project_One_Package.shippingStore.java file
     */

    public static Package deletePackage(List<Package> x) {

        String trackingNumber;
        Scanner info = new Scanner(System.in);
        System.out.println("Please enter a Tracking Number (To delete package from inventory)");
        trackingNumber = info.nextLine();
        Package remvoingPackage = removeTester(trackingNumber, x);

        return remvoingPackage;
    }


    public static void searchForPackage(String trackingNumber) {
        Package currentPackage = new Package();
        boolean found = false;

        for (int index = 0; index < currentInventory.size(); index++){
            currentPackage = currentInventory.get(index);

            if(currentPackage.gettrackingNumber() == trackingNumber){
                itemFound = true;
                break;
            }
        }


    }

    /**
     * Function to show a list of packages within a given weight range.
     * @param x
     */
    public static void listWeightPackages(List<Package> x) {
        // work in progress 9/17/2017
        Package currentPackage;
        int lower, upper, i;
        Scanner scannerObj = new Scanner(system.in);
        System.out.print("Enter lower weight range to print: ");
        lower = scannerObj.nextInt();

        System.out.println("Enter Upper weight range to print: ");
        upper = scannerObj.nextInt();

        for (i=lower; i<=upper; i++)
        {
            System.out.println(i);
        }



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

