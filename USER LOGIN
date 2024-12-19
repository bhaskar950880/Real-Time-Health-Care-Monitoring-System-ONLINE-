
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {

    public static boolean authenticateUser(String email, String password) {
        String dbURL = "jdbc:mysql://localhost:3306/healthcare_system";
        String dbUser = "root";
        String dbPassword = "password";

        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // returns true if a record is found

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
