public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library(); //constructs new Library object

        // Let's add a book to myLibrary
        myLibrary.addToBookList(new Book("Naked Lunch", "William Burroughs", 1959, 1));

        boolean repeatMenu = true;

        while(repeatMenu) {
            repeatMenu = myLibrary.menu();
            /* calls menu() of Library instance, which runs the program. The menu returns true as long as the user
            doesn't choose exit, in which case it returns false and the loop is terminated.*/
        }
    }
}