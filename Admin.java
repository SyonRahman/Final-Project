public class Admin {

    private String username;
    private int libraryid;
    private String description;

    public Admin(String username, int libraryid) {
        this.username = username;
        this.libraryid = libraryid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getLibraryid() {
        return libraryid;
    }
}
