import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private UserDatabase userDatabase; // Assuming you have a UserDatabase class
    private List<Book> books;

    public LibraryDatabase() {
        userDatabase = new UserDatabase(); // Initialize user database
        books = new ArrayList<>(); // Initialize the list of books
        initializeBooks(); // Optionally, populate the library with some books
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public List<Book> getAvailableBooks() {
        return books; // Return the list of available books
    }

    private void initializeBooks() {
        // Example of adding some books to the library
        books.add(new Book("Harry Potter", "J.K. Rowling"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    public void addBook(Book book) {
        books.add(book); // Method to add a new book to the library
    }
}
