package model;

import java.util.Calendar;

/**
 * Abstract class representing a bibliographic product.
 */
public abstract class Biliographic_product {
    private String product_id;
    private String product_name;
    private int pages_number;
    private Calendar publication_date;
    private int pages_read;
    private double product_cost;
    private String product_url;

    /**
     * Constructs a bibliographic product with the specified details.
     *
     * @param product_id       the ID of the product
     * @param product_name     the name of the product
     * @param pages_number     the number of pages in the product
     * @param publication_date the publication date of the product
     * @param pages_read       the number of pages read by the user
     * @param product_cost     the cost of the product
     * @param product_url      the URL of the product
     */
    public Biliographic_product(String product_id, String product_name, int pages_number, Calendar publication_date,
                                int pages_read, double product_cost, String product_url) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.pages_number = pages_number;
        this.publication_date = publication_date;
        this.pages_read = pages_read;
        this.product_cost = product_cost;
        this.product_url = product_url;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return the ID of the product
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param product_id the ID of the product
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return the name of the product
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Sets the name of the product.
     *
     * @param product_name the name of the product
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Retrieves the number of pages in the product.
     *
     * @return the number of pages in the product
     */
    public int getPages_number() {
        return pages_number;
    }

    /**
     * Sets the number of pages in the product.
     *
     * @param pages_number the number of pages in the product
     */
    public void setPages_number(int pages_number) {
        this.pages_number = pages_number;
    }

    /**
     * Retrieves the publication date of the product.
     *
     * @return the publication date of the product
     */
    public Calendar getPublication_date() {
        return publication_date;
    }

    /**
     * Sets the publication date of the product.
     *
     * @param publication_date the publication date of the product
     */
    public void setPublication_date(Calendar publication_date) {
        this.publication_date = publication_date;
    }

    /**
     * Retrieves the number of pages read by the user.
     *
     * @return the number of pages read by the user
     */
    public int getPages_read() {
        return pages_read;
    }

    /**
     * Sets the number of pages read by the user.
     *
     * @param pages_read the number of pages read by the user
     */
    public void setPages_read(int pages_read) {
        this.pages_read = pages_read;
    }

    /**
     * Retrieves the cost of the product.
     *
     * @return the cost of the product
     */
    public double getProduct_cost() {
        return product_cost;
    }

    /**
     * Sets the cost of the product.
     *
     * @param product_cost the cost of the product
     */
    public void setProduct_cost(double product_cost) {
        this.product_cost = product_cost;
    }

    /**
     * Retrieves the URL of the product.
     *
     * @return the URL of the product
     */
    public String getProduct_url() {
        return product_url;
    }

    /**
     * Sets the URL of the product.
     *
     * @param product_url the URL of the product
     */
    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    /**
     * Removes the product at the specified index.
     *
     * @param index the index of the product to remove
     */
    public void remove(int index) {
        // Implementation for removing the product at the specified index
    }
}
