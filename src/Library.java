import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public Library() {
    }

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public boolean menu(){

        int menyChoice;
        System.out.println("""
                1. Add a book to the library
                2. Search for a book by name
                3. List all available books
                4. List all books
                5. Return a book
                6. Quit
                """);

        menyChoice = sc.nextInt();
        sc.nextLine();
        switch (menyChoice) {
            case 1 -> {
                addNewBook();
            }
            case 2 -> {
                searchBook();
            }
            case 3 -> {
                listAvailableBooks();
            }
            case 4 -> {
                listAllBooks();
            }
            case 5 -> {
                returnBook();
            }
            case 6 -> {
                quit();
                return false;
            }

        }
        return true;
    }

    public void addNewBook() {
        System.out.println("What is the title?");
        String title = sc.nextLine();

        System.out.println("Who is the writer?");
        String writer = sc.nextLine();

        System.out.println("What year was the book printed?");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("Which edition is the book?");
        int edition = sc.nextInt();
        sc.nextLine();

        bookList.add(new Book(title, writer, year, edition));
    }

    public void addToBookList(Book book) {
        bookList.add(book);
    }



    public void searchBook() {

        String bookTitle;
        String menuChoice;

        System.out.println("Enter book title:");
        bookTitle = sc.nextLine();

        for (Book b: bookList){
            if (b.getTitle().equals(bookTitle)){
                System.out.println(b);
                System.out.println("Do you want to check out the book? y/n");
                menuChoice = sc.nextLine();
                if(menuChoice.equals("y")) {
                    if (b.loan()){
                        System.out.println("You have borrowed the book.");
                    } else {
                        System.out.println("The book is unavailable.");
                    }
                    return;
                }
            }
        }
        System.out.println("The book is not in the catalogue.");
    }

    public void listAvailableBooks() {
        if(bookList.size() == 0){
            System.out.println("There are no available books in the library");
        }
        for(Book book: bookList) {
            if (book.getAvailability()) {
                System.out.println(book);
            }
        }
    }

    public void listAllBooks() {
        for(Book book: bookList) {
            System.out.println(book);
        }
    }

    public void returnBook() {
        String bookTitle;

        System.out.println("Enter the title of the book you want to return.");
        bookTitle = sc.nextLine();

        for(Book book: bookList) {
            if (book.getTitle().equals(bookTitle)) {
                if (book.returnBook()) {
                    System.out.println(book.getTitle() + " is returned.");
                } else {
                    System.out.println("The book is not loaned!");
                }
                return;
            }
        }
        System.out.println("The book is not in the catalogue.");

    }

    static void quit() {
        System.exit(0);
    }
}

