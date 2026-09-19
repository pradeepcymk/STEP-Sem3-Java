package string.assigment_problems;

public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(
                title + " | " + author + " | " + copiesAvailable
        );
    }

    public static void main(String[] args) {

        BookInventory book1 =
                new BookInventory("Java Programming", "James Gosling", 5);

        BookInventory book2 =
                new BookInventory("Clean Code", "Robert Martin", 3);

        BookInventory book3 =
                new BookInventory("Data Structures", "Mark Allen", 7);

        BookInventory book4 =
                new BookInventory("Computer Architecture", "John Carter", 4);

        BookInventory[] books = {
                book1, book2, book3, book4
        };

        System.out.println("Title | Author | Copies");

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}