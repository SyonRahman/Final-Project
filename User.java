import java.util.ArrayList;
public class User {

    private String username;
    private int libraryid;
    private String description;
    private String firstname;
    private String lastname;
    private ArrayList<Books> booksrequested = new ArrayList<>();
    private ArrayList<Books> booksowned = new ArrayList<>();

    public User(String username, int libraryid, String firstname, String lastname) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public void addBook(Books book) {
        booksowned.add(book);
    }

    public void removeBook(Books book) {
        for (int i = booksowned.size(); i >= 0; i--) {
            if (booksowned.get(i).getName().equals(book.getName())) {
                booksowned.remove(i);
                break;
            }
        }
    }

    public void requestBook(Books book) {
        booksrequested.add(book);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private ArrayList<Books> getBooksowned() {
        return booksowned;
    }
}
