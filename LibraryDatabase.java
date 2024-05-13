import java.lang.reflect.Array;
import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<User> users = new ArrayList<User>();

    public boolean createAccount(String username, boolean isAdmin) {
        if (isAdmin) {
            if (isUsernamevalid(username, isAdmin)) {
                Admin admin = new Admin(username, generateid());
                admins.add(admin);
                return true;
            } else {
                return false;
            }
        } else {
            if (isUsernamevalid(username, isAdmin)) {
                User user = new User(username, generateid());
                users.add(user);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isUsernamevalid(String username, boolean isAdmin) {
        if (isAdmin) {
            for (Admin admin : admins) {
                if (admin.getUsername().equals(username)) {
                    return false;
                }
            }
        } else {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int generateid() {
        return (int)(Math.random() * 900000000 + 100000000);
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
