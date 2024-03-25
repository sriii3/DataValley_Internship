import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDAO {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/departments";
    private static final String USER = "sree";
    private static final String PASSWORD = " ";

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static final String INSERT_DEPARTMENT_SQL = "INSERT INTO department (id, name) VALUES (?, ?)";

    public static void main(String[] args) {
  
        Department department = new Department(1, "IT");

        try {
           
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT_SQL);

            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());

            preparedStatement.executeUpdate();

            System.out.println("Department inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
               
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}