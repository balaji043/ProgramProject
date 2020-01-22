package java.tcs.handson.certificates;

public class Certificate {
    private int id;
    private String title;
    private String date;
    private int rank;

    public Certificate(int id, String title, String date, int rank) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.rank = rank;
    }

    String getTitle() {
        return title;
    }

    String getDate() {
        return date;
    }

    int getRank() {
        return rank;
    }

    int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Certificates.Certificate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", rank=" + rank +
                '}';
    }
}
