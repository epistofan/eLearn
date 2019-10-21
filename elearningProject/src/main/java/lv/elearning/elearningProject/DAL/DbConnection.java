package lv.elearning.elearningProject.DAL;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {



    public Connection getDbConnection() {

        Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://10.10.10.100;databaseName=elearning";
            String user = "sa";
            String pass = "Admin18";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }


}
