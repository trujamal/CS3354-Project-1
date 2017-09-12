/**
 * @author Jamal Rasool and Zach Sotak
 * @version 1.0
 * @since 0.0
 * CS3354 Programing Assignment 1
 * Program is designed to simulate a shipping store database and give users an interface to display certain actions
 * in the program
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {

    /**
     * Runs the beginning portion of the program by executing the import array function to import information into a an
     * array to be read from later.
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException
    {
        // Import Array Information First
        importArrayInformation();
    }

    /**
     * Imports the file information into an array for later usage
     * @throws FileNotFoundException
     */
    private static void importArrayInformation() throws FileNotFoundException
    {
        // Creates a new array list
        List<Package> infoOfPack = new ArrayList<>();

        Scanner inFile = new Scanner(new FileReader("packages.txt"));
        while (inFile.hasNext()){

            String line = inFile.nextLine();
            String[] words = line.split(" ");

            /* Placing information into the array of objects */
            Package newInfo = new Package();
            newInfo.trackingNumber = words[0];
            newInfo.type = words[1];
            newInfo.specification = words[2];
            newInfo.mailingClass = words[3];
            newInfo.weight = Float.parseFloat(words[4]);
            newInfo.volume = Integer.parseInt(words[5]);
            infoOfPack.add(newInfo);

        }

        // Case Statements for menuOptions
        shippingStore.textInputFunction(infoOfPack);

        inFile.close();
    }

}
