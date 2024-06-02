import java.util.ArrayList;
public class User {

    private String username;
    private int libraryid;
    private String description;
    private String firstname;
    private String lastname;
    private ArrayList<Book> booksowned = new ArrayList<>();

    public User(String username, int libraryid, String firstname, String lastname) {
        this.username = username;
        this.libraryid = libraryid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addBook(Book book) {
        booksowned.add(book);
    }

    public void removeBook(String title) {
        for (int i = 0; i < booksowned.size(); i++) {
            if (booksowned.get(i).getTitle().equals(title)) {
                booksowned.remove(i);
            }
        }
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

    public ArrayList<Book> getBooksowned() {
        return booksowned;
    }
}
