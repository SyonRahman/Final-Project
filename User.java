import java.util.ArrayList;
public class User {

    private String username;
    private int libraryid;
    private ArrayList<Books> books = new ArrayList<Books>();

    public User(String username, int libraryid) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public String getUsername() {
        return username;
    }

    public int getLibraryId() {
        return libraryid;
    }
}
