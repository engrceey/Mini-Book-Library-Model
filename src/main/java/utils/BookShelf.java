package utils;

import model.Books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class BookShelf {

    //    allbooks use for storing all books titles and quantities
    private static final Map<String,String> allBooks = new HashMap<>();

    private static final List<Books> newBooks = new ArrayList<>();

    public List<Books> getNewBooks() {
        return newBooks;
    }

    public void setNewBooks(List<Books> newBooks) {
        BookShelf.newBooks.addAll(newBooks);
    }

    public static Map<String, String> getAllBooks() {
        return allBooks;
    }

    public String viewAllBooks() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("All Available Books");
        System.out.println("===========================================================");

        allBooks.keySet()
                .forEach(entry ->
                        System.out.println("Book Title: "+ entry+", Quantity: "+allBooks.get(entry)));

        return "printed";
    }


//    Adding new books to map using functional programming
    public Supplier<Map<String, String>> addNewBooksToShelf = () ->{
        newBooks.forEach(eachBook -> {
                    String bookTitle = eachBook.getBookTitle();
                    String bookQuantity = String.valueOf(eachBook.getQuantity());
                    allBooks.put(bookTitle, bookQuantity);
                });
        return allBooks;
    };

//    the loadBooksFromTextFile method was used to read books from file and load them to map
    public String addExistingBooksToShelf(){
        try (
                FileReader fileReader = new FileReader("books.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {

            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                String[] strArr = textLine.split("=");
                allBooks.put(strArr[0], strArr[1]);
            }
            return "Successfully added books";
        } catch (IOException e) {
            System.out.println("An Error Occurred");
        }
        return "";
    }


//    getBook method is use for querying the books container to check if a book is available and lends it
//    getBook method is also use for keeping counts of collected books
    public String getBook(String bookName) {

        try {
            if(!allBooks.containsKey(bookName)){
                System.out.println("Sorry book not Available");
                return "Sorry book not Available";
            }
            if(allBooks.containsKey(bookName.toLowerCase())) {
                if(Integer.parseInt(allBooks.get(bookName))  == 0) {
                    System.out.println("All copies have been given out");
                    return "book taken";
                }else {
                    int numOfCopies = Integer.parseInt(allBooks.get(bookName)) - 1;
                    allBooks.put(bookName,String.valueOf(numOfCopies));
                    System.out.println(allBooks.get(bookName)+" still available");
                    return allBooks.get(bookName)+" still available";
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return "error occurred";
        }
        return "executed";
    }
}
