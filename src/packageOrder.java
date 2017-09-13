import java.util.*;

public class packageOrder {

    //Case1: Show's All Packages in the database
    public static void showAllPackages(List<Package> x)
    {
    ////Piewdiepie

        // FREE MA NIGGAS

    }

    //Case2: Add a new package to the database (Type list)
    public static List<Package> addNewPackage(List<Package> x)
    {
        /**
         * Have user input information
         */
        System.out.println("Please a Tracking Number");

        String trackingNumber;
        String type;
        String specification;
        String mailingClass;
        float weight;
        int volume;

        Scanner readInput = new Scanner(System.in);
        trackingNumber = readInput.nextLine();

        for (Package array : x)
        {
            if(array.trackingNumber == trackingNumber)
            {
                System.out.println("ERROR! The TRACKING NUMBER '" + trackingNumber +
                        "' is already in use. Please type in a different TRACKING NUMBER " +
                        "and try again.\n");
                addNewPackage(x);
            } else {

                System.out.println("Please a Tracking Number");


                String currentPrice = Double.toString(new_dvd.getPrice());
                int locationDecimal = currentPrice.indexOf('.');
                String decimalPortion = currentPrice.substring(locationDecimal + 1);

                if (new_dvd.getPrice() <= 0){
                    System.out.println();
                    System.out.println("ERROR! Price cannot be $0.00. Minimum price" +
                            "$0.01");
                    return false;
                } else if (decimalPortion.length() > 2 || decimalPortion.length() < 2){
                    System.out.println();
                    System.out.println("ERROR! Invalid price. Price must be formatted "
                            + "in the form #.##");
                    return false;
                } else if (new_dvd.getQuantity() <= 0){
                    System.out.println();
                    System.out.println("ERROR! Invalid quantity. Quantity must be " +
                            "greater than 0.");
                    return false;
                } else {
                    return x.add(new_dvd);
                }


            }
        }

        return x;
    }

    //Case3: Delete a package from the database (type list)
    public static List<Package> deletePackage(List<Package> x)
    {



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




}
