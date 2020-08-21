package utils;

import model.LibraryUsers;

import java.util.ArrayList;
import java.util.List;

public class RequestCatalogue {

    private String requestBook;

    /**
     * catalogue1 list is used for collecting users request, when they are asking for same book
     * catalogue2 list is used for collecting users request, when they are asking for different books
     */
    protected static List<LibraryUsers> catalogue1 = new ArrayList<>();
    protected static List<LibraryUsers> catalogue2 = new ArrayList<>();


    public List<LibraryUsers> getCatalogue1() {
        return catalogue1;
    }

    public List<LibraryUsers> getCatalogue2() {
        return catalogue2;
    }

    public String getRequestBook() {
        return requestBook;
    }

    public void setCatalogue1(List<LibraryUsers> catalogue1) {
        RequestCatalogue.catalogue1 = catalogue1;
    }

    public void setCatalogue2(List<LibraryUsers> catalogue2) {
        RequestCatalogue.catalogue2 = catalogue2;
    }
}
