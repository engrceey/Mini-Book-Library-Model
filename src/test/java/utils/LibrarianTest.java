package utils;

import model.LibraryUsers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibrarianTest {


    @Test
    void displayAllBooks() {
        BookShelf bookShelf = new BookShelf();
        Librarian librarian = new Librarian("Ik","0089");
        librarian.loadShelfWithExistingBooks();
        assertEquals("printed",bookShelf.viewAllBooks());
    }

    @Test
    void testLendBookByPriority() throws IOException {
        Librarian librarian = new Librarian("Ik","0089");
        RequestCatalogue bookRequest = new RequestCatalogue();

        List<LibraryUsers> sameBookRequest = Arrays.asList(
                new LibraryUsers("Senior Student", "peter", "lib042", 2, "the hobbit"),
                new LibraryUsers("Junior student", "philip", "lib032", 3, "the hobbit"),
                new LibraryUsers("Teacher", "John", "lib012", 1, "the hobbit")
        );
        bookRequest.setCatalogue1(sameBookRequest);

        assertEquals("the hobbit",librarian.lendBookByPriority());

    }

    @Test
    void testLendBookFirstComeFirstServe() {
        Librarian librarian = new Librarian("Ik","0089");
        RequestCatalogue bookRequest = new RequestCatalogue();

        List<LibraryUsers> differentBookRequest = Arrays.asList(
                new LibraryUsers("Senior Student", "peter", "lib042", 2, "charlotte"),
                new LibraryUsers("Junior student", "philip", "lib032", 3, "the hobbit"),
                new LibraryUsers("Teacher", "John", "lib012", 1, "animal farm")
        );
        bookRequest.setCatalogue2(differentBookRequest);

        assertEquals("charlotte",librarian.lendBookFirstComeFirstServe());
    }
}