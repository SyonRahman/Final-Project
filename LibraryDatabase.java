import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Integer> ids = new ArrayList<Integer>();
    private boolean admin;
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<User> users = new ArrayList<User>();

    public void createAccount(String username, boolean isAdmin) {
        if (isAdmin) {
            Admin admin = new Admin(username, ids.size());
            admins.add(admin);
        } else {
            User user = new User(username, ids.size());
            users.add(user);
        }
    }

    public boolean isUsernamevalid(String username) {
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username)) {
                return false;
            }
        }
        return true;
    }

}
