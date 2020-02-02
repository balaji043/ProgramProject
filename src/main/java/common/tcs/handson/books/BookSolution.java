package common.tcs.handson.books;

import java.util.Scanner;

public class BookSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4;
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++)
            books[i] = new Book(scanner.next(), scanner.nextInt()
                    , scanner.nextInt(), scanner.next());
        Book combinedBooks = getCombinedBooks(books);
        System.out.println(combinedBooks.toString());
    }

    private static Book getCombinedBooks(Book[] books) {

        StringBuilder title = new StringBuilder(), author = new StringBuilder();
        int id = 0, pages = 0, n = books.length;

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                title.append(books[i].getTitle()).append("#");
                author.append(books[i].getAuthor()).append("#");
            } else {
                title.append(books[i].getTitle());
                author.append(books[i].getTitle());
            }
            if (id < books[i].getId()) id = books[i].getId();
            pages += books[i].getPages();
        }

        return new Book(title.toString(), id + 1, pages, author.toString());
    }

}
