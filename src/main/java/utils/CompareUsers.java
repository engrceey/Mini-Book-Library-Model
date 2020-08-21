package utils;

import model.LibraryUsers;

import java.util.Comparator;

public class CompareUsers implements Comparator<LibraryUsers> {

    @Override
    public int compare(LibraryUsers o1, LibraryUsers o2) {
        return Integer.compare(o1.getRank(),o2.getRank());
    }
}
