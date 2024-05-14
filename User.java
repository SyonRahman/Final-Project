import java.util.ArrayList;
public class User {

    private String username;
    private int libraryid;
    private ArrayList<Books> booksrequested = new ArrayList<Books>();

    public User(String username, int libraryid) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public void addBook(Books book) {
        booksrequested.add(book);
    }

    public String getUsername() {
        return username;
    }

    public int getLibraryId() {
        return libraryid;
    }

    private ArrayList<Books> getBooksRequested() {
        return booksrequested;
    }
}
