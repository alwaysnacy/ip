package duke.task;
import duke.exceptions.DukeException;
import duke.exceptions.InvalidTaskTypeException;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task) {
            tasks.add(task);
    }

//    public void addToDo(String description) {
//        try {
////            String description = task.split(" ", 2)[1];
//            tasks.add(new ToDo(description, numTasks));
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("OOPS!!! The description of a todo cannot be empty.");
//        }
//    }
//
//    public void addDeadline(String description, String byTime) throws DukeException {
//        try {
////            task = task.split(" ", 2)[1];
////            String description = task.split("/by")[0].trim();
////            if (description.length() < 2) {
////                throw new DukeException();
////            } else {
////                String byTime = task.split("/by")[1].trim();
//                tasks.add(new Deadline(description, numTasks, byTime));
////            }
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
//        }
//    }
//
//    public void addEvent(String description, String atTime) throws DukeException {
//        try {
////            task = task.split(" ", 2)[1];
////            String description = task.split("/at")[0].trim();
////            if (description.length() < 2) {
////                throw new DukeException();
////            } else {
////                String byTime = task.split("/at")[1].trim();
//                tasks.add(new Event(description, numTasks, atTime));
////            }
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("OOPS!!! The description of an event cannot be empty.");
//        }
//    }

    public int getNumTasks() {
        return tasks.size();
    }

    public void printTasks() {
        for (int i = 0; i <tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
    }

    public String getStringOfAllTasks() {
        String listOfTasks = "";
        for (int i = 0; i <tasks.size(); i++) {
            listOfTasks += (i+1) + ". " + tasks.get(i).toString() +"\n";
        }
        return listOfTasks;
    }

    public void deleteTask(int id) {
        for (int i = id; i<tasks.size()-1; i++) {
            tasks.set(i, tasks.get(i+1));
        }
        tasks.remove(tasks.size()-1);
    }

    public void printOneTask(int id) {
        System.out.println(tasks.get(id).toString());
    }

    public String getStringOfTask(int id) {
        return tasks.get(id).toString();
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public void setTaskAsDone(int id) {
        tasks.get(id).setAsDone();
    }

}
