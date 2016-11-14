import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lynas on 11/14/2016
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:hsqldb/DB", "SA", "123456");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT Salary FROM SALARYDETAILS");
            while (resultSet.next()) {
                System.out.println("EMPLOYEE Salary:"
                        + resultSet.getString("Salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
