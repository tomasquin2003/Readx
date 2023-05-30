package model;

/**
 * Interface for managing bibliographic products.
 */
public interface getBiblioProduct {

    /**
     * Adds a bibliographic product to the system.
     *
     * @param product The bibliographic product to be added.
     * @return true if the product was successfully added, false otherwise.
     */
    public boolean addProducts(Biliographic_product product);
}

