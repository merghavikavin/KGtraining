import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;



public class RegistrationDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

  public RegistrationDAO() {
        
        this.jdbcURL= "jdbc:mysql://localhost:3306/GarciaC";
        this.jdbcUsername = "root";
        this.jdbcPassword = "";
    }
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    // public List<Registration> listAllRegistrations() throws SQLException {
    //     List<Registration> listReg = new ArrayList<>();
    //     String sql = "SELECT * FROM book";
    //     connect();

    //     Statement statement = jdbcConnection.createStatement();
    //     ResultSet resultSet = statement.executeQuery(sql);
    //     while (resultSet.next()) {
    //         int registration_id = resultSet.getInt("registration_id");
    //         String event_name = resultSet.getString("event_name");
    //         String athlete_name = resultSet.getString("athlete_name");
    //         Date registration_date = resultSet.getDate("registration_date");
           
    //         Registration reg = new Registration(registration_id,event_name,athlete_name,registration_date);
    //         listReg.add(reg);
            
    //     }
    //     resultSet.close();
    //     statement.close();
    //     disconnect();
    //     return listReg;
    // }
}
