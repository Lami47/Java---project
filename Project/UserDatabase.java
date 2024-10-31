import java.util.ArrayList;
import java.util.List;

import java.io.Serializable; //
import java.io.FileInputStream; // writing to the storage
import java.io.FileOutputStream; // reading the storage
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;


public class UserDatabase implements Serializable {
    private static final long serialVersionUID = 1L; // for login storage and access
    private List<User> users; // List to store user accounts
    private static final String USER_DATA_FILE = "users.dat"; // File to store user data

    public UserDatabase() {
        users = new ArrayList<>(); // Initialize the list of users
        loadUsers(); // Load users from the file at initialization
    }

    public void registerUser(String name, String email, String password, String birthDay) {
        User newUser = new User(name, email, password, birthDay);
        users.add(newUser); // Add the new user to the list
        saveUsers(); // Save the updated list of users to the file
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.checkPassword(password)) {
                return user; // Return the user if email and password match
            }
        }
        return null; // if no match is found
    }

    public boolean userExists(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email)); // Check if user exists
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            oos.writeObject(users); // Write the list of users to the file
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA_FILE))) {
            users.clear(); // Clear the existing user list
            users.addAll((List<User>) ois.readObject()); // Load users from the file
        } catch (FileNotFoundException e) {
            // File does not exist, can be ignored
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle other exceptions
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users); // Return a copy of the user list
    }
}
