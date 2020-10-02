package duke.task;

import java.util.ArrayList;

/**
 * TaskManager stores Tasks in an ArrayList of Task objects
 */
public class TaskManager {

    public static final int INDEX_OFFSET = 1;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Adds a Task object to the ArrayList of Tasks
     */
    public void addTask(Task task) {
            tasks.add(task);
    }

    /**
     * gets the total number of tasks
     *
     * @return integer primitive type number of tasks
     */
    public int getNumTasks() {
        return tasks.size();
    }

    /**
     * deletes task specified by its ID in the last shown list
     * @param taskID
     */
    public void deleteTask(int taskID) {
        tasks.remove(taskID-INDEX_OFFSET);
    }

    /**
     * gets the tasks specified by their index in form of String
     *
     * @param id task index
     * @return a String of task
     */
    public String getStringOfTask(int id) {
        return tasks.get(id).toString();
    }

    /**
     * gets all tasks in the list in form of concatenated String
     *
     * @return a String of all tasks
     */
    public String getStringOfAllTasks() {
        String stringOfTasks = "";
        for (int i = 0; i <tasks.size(); i++) {
            stringOfTasks += (i+1) + ". " + tasks.get(i).toString() +"\n";
        }
        return stringOfTasks;
    }

    /**
     * gets task specified by its taskID
     *
     * @param taskID integer primitive type
     * @return a Task object
     */
    public Task getTask(int taskID) {
        return tasks.get(taskID - INDEX_OFFSET);
    }

    /**
     * gets an ArrayList of all tasks
     *
     * @return an ArrayList
     */
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    /**
     * set Task specified by its index as Done
     *
     * @param id integer primitive type
     */
    public void setTaskAsDone(int id) {
        tasks.get(id).setAsDone();
    }

}
