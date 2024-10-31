import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 1L; // for verification purposes
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthDay;
    private final List<Book> borrowedBooks = new ArrayList<>(); // Use List for flexibility

    public User(String name, String email, String password, String birthDay) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDay = LocalDate.parse(birthDay);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDay() {
        return birthDay.toString();
    }

    public int age() {
        Period age = Period.between(birthDay, LocalDate.now());
        return age.getYears();
    }

    // To borrow books
    public void borrow(Book book) {
        if (borrowedBooks.size() < 3) { // Limits to 3 books
            borrowedBooks.add(book);
            System.out.printf("%s has borrowed \"%s\" by %s\n", name, book.getTitle(), book.getAuthor());
        } else {
            System.out.println("You cannot borrow more than 3 books.");
        }
    }
    // To return books
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            System.out.printf("%s has returned \"%s\" by %s\n", name, book.getTitle(), book.getAuthor());
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); // List
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password); //pwd check for login
    }
}
