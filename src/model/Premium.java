package model;

import java.util.Calendar;
import java.util.ArrayList;

/**
 * Represents a Premium user who can register, modify, and delete bibliographic products.
 * Automatically generates objects in the system for each type of user and bibliographic product.
 * Allows a user to purchase a book, subscribe to a magazine, simulate a reading session (regular and premium),
 * and view their Library of Bibliographic Products.
 */
public class Premium extends User {

    /**
     * ArrayList to store the bibliographic products of the Premium user.
     */
    private ArrayList<Biliographic_product> premiumProducts;

    /**
     * Matrix to store the bibliographic products of the Premium user.
     */
    private String[][] matrixPremium;

    /**
     * Constructs a Premium object with the specified user name, ID, registration date, and user type.
     *
     * @param user_name       the name of the Premium user
     * @param id              the ID of the Premium user
     * @param registrationDate the registration date of the Premium user
     * @param userType        the type of the user (Premium)
     */
    public Premium(String user_name, String id, Calendar registrationDate, String userType) {
        super(user_name, id, registrationDate, userType);
        premiumProducts = new ArrayList<>();
        matrixPremium = new String[5][5];
    }

    /**
     * Adds a bibliographic product to the Premium user's collection.
     *
     * @param product the bibliographic product to be added
     * @return true if the product is successfully added, false otherwise
     */
    @Override
    public boolean addProducts(Biliographic_product product) {
        premiumProducts.add(product);
        return true;
    }

    /**
     * Fills the matrixPremium with the bibliographic products from the Premium user's collection.
     *
     * @return the matrixPremium filled with bibliographic product codes and pages
     */
    public String[][] fillMatrix() {
        int productIndex = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (productIndex < premiumProducts.size()) {
                    Biliographic_product biblioProducts = premiumProducts.get(productIndex);
                    String code = biblioProducts.getProduct_id();
                    int pages = biblioProducts.getPages_number();
                    String pagesString = String.valueOf(pages);
                    matrixPremium[i][j] = code + "-" + pagesString;
                    productIndex++;
                }
            }
        }

        return matrixPremium;
    }

    /**
     * Generates a formatted string representation of the matrixPremium.
     *
     * @return the formatted string representing the matrixPremium
     */
    public String showMatrix() {
        matrixPremium = fillMatrix();

        StringBuilder print = new StringBuilder();
        for (int i = 0; i < matrixPremium.length; i++) {
            for (int j = 0; j < matrixPremium[0].length; j++) {
                String element = matrixPremium[i][j];
                String formattedElement = element != null ? String.format("%-7s", element) : "_______";
                print.append(formattedElement).append(" ");
            }
            print.append("\n");
        }

        return print.toString();
    }

    /**
     * Retrieves the information of a bibliographic product based on its code.
     *
     * @param code the code of the bibliographic product
     * @return the information of the product (name and pages read) if found, null otherwise
     */
    public String getProductInfoByCode(String code) {
        for (int i = 0; i < matrixPremium.length; i++) {
            for (int j = 0; j < matrixPremium[0].length; j++) {
                if (matrixPremium[i][j].equals(code)) {
                    Biliographic_product product = premiumProducts.get(i * matrixPremium[0].length + j);
                    if (product != null) {
                        String name = product.getProduct_name();
                        int pagesRead = product.getPages_read();
                        return "Product name: " + name + ", Pages read: " + pagesRead;
                    }
                }
            }
        }
        return null;
    }
}
