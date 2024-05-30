import java.lang.reflect.Array;
import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Books> books = new ArrayList<Books>();

    public void createAccount(String username, boolean isAdmin, String firstname, String lastname) {
        if (isAdmin) {
            Admin admin = new Admin(username, generateid());
            admins.add(admin);
        } else {
            User user = new User(username, generateid(), firstname, lastname);
            users.add(user);
        }
    }

    public boolean isUsernamevalid(String username, boolean isAdmin) {
        if (isAdmin) {
            for (Admin admin : admins) {
                if (admin.getUsername().equals(username)) {
                    return true;
                }
            }
        } else {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addBooktoLibrary(String name, String author, int copies, int pages, String genre, int yearofpublication) {
        Books book = new Books(name, author, copies, pages, genre, yearofpublication);
        books.add(book);
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

    public void addBook(String username, int id, Books book) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getLibraryId() == id) {
                users.get(i).addBook(book);
                break;
            }
        }
    }

    public void removeBook(String username, int id, Books book) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getLibraryId() == id) {
                users.get(i).removeBook(book);
                break;
            }
        }
    }

    public void acceptRequest() {
        for (int i = 0; i < admins.size(); i++) {
            admins.get(i).acceptRequest();
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
    public ArrayList<Books> getBooks() {
        return books;
    }

}
