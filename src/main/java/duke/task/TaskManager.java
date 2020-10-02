package duke.task;

import java.util.ArrayList;


public class TaskManager {
    public static final int INDEX_OFFSET = 1;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task) {
            tasks.add(task);
    }

    public int getNumTasks() {
        return tasks.size();
    }

    public void deleteTask(int taskID) {
        tasks.remove(taskID-INDEX_OFFSET);
    }

    public String getStringOfTask(int id) {
        return tasks.get(id).toString();
    }

    public String getStringOfAllTasks() {
        String stringOfTasks = "";
        for (int i = 0; i <tasks.size(); i++) {
            stringOfTasks += (i+1) + ". " + tasks.get(i).toString() +"\n";
        }
        return stringOfTasks;
    }

    public Task getTask(int taskID) {
        return tasks.get(taskID - INDEX_OFFSET);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public void setTaskAsDone(int id) {
        tasks.get(id).setAsDone();
    }

}
