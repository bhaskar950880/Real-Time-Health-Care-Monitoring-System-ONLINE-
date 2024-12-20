import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserRegistration {

    public static boolean registerUser(String firstName, String lastName, int age, String gender, double height, double weight, String contact, String email, String password) {
        String dbURL = "jdbc:mysql://localhost:3306/healthcare_system";
        String dbUser = "root";
        String dbPassword = "password";

        String query = "INSERT INTO users (first_name, last_name, age, gender, height, weight, contact, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, age);
            stmt.setString(4, gender);
            stmt.setDouble(5, height);
            stmt.setDouble(6, weight);
            stmt.setString(7, contact);
            stmt.setString(8, email);
            stmt.setString(9, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
