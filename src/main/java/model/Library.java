package model;

import utils.BookShelf;
import utils.Librarian;

public class Library {
    private LibraryUsers libraryUsers;
    private final BookShelf bookShelf;
    private final Librarian librarian;
    private final Books books;

    public Library(LibraryUsers libraryUsers, BookShelf bookShelf, Librarian librarian, Books books) {
        this.libraryUsers = libraryUsers;
        this.bookShelf = bookShelf;
        this.librarian = librarian;
        this.books = books;
    }

    public LibraryUsers getLibraryUsers() {
        return libraryUsers;
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Books getBooks() {
        return books;
    }

    public void setLibraryUsers(LibraryUsers libraryUsers) {
        this.libraryUsers = libraryUsers;
    }
}
