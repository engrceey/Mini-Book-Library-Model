import model.Books;
import utils.BookShelf;
import utils.Librarian;
import model.LibraryUsers;
import utils.RequestCatalogue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf();

//      Users can add new books to bookShelf using addNewBooksToShelf list
        List<Books> addNewBooksToShelf = Arrays.asList(
                new Books("meditations","marcus",1884,4),
                new Books("get Rich","Peter cruz",1980,3),
                new Books("aladine","Gary stov", 1779,1),
                new Books("new world","Morgan Freeman",2003,6),
                new Books("state of Nation","Obasanjo",2006, 3)
        );
        bookShelf.setNewBooks(addNewBooksToShelf);


        RequestCatalogue bookRequest = new RequestCatalogue();

//        Users can register and request for any book using a list
        List<LibraryUsers> sameBookRequest = Arrays.asList(
                new LibraryUsers("Senior Student", "peter", "lib042", 2, "the hobbit"),
                new LibraryUsers("Junior student", "philip", "lib032", 3, "the hobbit"),
                new LibraryUsers("Teacher", "John", "lib012", 1, "the hobbit")
        );
        bookRequest.setCatalogue1(sameBookRequest);


//        Users can register and request for any book using a list
        List<LibraryUsers> differentBookRequest = Arrays.asList(
                new LibraryUsers("Senior Student", "peter", "lib042", 2, "charlotte"),
                new LibraryUsers("Junior student", "philip", "lib032", 3, "the hobbit"),
                new LibraryUsers("Teacher", "John", "lib012", 1, "animal farm")
        );
        bookRequest.setCatalogue2(differentBookRequest);


        Librarian librarian = new Librarian("Varis","lib033");

//        Main navigation into app, switch statement gives some functional actions of the program
        try {
            librarian.loadShelfWithExistingBooks();
            librarian.loadShelfWithNewBooks();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Press One(1) to view All available books");
            System.out.println("Press Two(2) to make book request by Priority");
            System.out.println("Press Three(3) to make book request by first come");
            System.out.println("Press Four(4) to get total number of books available");
            System.out.println("Press Five(5) make book request");
            System.out.println("Enter Number : ");

            int reply = scanner.nextInt();

//            switch statement gives some functional actions of the program
            switch (reply) {
                case 1 :
                    librarian.loadShelfWithNewBooks();
                    librarian.displayAllBooks();

                    break;
                case 2 :
                    librarian.lendBookByPriority();
                    break;
                case 3 :
                    librarian.lendBookFirstComeFirstServe();
                    break;
                case 4 :
                    librarian.loadShelfWithNewBooks();
                    int totalBooks = BookShelf.getAllBooks()
                            .values()
                            .stream()
                            .filter(s -> Integer.parseInt(s) > 0)
                            .mapToInt(Integer::parseInt)
                            .sum();

                    System.out.println("Total Quantity of books in Library: "+totalBooks);
                    break;
                case 5 :
                    Scanner scr = new Scanner(System.in);
                    System.out.println("Enter title of book to borrow: ");
                    String bookname = scr.nextLine();
                    bookShelf.getBook(bookname);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error occurred...");
        }

        System.out.println();
    }
}
