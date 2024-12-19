Real-Time Health Care Monitoring System (ONLINE) Backend
This project is the backend implementation of a real-time healthcare monitoring system, using Java, MySQL, JDBC, Eclipse, and Tomcat Server. It includes features such as patient health data tracking, appointment scheduling, doctor management, and admin oversight.

Table of Contents
Project Setup
Requirements
How to Run the Project
Database Schema
API Endpoints
Error Handling
Contributing
Project Setup
1. Clone the Repository
bash
Copy code
git clone https://github.com/bhaskar950880/Real-Time-Health-Care-Monitoring-System-ONLINE-.git
cd Real-Time-Health-Care-Monitoring-System-ONLINE
2. Set Up the Database
Install MySQL: Ensure MySQL is installed on your system. You can download it from MySQL's official website.

Create the Database:

sql
Copy code
CREATE DATABASE IF NOT EXISTS healthcare_monitoring;
USE healthcare_monitoring;
Run the SQL Script: Execute the SQL script provided in the sql directory to create the necessary tables.

sql
Copy code
-- Drop existing tables if they exist
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS doctor_schedule;
DROP TABLE IF EXISTS health_data;

-- Create tables
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role ENUM('patient', 'doctor', 'admin') NOT NULL
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_time DATETIME NOT NULL,
    status ENUM('pending', 'completed', 'cancelled') NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE doctor_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT NOT NULL,
    available_time DATETIME NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE health_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    heart_rate INT,
    blood_pressure VARCHAR(50),
    temperature DECIMAL(5, 2),
    recorded_at DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
3. Set Up Eclipse
Install Eclipse: Download and install Eclipse IDE for Java Developers from Eclipse's official website.

Import the Project:

Open Eclipse.
Go to File > Import.
Select General > Existing Projects into Workspace.
Browse to the cloned repository and select the project.
Click Finish.
4. Set Up Tomcat Server
Install Tomcat: Download and install Apache Tomcat from Tomcat's official website.

Configure Tomcat in Eclipse:

Go to Window > Preferences > Server > Runtime Environments.
Click Add and select Apache Tomcat.
Browse to the Tomcat installation directory and click Finish.
Add Tomcat Server:

Go to Window > Show View > Servers.
Right-click in the Servers view and select New > Server.
Select the Tomcat server you configured and click Finish.
5. Configure Database Connection
Update the DatabaseConnection.java file with your MySQL database credentials:

java
Copy code
package com.healthcare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/healthcare_monitoring";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }
    }
}
Requirements
Java Development Kit (JDK) 8 or higher
MySQL Server 5.7 or higher
Eclipse IDE for Java Developers
Apache Tomcat 9.0 or higher
MySQL Connector/J (included in the project)
How to Run the Project
Start MySQL Server: Ensure your MySQL server is running.

Deploy the Project:

Right-click on the project in Eclipse.
Select Run As > Run on Server.
Choose the Tomcat server you configured and click Finish.
Access the Application:

Open your web browser and go to http://localhost:8080/healthcare-monitoring-system.
Database Schema
The database schema includes the following tables:

users: Stores user information, including roles (patient, doctor, admin).
appointments: Stores patient-appointment records.
doctor_schedule: Stores the doctor's available times.
health_data: Stores health data like heart rate, blood pressure, and temperature.
API Endpoints
Users
POST /users/create: Create a new user.
Request Body: { "username": "patient1", "password": "pass123", "email": "patient1@example.com", "role": "patient" }
GET /users/{username}: Get user by username.
PUT /users/{id}: Update user information.
DELETE /users/{id}: Delete user by ID.
Appointments
POST /appointments/create: Create a new appointment.
Request Body: { "patientId": 1, "doctorId": 2, "appointmentTime": "2024-12-20 10:00:00" }
GET /appointments/{id}: Get appointment by ID.
PUT /appointments/{id}: Update appointment status.
DELETE /appointments/{id}: Delete appointment by ID.
Doctor Schedule
POST /doctor-schedule/create: Add a new doctor's available time.
Request Body: { "doctorId": 2, "availableTime": "2024-12-20 09:00:00" }
GET /doctor-schedule/{doctorId}: Get the schedule for a specific doctor.
DELETE /doctor-schedule/{id}: Delete a schedule by ID.
Health Data
POST /health-data/add: Add new health data for a user.
Request Body: { "userId": 1, "heartRate": 72, "bloodPressure": "120/80", "temperature": 36.5, "recordedAt": "2024-12-19 09:00:00" }
GET /health-data/{userId}: Get health data for a specific user.
DELETE /health-data/{id}: Delete health data by ID.
Error Handling
The project includes error handling for database-related errors and general exceptions. Specific errors such as duplicate username or email are caught and handled gracefully.

