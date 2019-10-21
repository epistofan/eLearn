package lv.elearning.elearningProject.Domain;


import java.sql.Timestamp;

public class WorkerTask {

    private int workerTaskId;
    private int workerId;
    private int taskId;
    private Timestamp creationDate;
    private Timestamp completionDate;
    private boolean isComplete;

    public int getWorkerTaskId() {
        return workerTaskId;
    }

    public void setWorkerTaskId(int workerTaskId) {
        this.workerTaskId = workerTaskId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
