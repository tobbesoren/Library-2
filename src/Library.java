import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookList = new ArrayList<>(); // Holds the Books!
    private final Scanner sc = new Scanner(System.in); // A scanner object to read user input.

    public Library() {
        // A most minimal constructor...
        // Books need to be added manually
    }

    public Library(ArrayList<Book> bookList) {
        // an alternative constructor. Use it to add an ArrayList of Book objects to the new Library instance.
        this.bookList = bookList;
    }

    public boolean menu(){
        /* A meny for the Library object. Returns true if the menu should run again, and false if the user chooses to
        exit the program.
         */

        int menyChoice;
        System.out.println("""
                1. Add a book to the library
                2. Search for a book by name
                3. List all available books
                4. List all books
                5. Return a book
                6. Quit
                """);

        menyChoice = sc.nextInt(); // the scanner object is used to get input from user. No error handling; the user
        // better be entering valid menu choices or the program will crash! Maybe I'll fix that...
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
                return false;
            }

        }
        return true;
    }

    public void addNewBook() {
        // Gets user input to create new Book object and adds it to the Library

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
        // can be used to add a previously created Book to the Library.
        bookList.add(book);
    }

    public void searchBook() {
        // Lets the user search for a book, and, if found, lets them try to loan() it. This will succeed if the book is
        // available, otherwise the user will be told that the book is unavailable.

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
        // Lists all Books that aren't loaned. Uses, implicitly, toString().
        // If there are no available books, the user is told so.
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
        // Simply prints all books, available or not.
        for(Book book: bookList) {
            System.out.println(book);
        }
    }

    public void returnBook() {
        // Lets the user return a loaned book. If the book isn't loaned, the user will be told so. If the book doesn't
        // exist in the library, the user will be told so.
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
}

