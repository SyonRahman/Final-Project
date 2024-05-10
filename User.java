public class User {

    private String username;
    private int libraryid;

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
