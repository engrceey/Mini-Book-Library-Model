package utils;

import model.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Librarian extends Person implements lendByPriority, LendByFirstComeFirstServe {

    public Librarian(String name, String libraryCardId) {
        super(name, libraryCardId);
    }

    public void loadShelfWithExistingBooks() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addExistingBooksToShelf();
    }

    public void loadShelfWithNewBooks() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addNewBooksToShelf.get();
    }

    public void displayAllBooks() throws IOException {
        BookShelf bookShelf = new BookShelf();
        bookShelf.viewAllBooks();
    }

    @Override
    public String lendBookByPriority() throws IOException {
        try {

            Queue<LibraryUsers> priorityQueue = new PriorityQueue<>(11, new CompareUsers());
            priorityQueue.addAll(RequestCatalogue.catalogue1);

            String book = Objects.requireNonNull(priorityQueue.poll()).getBookRequest();
            System.out.println("book request accepted: "+book);
            return book;

        }catch (Exception ex) {
            ex.printStackTrace();
            return "No such book";
        }
    }

    @Override
    public String lendBookFirstComeFirstServe() {

        try {

            Queue<LibraryUsers> queues = new LinkedList<>(RequestCatalogue.catalogue2);
            queues.addAll(RequestCatalogue.catalogue2);

            String book = Objects.requireNonNull(queues.poll()).getBookRequest();
            System.out.println("book request accepted: "+book);

            return book;
        }catch (Exception ex) {
            ex.printStackTrace();
            return "No such book";
        }

    }
}
