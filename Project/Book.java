import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private LocalDate lastTakenOut;
    private LocalDate dueDate;
    private boolean isAvailable; // Track availability

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.lastTakenOut = null;
        this.dueDate = null;
        this.isAvailable = true; // Initially, the book is available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getLastTakenOut() {
        return lastTakenOut;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false; // Mark as unavailable
        } else {
            System.out.println("This book is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true; // Mark as available when returned
        // lastTakenOut = null; // Reset last taken out
        // dueDate = null; // Reset due date
    }

    @Override
    public String toString() {
        String availability = isAvailable ? "Available" : "Currently Unavailable";
        return String.format("\"%s\" by %s - %s", title, author, availability);
    }
}
