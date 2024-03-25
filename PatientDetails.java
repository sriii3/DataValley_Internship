import java.sql.*;

public class PatientDetails {
    public static void main(String[] args) {
        try {
            // first step: Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // second step: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "databasepassword");

            // third step: Create a statement
            Statement statement = connection.createStatement();

            // forth step: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT patientid, patientname, patientproblem, bill FROM patients");

            // fifth step: Process the results
            while (resultSet.next()) {
                int patientId = resultSet.getInt("patientid");
                String name = resultSet.getString("patientname");
                String problem = resultSet.getString("patientproblem");
                double bill = resultSet.getDouble("bill");

                System.out.println("Patient ID: " + patientId);
                System.out.println("Patient Name: " + patientname);
                System.out.println("Patient Problem: " + patientproblem);
                System.out.println("Bill: " + bill);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
