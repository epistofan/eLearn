package lv.elearning.elearningProject.DAL;

import lv.elearning.elearningProject.Domain.WorkerAccess;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



@Component
public class UserRepo {


    public WorkerAccess checkLoginUser(String username, String password){

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        java.sql.Connection conn;

        String sql = "select* from accessUser where UserName = ? and UserPassword = ?";

        WorkerAccess workerAccess = new WorkerAccess();

        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

        conn.commit();
System.out.println(resultSet.getString(2));
    while(resultSet.next()) {


    workerAccess.setWorkerId(resultSet.getInt(2));
    workerAccess.setUsername(resultSet.getString(3));
    workerAccess.setPassword(resultSet.getString(4));
    workerAccess.setRole(resultSet.getString(5));

}

            conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

        if(workerAccess == null)
            {
                return null;
            }else {

                return workerAccess;
            }
    }










}
