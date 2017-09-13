import java.util.*;

public class packageOrder {

    //Case1: Show's All Packages in the database
    public static void showAllPackages(List<Package> x)
    {



    }

    //Case2: Add a new package to the database (Type list)
    public static List<Package> addNewPackage(List<Package> x)
    {

        /*
            Check current inventory to see if SKU of new movie matches the SKU
            of a movie already in the inventory. If it does then display and
            error to the user, otherwise add the move to the inventory.
        */

        for (int index = 0; index < x.size(); index++) {

            Package currentPackage = x.get(index);

            // Checks to see if the new item's SKU already exists.
            if (currentPackage.getSku() == new_dvd.getSku()) {
                System.out.println();
                System.out.println("ERROR! The SKU '" + new_dvd.getSku() +
                        "' is already in use. Please select a different SKU " +
                        "and try again.");
                return false;
            }
        }
        /*
            Validate the format of the price. If it's "0" then display an error,
            otherwise check to see if decimal portion of the price  has more
            than two places, if it does then display an error. Furthermore,
            validate the quantity and determine if it's less than or equal to
            "0", if it is then display an error.
        */

        // Convert price from double to string to check decimal portion.
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
