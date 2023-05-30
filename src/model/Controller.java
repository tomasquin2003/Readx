package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;


    public class Controller {
    
    private ArrayList<User> users;
    private ArrayList<Biliographic_product> product;

    public Controller (){
        this.users = new ArrayList<>(); 
        this.product = new ArrayList<>();
        testCases();
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Biliographic_product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Biliographic_product> product) {
        this.product = product;
    }

    public void testCases () {
            //Calendar signUpDate = Calendar.getInstance();
        User user1 = new Standard("Spiderman", "spidey123", new GregorianCalendar(2023, 0, 1), "STANDARD");
        User user2 = new Premium("Batman", "batman456", new GregorianCalendar(2023, 1, 15), "PREMIUM");
        User user3 = new Standard("Wonder Woman", "wonder123", new GregorianCalendar(2023, 2, 10), "STANDARD");           
        User user4 = new Premium("Iron Man", "ironman789", new GregorianCalendar(2023, 3, 20), "PREMIUM");
        User user5 = new Standard("Black Widow", "blackwidow007", new GregorianCalendar(2023, 4, 5), "STANDARD");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
       
        Biliographic_product Product1 = new Book(bookID(), "The Great Gatsby", 350, new GregorianCalendar(1925, 4, 10), 0, 15.99, "https://exmpl.com/bk1", "A captivating tale", Book_genre.FANTASY, 0);
        Biliographic_product Product2 = new Book(bookID(), "To Kill a Mockingbird", 320, new GregorianCalendar(1960, 6, 11), 0, 12.99, "https://exmpl.com/bk2", "A powerful story", Book_genre.FANTASY, 0);
        Biliographic_product Product3 = new Book(bookID(), "The Hitchhiker", 240, new GregorianCalendar(1979, 8, 12), 0, 10.99, "https://exmpl.com/bk3", "An entertaining sci-fi comedy", Book_genre.SCIENCE_FICTION, 0);
        product.add(Product1);
        product.add(Product2);
        product.add(Product3);
        
        Biliographic_product Product4 = new Magazine(magazineID(), "National Geographic", 100, new GregorianCalendar(2023, 4, 1), 0, 9.99, "https://exmpl.com/mag1", Magazine_genre.VARIETIES, "MONTHLY", 0);
        Biliographic_product Product5 = new Magazine(magazineID(), "Time", 50, new GregorianCalendar(2023, 4, 15), 0, 7.99, "https://exmpl.com/mag2", Magazine_genre.VARIETIES, "WEEKLY", 0);
        Biliographic_product Product6 = new Magazine(magazineID(), "Sports Illustrated", 80, new GregorianCalendar(2023, 4, 8), 0, 6.99, "https://exmpl.com/mag3", Magazine_genre.VARIETIES, "DAILY", 0);
        product.add(Product4);
        product.add(Product5);
        product.add(Product6);
        
        
    }


  /**
 * Returns a formatted string containing the list of users.
 *
 * @return The formatted string with the list of users.
 */
public String getUserList() {
    String msg = "";
    for (int i = 0; i < users.size(); i++) {
        User user = users.get(i);
        msg += "\n" + (i + 1) + ". "
                + "User name: " + user.getUser_name() + " - "
                + "ID: " + user.getId() + " - "
                + "Registration date: " + user.getRegistrationDate().get(Calendar.DAY_OF_MONTH) + "/"
                + (user.getRegistrationDate().get(Calendar.MONTH) + 1) + "/" + user.getRegistrationDate().get(Calendar.YEAR) + " - "
                + "User type: " + user.getUserType();
    }
    return msg;
}

    /**
     * Returns a formatted string containing the list of bibliographic products.
     *
     * @return The formatted string with the list of bibliographic products.
     */
    public String getProductList() {
        String msg = "";
        for (int i = 0; i < product.size(); i++) {
            Biliographic_product products = product.get(i);
            msg += "\n" + (i + 1) + ". "
                    + "Product name: " + products.getProduct_name() + " - "
                    + "ID: " + products.getProduct_id() + " - "
                    + "Publication date: " + products.getPublication_date().get(Calendar.DAY_OF_MONTH) + "/"
                    + (products.getPublication_date().get(Calendar.MONTH) + 1) + "/" + products.getPublication_date().get(Calendar.YEAR) + " - ";

            if (products instanceof Book) {
                Book book = (Book) products;
                msg += "Book genre: " + book.getBook_genre() + " - "
                        + "Book review: " + book.getBook_review();
            } else if (products instanceof Magazine) {
                Magazine magazine = (Magazine) products;
                msg += "Magazine genre: " + magazine.getMagazine_genre() + " - "
                        + "Emision periodicity: " + magazine.getEmision_periodicity();
            }
        }
        return msg;
    }

    /**
     * Registers a new user with the given information.
     *
     * @param user_name        The name of the user.
     * @param id               The ID of the user.
     * @param vinculationDay   The day of registration.
     * @param vinculationMonth The month of registration.
     * @param vinculationYear  The year of registration.
     * @param type             The type of user (1 for standard user, 2 for premium user).
     * @return True if the user is successfully registered, false otherwise.
     */
    public boolean registerUser(String user_name, String id, int vinculationDay, int vinculationMonth, int vinculationYear, int type) {

        GregorianCalendar registrationDate = new GregorianCalendar(vinculationYear, vinculationMonth - 1, vinculationDay);

        if (type == 1) {
            String userType = "STANDARD USER";
            Standard standardUser = new Standard(user_name, id, registrationDate, userType);
            users.add(standardUser);
        } else if (type == 2) {
            String userType = "PREMIUM USER";
            Premium premiumUser = new Premium(user_name, id, registrationDate, userType);
            users.add(premiumUser);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Registers a new bibliographic product with the given information.
     *
     * @param product_name       The name of the product.
     * @param biblio_product     The type of bibliographic product (1 for book, 2 for magazine).
     * @param bookGenre          The genre of the book.
     * @param book_review        The review of the book.
     * @param magazineGenre      The genre of the magazine.
     * @param emision_periodicity The periodicity of the magazine.
     * @param pages_number       The number of pages in the product.
     * @param publicationDay     The day of publication.
     * @param publicationMonth   The month of publication.
     * @param publicationYear    The year of publication.
     * @param product_cost       The cost of the product.
     * @param product_url        The URL of the product.
     * @return True if the product is successfully registered, false otherwise.
     */
    public boolean registerBiblioProducts(String product_name, int biblio_product, int bookGenre, String book_review, int magazineGenre, String emision_periodicity, int pages_number, int publicationDay, int publicationMonth, int publicationYear, double product_cost, String product_url) {

        GregorianCalendar publication_date = new GregorianCalendar(publicationYear, publicationMonth - 1, publicationDay);

        // Verificar si el producto es un libro o una revista
        if (biblio_product == 1) {
            // Si es un libro, convertir el valor numérico del género a su correspondiente enum
            Book_genre book_genre;
            switch (bookGenre) {
                case 1:
                    book_genre = Book_genre.SCIENCE_FICTION;
                    break;
                case 2:
                    book_genre = Book_genre.FANTASY;
                    break;
                case 3:
                    book_genre = Book_genre.HISTORICAL_NOVEL;
                    break;
                default:
                    return false;
            }
            String product_id = magazineID();
            int pages_read = 0;
            int sold_bookUnits = 0;
            // Crear el objeto libro y añadirlo al ArrayList
            Book book = new Book(product_id, product_name, pages_number, publication_date, pages_read, product_cost, product_url, book_review, book_genre, sold_bookUnits);
            product.add(book);
        } else if (biblio_product == 2) {
            // Si es una revista, convertir el valor numérico del género a su correspondiente enum
            Magazine_genre magazine_genre;
            switch (magazineGenre) {
                case 1:
                    magazine_genre = Magazine_genre.VARIETIES;
                    break;
                case 2:
                    magazine_genre = Magazine_genre.DESIGN;
                    break;
                case 3:
                    magazine_genre = Magazine_genre.SCIENTIFIC;
                    break;
                default:
                    return false;
            }

            String product_id = magazineID();
            int pages_read = 0;
            int active_suscriptions = 0;
            // Crear el objeto revista y añadirlo al ArrayList
            Magazine magazine = new Magazine(product_id, product_name, pages_number, publication_date, pages_read, product_cost, product_url, magazine_genre, emision_periodicity, active_suscriptions);
            product.add(magazine);
        }

        return true;
    }

    /**
     * Generates a random ID for a book.
     *
     * @return The randomly generated ID.
     */
    public String bookID() {
        Random rand = new Random();
        int num = rand.nextInt(4096); // generamos un número aleatorio entre 0 y 4095
        String hex = Integer.toHexString(num).toUpperCase(); // convertimos el número a hexadecimal y lo ponemos en mayúsculas
        // si el número generado es menor a 3 caracteres hexadecimales, le agregamos ceros a la izquierda
        while (hex.length() < 3) {
            hex = "0" + hex;
        }
        return hex;
    }

    /**
     * Generates a random ID for a magazine.
     *
     * @return The randomly generated ID.
     */
    public static String magazineID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            int index = rnd.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Modifies the attributes of a bibliographic product.
     *
     * @param product_selection The index of the product to modify.
     * @param option_attribute  The attribute to modify (1 for name, 2 for pages number, 3 for URL, 4 for cost).
     * @param product_name      The new name of the product.
     * @param pages_number      The new number of pages in the product.
     * @param product_url       The new URL of the product.
     * @param product_cost      The new cost of the product.
     * @return True if the product is successfully modified, false otherwise.
     */
    public boolean modifyBiblioproducts(int product_selection, int option_attribute, String product_name, int pages_number, String product_url, double product_cost) {


        Biliographic_product products = product.get(product_selection - 1);
        if (option_attribute == 1) {
            products.setProduct_name(product_name);
        } else if (option_attribute == 2) {
            products.setPages_number(pages_number);
        } else if (option_attribute == 3) {
            products.setProduct_url(product_url);
        } else if (option_attribute == 4) {
            products.setProduct_cost(product_cost);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Retrieves the modified information of a product.
     *
     * @param product_selection The index of the product.
     * @return The information of the modified product.
     */
    public String getProductModified(int product_selection) {
        String msg = "";
        Biliographic_product products = product.get(product_selection - 1);
        msg += "\n" + (product_selection) + ". "
                + "Product name: " + products.getProduct_name() + " - "
                + "ID: " + products.getProduct_id() + " - "
                + "Pages number: " + products.getPages_number() + " - "
                + "Product URL: " + products.getProduct_url() + " - "
                + "Product cost: " + products.getProduct_cost();
        return msg;
    }

    /**
     * Removes a product from the system.
     *
     * @param index The index of the product to remove.
     * @return True if the product is successfully removed, false otherwise.
     */
    public boolean removeProducts(int index) {

        product.remove(index);
        return true;
    }

    /**
     * Allows a user to buy a product.
     *
     * @param query           The query for searching a product.
     * @param option_User     The option of the user.
     * @param option_buyProduct The option to buy a product.
     * @return True if the product is successfully bought, false otherwise.
     */
    public boolean buyProducts(String query, int option_User, int option_buyProduct) {
        User user = users.get(option_User);
    
        if (user instanceof Premium) {
            if (option_buyProduct >= 0 && option_buyProduct < product.size()) {
                Biliographic_product products = product.get(option_buyProduct);
                if (products instanceof Book) {
                    Book soldUnits = (Book) products;
                    soldUnits.bookUnits();
                } else if (products instanceof Magazine) {
                    Magazine suscriptions = (Magazine) products;
                    suscriptions.suscriptions();
                }
                return ((Premium) user).addProducts(products);
            }
        } else if (user instanceof Standard) {
            if (option_buyProduct >= 0 && option_buyProduct < product.size()) {
                Biliographic_product products = product.get(option_buyProduct);
                if (products instanceof Book) {
                    Book soldUnits = (Book) products;
                    soldUnits.bookUnits();
                } else if (products instanceof Magazine) {
                    Magazine suscriptions = (Magazine) products;
                    suscriptions.suscriptions();
                }
                return ((Standard) user).addProducts(products);
            }
        }
    
        return false;
    }
  
    


        /**
     * Shows the matrix of bibliographic products for a given user.
     *
     * @param choice The user's choice (index) from the user list.
     * @return The matrix of bibliographic products for the specified user.
     */
    public String showMatrix(int choice) {
        User user = users.get(choice - 1);

        if (user instanceof Standard) {
            Standard standardUser = (Standard) user;
            return standardUser.showMatrix();
        } else if (user instanceof Premium) {
            Premium premiumUser = (Premium) user;
            return premiumUser.showMatrix();
        }

        return "";
    }

    /**
     * Generates an invoice for the purchase of a bibliographic product by a user.
     *
     * @param option_User      The user's choice (index) from the user list.
     * @param option_buyProduct The product's choice (index) from the product list.
     * @return The generated invoice as a string.
     */
    public String invoice(int option_User, int option_buyProduct) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate);

        User user = users.get(option_User - 1);
        Biliographic_product products = product.get(option_buyProduct - 1);

        String invoice = "***************************************\n"
                + "             SALES INVOICE\n"
                + "***************************************\n\n"
                + "Date:" + formattedDate + "\n"
                + "Customer: " + user.getUser_name() + "\n"
                + "Invoice Number: 123456789\n\n"
                + "---------------------------------------\n"
                + "Description:" + products.getProduct_url() + "Amount:1\n"
                + "---------------------------------------\n"
                + "Product:" + products.getProduct_name() + "\n"
                + "---------------------------------------\n"
                + "Subtotal:" + (products.getProduct_cost() - 4.50) + "\n"
                + "Tax:" + "$4.50" + "\n"
                + "Total:" + products.getProduct_cost() + "\n"
                + "---------------------------------------\n\n"
                + "Thank you for your purchase. Come back soon!\n\n"
                + "***************************************";

        return invoice;
    }

        /**
    * Finds a product by its ID.
    *
    * @param bookId the ID of the book to search for
    * @return a message indicating the status of the search
    * and the details of the found product if found,
    * or an "Incorrect ID" message if not found
    */

    public String idFinder (String bookId) {
        
        String msg = "Incorrect ID";

        for (int i = 0; i < product.size(); i++) {
            Biliographic_product products = product.get(i);

            if(bookId.equalsIgnoreCase(products.getProduct_id())){
                return " Reading " + products.getProduct_name() + "-" + products.getProduct_id();
            }
        }
        
        return msg;
    }

    /**
     * Simulates a reading session for a user.
     *
     * @param readDecision The decision made by the user during the reading session.
     * @param x            The x-coordinate of the simulated reading session.
     * @param y            The y-coordinate of the simulated reading session.
     * @param choice       The user's choice (index) from the user list.
     * @return The message or result of the reading simulation.
     */
    public String readSimulation(int readDecision, int choice) {
        String msg = "";



        return msg;
    }

    /**
     * Generates an advertisement message for a given user.
     *
     * @param choice The user's choice (index) from the user list.
     * @return The advertisement message for the specified user.
     */

        public String advertisement(int choice) {
            String msg = "";
            User user = users.get(choice-1);
            if (user instanceof Standard) {
                msg = "SPECIAL ANNOUNCEMENT FROM READX!\n\n"
                    + "------------------------------\n"
                    + "|         READX APP         |\n"
                    + "|    Digital Library        |\n"
                    + "|  Discover and Enjoy       |\n"
                    + "|   your Books and Magazines|\n"
                    + "------------------------------\n\n"
                    + "Download the ReadX application and access an extensive collection of bibliographic products. Immerse yourself in the fascinating world of reading and enjoy the best books and magazines in the palm of your hand.\n\n"
                    + "Key Features:\n"
                    + "- Intuitive and user-friendly interface.\n"
                    + "- Wide variety of literary genres and magazine topics.\n"
                    + "- Access to exclusive content and new releases.\n"
                    + "- Mark your favorites and keep track of your readings.\n"
                    + "- Customize your reading experience with font and screen settings.\n"
                    + "- Download your books and magazines for offline reading.\n\n"
                    + "Don't miss this unique opportunity to have a complete library on your mobile device!\n\n"
                    + "-----------------------------\n"
                    + "|     FREE DOWNLOAD         |\n"
                    + "|     Available on:         |\n"
                    + "|   App Store and Google    |\n"
                    + "-----------------------------\n\n"
                    + "Start reading today with ReadX and discover a world full of knowledge, entertainment, and literary adventures!\n\n"
                    + "We look forward to seeing you on ReadX. Download now and join our community of passionate readers!";
        
                return msg; 
            } else {
                return msg += "Logging in...";
            }
        }

    }

 
    




