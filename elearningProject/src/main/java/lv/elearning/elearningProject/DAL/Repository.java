package lv.elearning.elearningProject.DAL;

import lv.elearning.elearningProject.Domain.*;

import org.springframework.stereotype.Component;

import java.sql.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {


    public List<Worker> getWorkers() {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "Select * from worker";


        List<Worker> workerList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);


            resultSet = preparedStatement.executeQuery();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                Worker worker = new Worker();
                worker.setWorkerId(resultSet.getInt(1));
                worker.setFirstName(resultSet.getString(4));
                worker.setLastName(resultSet.getString(5));

                workerList.add(i, worker);
                i++;
            }

        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workerList;
    }
    public Worker getWorker(int workerId) {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "Select * from worker where WorkerID = ?";


        Worker worker = new Worker();
        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, workerId);


            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {


                worker.setWorkerId(resultSet.getInt(1));
                worker.setFirstName(resultSet.getString(4));
                worker.setLastName(resultSet.getString(5));
                worker.setPhoto(resultSet.getString(9));

            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return worker;
    }

    public List<Task> getTasks() {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "Select * from task where Deleted = 0";


        List<Task> taskList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);


            resultSet = preparedStatement.executeQuery();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                Task task = new Task();
                task.setTaskId(resultSet.getInt(1));
                task.setTaskName(resultSet.getString(2));
                task.setTaskSubject(resultSet.getString(3));
                task.setLink(resultSet.getString(4));


                try {
                    //visitor.setOutDate(resultSet.getTimestamp(5));
                    //user.setOutDateString(resultSet.getTimestamp(5).toLocalDateTime().toLocalDate().format(dateTimeFormatter));

                    //visitor.setOutTime(resultSet.getTimestamp(6));
                    //user.setOutTimeString(resultSet.getTimestamp(6).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
                } catch (NullPointerException npe) {

                }
                /*user.setFirstName(resultSet.getString(7));
                user.setLastName(resultSet.getString(8));
                user.setCardNumber(resultSet.getString(9));
                user.setCompany(resultSet.getString(10));
                user.setResponsiblePerson(resultSet.getString(11));

                user.setRoomName(resultSet.getString(12));
                user.setResponsiblePersonIdentity(resultSet.getString(13));*/
                taskList.add(i, task);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return taskList;
    }


    public List<Worker> getWorkerTasks() {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "SELECT task.TaskName, task.TaskSubject, workerTask.TaskID, worker.FirstName, worker.LastName, worker.WorkerID " +
                "FROM task INNER JOIN " +
                "workerTask ON task.TaskID = workerTask.TaskID INNER JOIN " +
                "worker ON workerTask.WorkerID = worker.WorkerID";


        List<Worker> workerList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);


            resultSet = preparedStatement.executeQuery();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                Worker worker = new Worker();
                worker.setFirstName(resultSet.getString(4));
                worker.setLastName(resultSet.getString(5));


                try {
                    //visitor.setOutDate(resultSet.getTimestamp(5));
                    //worker.setOutDateString(resultSet.getTimestamp(5).toLocalDateTime().toLocalDate().format(dateTimeFormatter));

                    //visitor.setOutTime(resultSet.getTimestamp(6));
                    //worker.setOutTimeString(resultSet.getTimestamp(6).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
                } catch (NullPointerException npe) {

                }
                /*worker.setFirstName(resultSet.getString(7));
                worker.setLastName(resultSet.getString(8));
                worker.setCardNumber(resultSet.getString(9));
                worker.setCompany(resultSet.getString(10));
                worker.setResponsiblePerson(resultSet.getString(11));

                worker.setRoomName(resultSet.getString(12));
                worker.setResponsiblePersonIdentity(resultSet.getString(13));*/
                workerList.add(i, worker);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workerList;
    }


    public void addTask(Task task) {

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "insert into task (TaskName, TaskSubject, Link)" +
                "values (?, ?, ?)";


        Integer visitorId = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setString(2, task.getTaskSubject());
            preparedStatement.setString(3, task.getLink());


            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                System.out.println("Generated Emp Id: " + resultSet.getInt(1));
                visitorId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addWorker(Worker worker, WorkerAccess workerAccess) {

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "insert into worker (FirstName, LastName, CardNumber,RoomNumber, Notes, Photo)" +
                "values (?, ?, ?,?,?,?)";


        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);

            preparedStatement.setString(1, worker.getFirstName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setString(3, worker.getCardNumber());
            preparedStatement.setString(4, worker.getRoomNumber());
            preparedStatement.setString(5, worker.getNotes());
            preparedStatement.setString(6, worker.getPhoto());


            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet != null && resultSet.next()) {

                int id = resultSet.getInt(1);

                String sql2 = "insert into workerAccess (WorkerID, Username, Password, Role) values(?,?,?,?)";
                preparedStatement = conn.prepareStatement(sql2);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, workerAccess.getUsername());
                preparedStatement.setString(3, workerAccess.getPassword());
                preparedStatement.setString(4, "slave");

                preparedStatement.executeUpdate();
                conn.commit();
            }else {

                conn.rollback();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<uncompletedWorkerTask> uncompletedWorkerTask(){
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "SELECT task.TaskName, task.TaskSubject, workerTask.TaskID, worker.FirstName, worker.LastName, worker.WorkerID, workerTask.isCompleted " +
                "FROM task INNER JOIN " +
                "workerTask ON task.TaskID = workerTask.TaskID INNER JOIN " +
                "worker ON workerTask.WorkerID = worker.WorkerID " +
                "WHERE (workerTask.isCompleted = 0 and task.Deleted = 0)";


        List<uncompletedWorkerTask> uncompletedWorkerTaskList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);



            resultSet = preparedStatement.executeQuery();


            int i = 0;
            while (resultSet.next()) {

                uncompletedWorkerTask uncompletedWorkerTask = new uncompletedWorkerTask();
                uncompletedWorkerTask.setTaskName(resultSet.getString(1));
                uncompletedWorkerTask.setTaskSubject(resultSet.getString(2));
                uncompletedWorkerTask.setTaskId(resultSet.getInt(3));
                uncompletedWorkerTask.setFirstName(resultSet.getString(4));
                uncompletedWorkerTask.setLastName(resultSet.getString(5));
                uncompletedWorkerTask.setWorkerId(resultSet.getInt(6));
                uncompletedWorkerTask.setCompleted(resultSet.getBoolean(7));

                try {

                }catch (NullPointerException npe){

                }

                uncompletedWorkerTaskList.add(i, uncompletedWorkerTask);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return uncompletedWorkerTaskList;
    }

    public List<WorkerTask1> getWorkerTask1(int UserId) {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "SELECT workerTask.WorkerTaskID, task.TaskName, task.TaskSubject, task.Link, workerTask.CreationDate, workerTask.CompletionDate, workerTask.isCompleted, task.TaskID " +
                "FROM task INNER JOIN " +
                "workerTask ON task.TaskID = workerTask.TaskID INNER JOIN " +
                "worker ON workerTask.WorkerID = worker.WorkerID " +
                "WHERE(worker.WorkerID = ? and task.Deleted = 0 and workerTask.isCompleted = 0)";


        List<WorkerTask1> workerTaskList1 = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, UserId);

            resultSet = preparedStatement.executeQuery();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                WorkerTask1 workerTask1 = new WorkerTask1();
                workerTask1.setWorkerTaskId(resultSet.getInt(1));
                workerTask1.setTaskName(resultSet.getString(2));
                workerTask1.setTaskSubject(resultSet.getString(3));
                workerTask1.setLink(resultSet.getString(4));
                workerTask1.setCreationDate(resultSet.getTimestamp(5));
                workerTask1.setCompletionDate(resultSet.getTimestamp(6));
                workerTask1.setComplete(resultSet.getBoolean(7));
                workerTask1.setTaskId(resultSet.getInt(8));
                try {
                    //visitor.setOutDate(resultSet.getTimestamp(5));
                    //user.setOutDateString(resultSet.getTimestamp(5).toLocalDateTime().toLocalDate().format(dateTimeFormatter));

                    //visitor.setOutTime(resultSet.getTimestamp(6));
                    //user.setOutTimeString(resultSet.getTimestamp(6).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
                } catch (NumberFormatException e1) {
e1.printStackTrace();
                }
                /*user.setFirstName(resultSet.getString(7));
                user.setLastName(resultSet.getString(8));
                user.setCardNumber(resultSet.getString(9));
                user.setCompany(resultSet.getString(10));
                user.setResponsiblePerson(resultSet.getString(11));

                user.setRoomName(resultSet.getString(12));
                user.setResponsiblePersonIdentity(resultSet.getString(13));*/
                workerTaskList1.add(i, workerTask1);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workerTaskList1;


    }
    public List<WorkerTask1> workerTaskHistory(int UserId) {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "SELECT task.TaskName, task.TaskSubject, task.Link, workerTask.CreationDate, workerTask.CompletionDate, workerTask.isCompleted, task.TaskID " +
                "FROM task INNER JOIN " +
                "workerTask ON task.TaskID = workerTask.TaskID INNER JOIN " +
                "worker ON workerTask.WorkerID = worker.WorkerID " +
                "WHERE(worker.WorkerID = ? and workerTask.isCompleted = 1 and task.Deleted = 0)";


        List<WorkerTask1> workerTaskList1 = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, UserId);

            resultSet = preparedStatement.executeQuery();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                WorkerTask1 workerTask1 = new WorkerTask1();
                workerTask1.setTaskName(resultSet.getString(1));
                workerTask1.setTaskSubject(resultSet.getString(2));
                workerTask1.setLink(resultSet.getString(3));
                workerTask1.setCreationDate(resultSet.getTimestamp(4));
                workerTask1.setCompletionDate(resultSet.getTimestamp(5));
                workerTask1.setComplete(resultSet.getBoolean(6));
                workerTask1.setTaskId(resultSet.getInt(7));
                try {
                    //visitor.setOutDate(resultSet.getTimestamp(5));
                    //user.setOutDateString(resultSet.getTimestamp(5).toLocalDateTime().toLocalDate().format(dateTimeFormatter));

                    //visitor.setOutTime(resultSet.getTimestamp(6));
                    //user.setOutTimeString(resultSet.getTimestamp(6).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
                /*user.setFirstName(resultSet.getString(7));
                user.setLastName(resultSet.getString(8));
                user.setCardNumber(resultSet.getString(9));
                user.setCompany(resultSet.getString(10));
                user.setResponsiblePerson(resultSet.getString(11));

                user.setRoomName(resultSet.getString(12));
                user.setResponsiblePersonIdentity(resultSet.getString(13));*/
                workerTaskList1.add(i, workerTask1);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workerTaskList1;


    }


    public void addWorkerTask(int taskId, List<Worker> workers) {

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;


        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();


        int i;
            String sql = "insert into workerTask (WorkerId, TaskId, IsCompleted)" +
                    "values (?, ?, ?)";
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (i=0; i<workers.size(); i++){


            preparedStatement.setInt(1, workers.get(i).getWorkerId());
            preparedStatement.setInt(2, taskId);
            preparedStatement.setBoolean(3, false);

            preparedStatement.addBatch();
    }

            int [] testik = preparedStatement.executeBatch();



            conn.commit();


            if (resultSet != null && resultSet.next()) {
                System.out.println("Generated Emp Id: " + resultSet.getInt(1));

            }
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public Integer setCompleted(int workerId, int taskId) {
        Integer result = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;


        String sql = "UPDATE workerTask SET CompletionDate = now(), isCompleted = 1 WHERE WorkerID = ? and WorkerTaskID = ?";

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setInt(1, workerId);
            preparedStatement.setInt(2, taskId);

            result = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public WorkerAccess getWorkerAccessUser(String username, String password) {

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection conn = null;
        DbConnection dbConnection = new DbConnection();

        String sql = "Select * from workerAccess where Username = ? and Password = ?";

        WorkerAccess workerAccess = new WorkerAccess();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {


                workerAccess.setWorkerId(resultSet.getInt(2));
                workerAccess.setUsername(resultSet.getString(3));
                workerAccess.setPassword(resultSet.getString(4));
                workerAccess.setRole(resultSet.getString(5));


                try {

                } catch (NullPointerException npe) {

                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workerAccess;
    }

    public void deleteTask (int name){

        Integer result = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;


        String sql = "UPDATE task SET Deleted = 1 WHERE TaskID = ?";

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, name);


            result = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

}