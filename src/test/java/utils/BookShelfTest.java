package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookShelfTest {

    @Test
    @DisplayName("Queries map for Book")
    void testGetBook() {
        BookShelf bookShelf = new BookShelf();
        Librarian librarian = new Librarian("Ik","0089");
        librarian.loadShelfWithExistingBooks();

        assertEquals("book taken",bookShelf.getBook("the hobbit"));
        assertEquals("3 still available",bookShelf.getBook("the lion the witch"));
        assertEquals("2 still available",bookShelf.getBook("the diary of anne frank"));
        assertEquals("2 still available",bookShelf.getBook("the hunger games"));


    }

    @Test
    void viewAllBooks() {

        BookShelf bookShelf = new BookShelf();
        Librarian librarian = new Librarian("Ik","0089");
        librarian.loadShelfWithExistingBooks();
        assertEquals("printed",bookShelf.viewAllBooks());
    }

    @Test
    void addExistingBooksToShelf() {
        BookShelf bookShelf = new BookShelf();
        Librarian librarian = new Librarian("Ik","0089");
        librarian.loadShelfWithExistingBooks();
        assertEquals("Successfully added books",bookShelf.addExistingBooksToShelf());
    }


}