package model;


public class LibraryUsers extends Person {
    private final String position;
    private final String name;
    private String bookRequest;
    private int rank;

    public LibraryUsers(String position, String name, String libraryCardId, int rank, String bookRequest) {
        super(name , libraryCardId);
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.bookRequest = bookRequest;
    }

    public int getRank() {
        return rank;
    }

    public String getBookRequest() {
        return bookRequest;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setBookRequest(String bookRequest) {
        this.bookRequest = bookRequest;
    }

    @Override
    public String toString() {
        return "LibraryUsers{" +
                "position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", bookRequest='" + bookRequest + '\'' +
                ", rank=" + rank +
                '}';
    }
}
