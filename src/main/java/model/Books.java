package model;

public class Books {
    private String bookTitle;
    private String bookAuthor;
    private int publicationYear;
    private int quantity;

    public Books(String bookTitle, String bookAuthor, int publicationYear, int quantity) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
