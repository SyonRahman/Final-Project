public class Admin {

    private String username;
    private int libraryid;

    public Admin(String username, int libraryid) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public String getUsername() {
        return username;
    }

    public int getLibraryid() {
        return libraryid;
    }
}
