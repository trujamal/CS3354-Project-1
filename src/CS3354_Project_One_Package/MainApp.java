package CS3354_Project_One_Package;
/** Shipping Store Program.
 *@author Jamal Rasool and Zach Sotak
 *Date: 09/12/2017
 *@version 1.0
 *@since 1.0
 *Class Name: CS3354_Project_One_Package.MainApp
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


        File f = new File("packages.txt");
        if (f.isFile() && f.canRead()) {
            try {
                Scanner inFile = new Scanner(new FileReader("packages.txt"));


                try {
                    while (inFile.hasNext()) {

                        String line = inFile.nextLine();
                        String[] words = line.split(" ");

                        //Placing information into the array of objects
                        Package newInfo = new Package();
                        newInfo.trackingNumber = words[0];
                        newInfo.type = words[1];
                        newInfo.specification = words[2];
                        newInfo.mailingClass = words[3];
                        newInfo.weight = Float.parseFloat(words[4]);
                        newInfo.volume = Integer.parseInt(words[5]);
                        infoOfPack.add(newInfo);
                    }

                } finally {
                    inFile.close();
                }
            } catch (IOException ex) {
                System.out.println(ex + "Error file can not be opened");
                shippingStore.textInputFunction(infoOfPack);
            }
        }


        // Case Statements for menuOptions
       shippingStore.textInputFunction(infoOfPack);

    }

}
