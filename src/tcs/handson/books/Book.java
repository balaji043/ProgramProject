
public class Book {
    private String title;
    private int id;
    private int pages;
    private String author;

    public Book() {

    }

    public Book(String title, int id, int pages, String author) {
        this.title = title;
        this.id = id;
        this.pages = pages;
        this.author = author;
    }

    String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    int getPages() {
        return pages;
    }

    String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + "\n" + id + "\n" + pages + "\n" + author;
    }
}
