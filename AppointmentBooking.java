
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentBooking {

    public static boolean isDoctorAvailable(int doctorId, String appointmentDate) {
        String dbURL = "jdbc:mysql://localhost:3306/healthcare_system";
        String dbUser = "root";
        String dbPassword = "password";

        String query = "SELECT * FROM appointments WHERE doctor_id = ? AND appointment_date = ?";
        
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctorId);
            stmt.setString(2, appointmentDate);

            ResultSet rs = stmt.executeQuery();
            return !rs.next(); // returns true if no appointment exists on that date

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean bookAppointment(int userId, int doctorId, String appointmentDate) {
        if (isDoctorAvailable(doctorId, appointmentDate)) {
            String dbURL = "jdbc:mysql://localhost:3306/healthcare_system";
            String dbUser = "root";
            String dbPassword = "password";

            String query = "INSERT INTO appointments (user_id, doctor_id, appointment_date) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, userId);
                stmt.setInt(2, doctorId);
                stmt.setString(3, appointmentDate);

                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
