package lv.elearning.elearningProject.DAL;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {



    public Connection getDbConnection() {

        Connection conn = null;

        try {

            String dbURL = "jdbc:mysql://127.0.0.1:3306/elearning";
            String user = "root";
            String pass = "Esteban18$";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }


}
