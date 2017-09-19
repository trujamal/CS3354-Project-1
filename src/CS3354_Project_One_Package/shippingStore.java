package CS3354_Project_One_Package;

import java.io.*;
import java.util.*;

public class shippingStore {

    /**
     * Grabs user input, then converts it into a integer to be read into the case statement function "userCases"
     * Also within this snipet the program will grab the text and covert it into an integer separately in the if
     * statement.
     */

    public static void textInputFunction(List<Package> x)
    {
        // Display Menu Options
        menuOptions();

        String userText;
        Scanner userInput = new Scanner(System.in);
        userText = userInput.nextLine();

        if(userText.matches("h"))
        {
            int num = 7;
            try {
                userCases(num, x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(userText.matches("0"))
        {
            textInputFunction(x);
        }

        try {
            userCases(Integer.parseInt(userText),x);
        } catch (Exception e) {
            textInputFunction(x);
        }


    }

    /**
     *Declaring menu options within scope
     */

    private static void menuOptions()
    {


        System.out.println("Welcome to the Shipping Store database. Choose one of the following fucntions:");
        System.out.println();
        System.out.println("1. Show all existing package orders in the database.");
        System.out.println("2. Add new package record to the database.");
        System.out.println("3. Delete package record from a database");
        System.out.println("4. Search for a package order (given its Tracking#).");
        System.out.println("5. Show a list of packages within a given weight range.");
        System.out.println("6. Exit program");
        System.out.println();
        System.out.println("Please enter another command or 'h' to list the commands.");

    }

    /**
     * Used to check for user cases and then transfer the case to provided function.
     * @param num The number that user picks for the input for the menu.
     * @param x The transfer of the array list between functions
     */

    private static void userCases(int num, List<Package> x) throws Exception
    {
        Package newObject;
        switch (num)
        {
            case 1:
                // Show's All Packages in the database (Void)
                packageOrder.showAllPackages(x);
                textInputFunction(x);
                break;
            case 2:
                // Add a new package to the database (Return type list)
                newObject = packageOrder.addNewPackage(x);
                x.add(newObject);
                System.out.println("Successfully added Package to Inventory \n \n");
                textInputFunction(x);
                break;
            case 3:
                // Delete a package from the database (Return type list)
                newObject = packageOrder.deletePackage(x);
                x.remove(newObject);
                System.out.println("");
                textInputFunction(x);
                break;
            case 4:
                // Search for a package order given tracking number
                packageOrder.searchForPackage(x);
                textInputFunction(x);
                break;
            case 5:
                // Show a list of packages with a given weight range
                packageOrder.listWeightPackages(x);
                textInputFunction(x);
                break;
            case 6:
                try {
                    writeToFile(x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
            case 7:
                textInputFunction(x);
                break;
            default:
        }
    }

    /**
     * Designed to write to the file
     * @param arrayList1 Writes the array to file
     */

    private static void writeToFile(List<Package> arrayList1) throws Exception
    {
        PrintWriter outFile = new PrintWriter("packages.txt");
        for (Package array : arrayList1)
        {
            outFile.print(array.trackingNumber + " " + array.type + " " + array.specification + " " + array.mailingClass
                    + " "+ array.weight + " " + array.volume +"\n");
        }

        outFile.close();
    }

}

/**
 * Creates the package object, that holds the tracking number,type, specification, mailing classes, weight, and volume.
 */

class Package {

    String trackingNumber;
    String type;
    String specification;
    String mailingClass;
    float weight;
    int volume;

}



