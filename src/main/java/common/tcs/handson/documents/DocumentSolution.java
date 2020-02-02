package common.tcs.handson.documents;

public class DocumentSolution {


    public static void main(String[] args) {
        Document[] documents = new Document[2];
        documents[0] = new Document("1", "aaa", "a", 20);
        documents[1] = new Document("2", "bbb", "b", 30);
        for (Document document : documents) System.out.println(document.toString());
    }

}
