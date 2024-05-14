public class Books {

    private String name;
    private int copies;
    private int pages;
    private String genre;
    private double width;
    private double height;
    private int yearofpublication;

    public Books(String name, int copies, int pages, double width, double height) {
        this.name = name;
        this.copies = copies;
        this.pages = pages;
        this.width = width;
        this.height = height;
    }
    public void changeCopies() {
        copies--;
    }

    public void addCopies(int copies) {
        this.copies += copies;
    }

    public void additionalInformation(String genre, int yearofpublication) {
        this.genre = genre;
        this.yearofpublication = yearofpublication;
    }

    public String getName() {
        return name;
    }

    public int getCopies() {
        return copies;
    }

    public int getPages() {
        return pages;
    }

}
