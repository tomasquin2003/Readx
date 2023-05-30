package model;

import java.util.Calendar;

/**
 * Represents a Standard user in the system.
 * Inherits from the User class.
 */
public class Standard extends User {
    private Biliographic_product[] standard_products; // Array to store standard products
    private String[][] matrixStandard; // Matrix to store the bibliographic products of the Standard user.

    /**
     * Constructs a Standard user with the given information.
     *
     * @param user_name        the user's name
     * @param id               the user's ID
     * @param registrationDate the user's registration date
     * @param userType         the type of user (Standard, Regular, or Premium)
     */
    public Standard(String user_name, String id, Calendar registrationDate, String userType) {
        super(user_name, id, registrationDate, userType);
        standard_products = new Biliographic_product[7];
        matrixStandard = new String[5][5];
    }

    /**
     * Adds a bibliographic product to the user's collection.
     * The number of books is limited to 5 and the number of magazines is limited to 2.
     *
     * @param product the product to be added
     * @return true if the product was added successfully, false otherwise
     */
    @Override
    public boolean addProducts(Biliographic_product product) {
        if (product instanceof Book) {
            int bCounter = 0;
            for (int i = 0; i < standard_products.length; i++) {
                if (standard_products[i] != null && standard_products[i] instanceof Book) {
                    bCounter++;
                }
            }

            if (bCounter < 5) {
                for (int i = 0; i < standard_products.length; i++) {
                    if (standard_products[i] == null) {
                        standard_products[i] = product;
                        return true;
                    }
                }
            }
        } else if (product instanceof Magazine) {
            int mCounter = 0;
            for (int i = 0; i < standard_products.length; i++) {
                if (standard_products[i] != null && standard_products[i] instanceof Magazine) {
                    mCounter++;
                }
            }

            if (mCounter < 2) {
                for (int i = 0; i < standard_products.length; i++) {
                    if (standard_products[i] == null) {
                        standard_products[i] = product;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Fills the matrix with the user's products information.
     * Each cell represents a product with its code and the number of pages.
     */
    public void fillMatrix() {
        int productIndex = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (productIndex < standard_products.length) {
                    Biliographic_product biblioProducts = standard_products[productIndex];
                    if (biblioProducts != null) {
                        String code = biblioProducts.getProduct_id();
                        int pages = biblioProducts.getPages_number();
                        String pagesString = String.valueOf(pages);
                        matrixStandard[i][j] = code + "-" + pagesString;
                    } else {
                        matrixStandard[i][j] = "_______";
                    }
                    productIndex++;
                }
            }
        }
    }

    /**
     * Displays the user's product matrix.
     *
     * @return a string representation of the matrix
     */
    public String showMatrix() {
        fillMatrix();
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < matrixStandard.length; i++) {
            for (int j = 0; j < matrixStandard[0].length; j++) {
                String element = matrixStandard[i][j];
                String formattedElement = element != null ? String.format("%-7s", element) : "_______";
                print.append(formattedElement).append(" ");
            }
            print.append("\n");
        }

        return print.toString();
    }

    /**
     * Retrieves the product information based on the given product code.
     *
     * @param code the product code to search for
     * @return the information of the product, including its name and pages read
     */
    public String getProductInfoByCode(String code) {
        for (int i = 0; i < matrixStandard.length; i++) {
            for (int j = 0; j < matrixStandard[0].length; j++) {
                if (matrixStandard[i][j].equals(code)) {
                    Biliographic_product product = standard_products[i * matrixStandard[0].length + j];
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



    
    public String idFinder (String bookID) {
        
        String msg = "";

        
        
        return msg;
    }

    // ...
}


    



    








    



    