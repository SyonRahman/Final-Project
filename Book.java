public class Book {

    private String title;
    private String author;
    private int copies;
    private int pages;
    private String genre;
    private String description;
    private int yearofpublication;

    public Book(String title, String author, int copies, int pages, String genre, int yearofpublication, String description) {
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.pages = pages;
        this.genre = genre;
        this.yearofpublication = yearofpublication;
        this.description = description;
    }
    public void changeCopies() {
        copies--;
    }

    public void addCopies() {
        copies++;
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
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
