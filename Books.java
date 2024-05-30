public class Books {

    private String name;
    private String author;
    private int copies;
    private int pages;
    private String genre;
    private int yearofpublication;

    public Books(String name, String author, int copies, int pages, String genre, int yearofpublication) {
        this.name = name;
        this.author = author;
        this.copies = copies;
        this.pages = pages;
        this.genre = genre;
        this.yearofpublication = yearofpublication;
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

    public String getGenre() {
        return genre;
    }

    public int getYearofpublication() {
        return yearofpublication;
    }

}
