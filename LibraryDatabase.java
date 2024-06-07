import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Book> requestedbooks = new ArrayList<Book>();

    public void createAccount(String username, boolean isAdmin, String firstname, String lastname) {
        if (isAdmin) {
            Admin admin = new Admin(username, generateid(), firstname, lastname);
            admins.add(admin);
        } else {
            User user = new User(username, generateid(), firstname, lastname);
            users.add(user);
        }
    }

    public boolean isUsernamevalid(String username, boolean isAdmin) {
        if (isAdmin) {
            for (Admin admin : admins) {
                if (admin.getUsername().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        } else {
            for (User user : users) {
                if (user.getUsername().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addBooktoLibrary(String name, String author, int copies, int pages, String genre, int yearofpublication, String description) {
        Book book = new Book(name, author, copies, pages, genre, yearofpublication, description);
        books.add(book);
    }

    public void removeBookfromLibrary(int remove) {
        books.remove(remove);
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


    public void removeRequest(String title) {
        for (int i = 0; i < requestedbooks.size(); i++) {
            if (requestedbooks.get(i).getTitle().equalsIgnoreCase(title)) {
                requestedbooks.remove(i);
            }
        }
    }

    public void addRequest(Book book) {
        requestedbooks.add(book);
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
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getRequestedBooks() {
        return requestedbooks;
    }

}
