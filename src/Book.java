public class Book {
    private String title; // Maybe I should make the variables final, or maybe I should add methods to edit them, to be
                          // able to correct input errors?
    private String writer;
    private int year;
    private int edition;
    private boolean availabilityStatus;

    public Book(String title, String writer, int year, int edition){
        // Basic constructor, needs all info for the Book instance
        this.title = title;
        this.writer = writer;
        this.year = year;
        this.edition = edition;
        this.availabilityStatus = true;
    }

    public boolean loan(){
        // if the book is available, it is loaned (availabilityStatus is set to false).
        // If the loan is successful, the method returns true. Otherwise, false is returned.
        if(this.availabilityStatus) {
            this.availabilityStatus = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        // if the book is loaned, it is returned and the method returns true,
        // otherwise the method returns false.
        if(!this.availabilityStatus) {
            this.availabilityStatus = true;
            return true;
        }
        return false;
    }

    public String getTitle() {
        // Not very exciting getter-method. Since the title variable is private, we need it.
        return title;
    }

    public boolean getAvailability() {
        return availabilityStatus;
    }

    public String toString() {
        // makes the Book printable!
        return "Title: " +title + "\n" +
                "Writer: " + writer + "\n" +
                "Year: " + year + "\n" +
                "Edition: " + edition + "\n" +
                "Available: " + availabilityStatus + "\n";

    }
}

