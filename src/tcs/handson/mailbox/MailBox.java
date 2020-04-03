
public class MailBox {
    private int id;
    private String name;
    private String creationDate;

    public MailBox(int id, String name, String creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "" + id + " " + name + " " + creationDate;
    }
}
