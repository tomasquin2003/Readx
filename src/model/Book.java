package model;

import java.util.Calendar;

/**
 * Represents a book, which is a type of bibliographic product.
 */
public class Book extends Biliographic_product {

    private String book_review;
    private Book_genre book_genre;
    private int sold_bookUnits;

    /**
     * Constructs a Book object with the specified properties.
     *
     * @param product_id       The ID of the book.
     * @param product_name     The name of the book.
     * @param pages_number     The number of pages in the book.
     * @param publication_date The publication date of the book.
     * @param pages_read       The number of pages read in the book.
     * @param product_cost     The cost of the book.
     * @param product_url      The URL of the book.
     * @param book_review      The review of the book.
     * @param book_genre       The genre of the book.
     * @param sold_bookUnits   The number of book units sold.
     */
    public Book(String product_id, String product_name, int pages_number, Calendar publication_date, int pages_read, double product_cost, String product_url, String book_review, Book_genre book_genre, int sold_bookUnits) {
        super(product_id, product_name, pages_number, publication_date, pages_read, product_cost, product_url);
        this.book_review = book_review;
        this.book_genre = book_genre;
        this.sold_bookUnits = sold_bookUnits;
    }

    /**
     * Retrieves the review of the book.
     *
     * @return The book review.
     */
    public String getBook_review() {
        return book_review;
    }

    /**
     * Sets the review of the book.
     *
     * @param book_review The book review to set.
     */
    public void setBook_review(String book_review) {
        this.book_review = book_review;
    }

    /**
     * Retrieves the genre of the book.
     *
     * @return The book genre.
     */
    public Book_genre getBook_genre() {
        return book_genre;
    }

    /**
     * Retrieves the number of book units sold.
     *
     * @return The number of book units sold.
     */
    public int getSold_bookUnits() {
        return sold_bookUnits;
    }

    /**
     * Sets the number of book units sold.
     *
     * @param sold_bookUnits The number of book units sold to set.
     */
    public void setSold_bookUnits(int sold_bookUnits) {
        this.sold_bookUnits = sold_bookUnits;
    }

    /**
     * Increases the number of book units sold by 1.
     */
    public void bookUnits() {
        sold_bookUnits++;
    }
}


