import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Class.forName is not needed for recent versions of JDBC drivers
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/GarciaC?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", ""   
                         );

            ps = con.prepareStatement("select * from userreg1 where name=? and pass=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } 

        return status;
    }
}