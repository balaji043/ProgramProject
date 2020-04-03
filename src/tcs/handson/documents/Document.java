
public class Document {
    private String id;
    private String title;
    private String folderName;
    private int pages;

    Document(String id, String title, String folderName, int pages) {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFolderName() {
        return folderName;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", folderName='" + folderName + '\'' +
                ", pages=" + pages +
                '}';
    }
}
