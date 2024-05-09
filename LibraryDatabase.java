import java.util.ArrayList;

public class LibraryDatabase {
    private String username;
    private int libraryid;
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Integer> ids = new ArrayList<Integer>();

    public void createAccount(String username) {
        usernames.add(username);
        libraryid = (int)(Math.random() * 900000000 + 100000000);
        ids.add(libraryid);
    }

}
