public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.addToBookList(new Book("Naked Lunch", "William Burroughs", 1959, 1));

        boolean repeatMenu = true;

        while(repeatMenu) {
            repeatMenu = myLibrary.menu();
        }
    }
}