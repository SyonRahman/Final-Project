public class Admin {

    private String username;
    private int libraryid;
    private String firstname;
    private String lastname;
    private String description;


    public Admin(String username, int libraryid, String firstname, String lastname) {
        this.username = username;
        this.libraryid = libraryid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void acceptRequest() {

    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getLibraryid() {
        return libraryid;
    }
}
