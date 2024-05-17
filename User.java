import java.util.ArrayList;
public class User {

    private String username;
    private int libraryid;
    private String description;
    private ArrayList<Books> booksrequested = new ArrayList<Books>();

    public User(String username, int libraryid) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public void addBook(Books book) {
        booksrequested.add(book);
    }

    public void removeBook(Books book) {
        for (int i = booksrequested.size(); i >= 0; i--) {
            if (booksrequested.get(i).getName().equals(book.getName())) {
                booksrequested.remove(i);
                break;
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

    private ArrayList<Books> getBooksRequested() {
        return booksrequested;
    }
}
