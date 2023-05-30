package model;

import java.util.Calendar;

/**
 * Represents a magazine, a type of bibliographic product.
 */
public class Magazine extends Biliographic_product {

    private String emision_periodicity;
    private Magazine_genre magazine_genre; 
    private int active_suscriptions; 

    /**
     * Constructs a Magazine object with the specified parameters.
     *
     * @param product_id         the ID of the magazine
     * @param product_name       the name of the magazine
     * @param pages_number       the number of pages in the magazine
     * @param publication_date   the publication date of the magazine
     * @param pages_read         the number of pages read by the user
     * @param product_cost       the cost of the magazine
     * @param product_url        the URL of the magazine
     * @param magazine_genre     the genre of the magazine
     * @param emision_periodicity the periodicity of the magazine's issuance
     * @param active_suscriptions the number of active subscriptions for the magazine
     */
    public Magazine(String product_id, String product_name, int pages_number, Calendar publication_date, int pages_read,
                    double product_cost, String product_url, Magazine_genre magazine_genre,
                    String emision_periodicity, int active_suscriptions) {
        super(product_id, product_name, pages_number, publication_date, pages_read, product_cost, product_url);

        this.emision_periodicity = emision_periodicity; 
        this.magazine_genre = magazine_genre; 
        this.active_suscriptions = active_suscriptions; 
    }

    /**
     * Returns the emission periodicity of the magazine.
     *
     * @return the emission periodicity
     */
    public String getEmision_periodicity() {
        return emision_periodicity;
    }

    /**
     * Sets the emission periodicity of the magazine.
     *
     * @param emision_periodicity the emission periodicity to set
     */
    public void setEmision_periodicity(String emision_periodicity) {
        this.emision_periodicity = emision_periodicity;
    }

    /**
     * Returns the genre of the magazine.
     *
     * @return the magazine genre
     */
    public Magazine_genre getMagazine_genre() {
        return magazine_genre;
    }

    /**
     * Returns the number of active subscriptions for the magazine.
     *
     * @return the number of active subscriptions
     */
    public int getActive_suscriptions() {
        return active_suscriptions;
    }

    /**
     * Sets the number of active subscriptions for the magazine.
     *
     * @param active_suscriptions the number of active subscriptions to set
     */
    public void setActive_suscriptions(int active_suscriptions) {
        this.active_suscriptions = active_suscriptions;
    }

    /**
     * Increments the number of active subscriptions for the magazine by one.
     */
    public void suscriptions() {
        active_suscriptions++;
    }

    /**
     * Decrements the number of active subscriptions for the magazine by one.
     */
    public void UnSuscriptions() {
        active_suscriptions--;
    } 
}

