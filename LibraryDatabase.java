import java.lang.reflect.Array;
import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<User> users = new ArrayList<User>();

    public void createAccount(String username, boolean isAdmin) {
        if (isAdmin) {
            Admin admin = new Admin(username, generateid());
            admins.add(admin);
        } else {
            User user = new User(username, generateid());
            users.add(user);
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

    public boolean IDandUsermatch(String user, int id, boolean isAdmin) {
        if (isAdmin) {
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).getUsername().equals(user) && admins.get(i).getLibraryid() == id) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(user) && users.get(i).getLibraryId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void modifydetails(String description, String username, int id, boolean isAdmin) {
        if (isAdmin) {
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).getUsername().equals(username) && admins.get(i).getLibraryid() == id) {
                    admins.get(i).setDescription(description);
                    admins.get(i).setUsername(username);
                    break;
                }
            }
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getLibraryId() == id) {
                    users.get(i).setDescription(description);
                    users.get(i).setUsername(username);
                    break;
                }
            }
        }
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
