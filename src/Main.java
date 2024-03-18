import java.util.*;

// Object class
class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    // Encapsulation: Password tidak bisa diakses langsung
    private String getPassword() {
        return password;
    }
    
    // Polymorphism: Notifikasi
    public void sendNotification(String message) {
        System.out.println("Notification for user " + getUsername() + ": " + message);
    }
}

// Inheritance: Admin extends User
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
    
    // Polymorphism: Notifikasi
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification for admin " + getUsername() + ": " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome!");
        System.out.println("1. Register\n2. Admin create user\n3. Exit");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (option) {
            case 1:
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                
                // Polymorphism: User registration
                User user = new User(username, password);
                System.out.println("Registration successful for user: " + user.getUsername());
                break;
            case 2:
                System.out.print("Enter admin username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter admin password: ");
                String adminPassword = scanner.nextLine();
                
                // Authenticating admin
                if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
                    System.out.print("Enter new user username: ");
                    String newUser = scanner.nextLine();
                    
                    // Polymorphism: Admin creates user
                    Admin admin = new Admin(newUser, "password123");
                    admin.sendNotification("New user created by admin");
                    System.out.println("User created by admin: " + admin.getUsername());
                } else {
                    System.out.println("Authentication failed for admin.");
                }
                break;
            case 3:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid option. Exiting program...");
                break;
        }
        
        scanner.close();
    }
}