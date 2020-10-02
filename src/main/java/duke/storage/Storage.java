package duke.storage;

import duke.exception.DukeException;
import duke.task.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Storage {

    public static final String DEFAULT_STORAGE_FILEPATH = "duke.txt";
    private static final String UPDATE_FILE_ERROR_MESSAGE = "Could not write to file";
    private static final String LOAD_FILE_ERROR_MESSAGE = "Could not load file.";
    private static final String NO_FILE_ERROR_MESSAGE = "File not found, new duke.txt file will be created"
            + "to store new tasks added.";

    public final Path path;

    public Storage() {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    public Storage(String filePath) {
        path = Paths.get(filePath);
    }


    /**
     * Loads the {@code TaskManager} data from this storage file, and then returns it.
     * @return a TaskManager object containing tasks read from existing file
     *
     * @throws DukeException if there were errors loading data from file or file specified does not exist
     */
    public TaskManager loadFromStorage() throws DukeException {

        TaskManager tasksFromFile = new TaskManager();
        int taskCounter =0;

        Scanner fileScanner;
        try {
            fileScanner = new Scanner(path);
        } catch (FileNotFoundException e) {
            throw new DukeException(NO_FILE_ERROR_MESSAGE);
        } catch (IOException e) {
            throw new DukeException(LOAD_FILE_ERROR_MESSAGE);
        }
        while (fileScanner.hasNext()) {
            taskCounter++;
            String fileInput = fileScanner.nextLine();
            String taskType = fileInput.substring(0, 1);
            loadTaskFromStorage(fileInput, taskType, tasksFromFile, taskCounter);
        }

        return tasksFromFile;
    }

    /**
     * Adds task from duke.txt file to the TaskManager object
     *
     * @param fileInput a full line in duke.txt file
     * @param taskType indicates if a task is Todo, Event or Deadline
     * @param tasksFromFile a TaskManager object to contains all tasks read from duke.txt
     * @param taskID taskID of the task from File, get by parsing the input String line
     */
    public static void loadTaskFromStorage(String fileInput, String taskType, TaskManager tasksFromFile, int taskID) {
        switch (taskType) {
        case "T":
            loadTodoFromStorage(fileInput, tasksFromFile, taskID);
            break;
        case "E":
            loadEventFromStorage(fileInput, tasksFromFile, taskID);
            break;
        case "D":
            loadDeadlineFromStorage(fileInput, tasksFromFile, taskID);
            break;
        default:
            break;
        }
    }

    /**
     * loads Todo task from the storage file if it exists
     * creates Todo task from the String line and adds it to the TaskManager
     *
     * @param fileInput a full line in duke.txt file
     * @param tasksFromFile a TaskManager object to contains all tasks read from duke.txt
     * @param taskID taskID of the task from File, get by parsing the input String line
     *
     */
    public static void loadTodoFromStorage(String fileInput, TaskManager tasksFromFile, int taskID) {
        String description = fileInput.substring(7).trim();
        Task todo = new ToDo(description, taskID);
        tasksFromFile.addTask(todo);
        checkStatus(fileInput, tasksFromFile);
    }


    /**
     * loads Event task from the storage file if it exists
     * creates Event task from the String line and adds it to the TaskManager
     *
     * @param fileInput a full line in duke.txt file
     * @param tasksFromFile a TaskManager object to contains all tasks read from duke.txt
     * @param taskID taskID of the task from File, get by parsing the input String line
     *
     */
    public static void loadEventFromStorage(String fileInput, TaskManager tasksFromFile, int taskID) {
        String descriptionAndTime = fileInput.substring(8);
        String[] parts = descriptionAndTime.split("\\|", 2);
        LocalDateTime at = convertDateTimeFormat(parts[1].trim());
        Task event = new Event(parts[0].trim(), taskID, at);
        tasksFromFile.addTask(event);
        checkStatus(fileInput, tasksFromFile);
    }


    /**
     * loads Deadline task from the storage file if it exists
     * creates Deadline task from the String line and adds it to the TaskManager
     *
     * @param fileInput a full line in duke.txt file
     * @param tasksFromFile a TaskManager object to contains all tasks read from duke.txt
     * @param taskID taskID of the task from File, get by parsing the input String line
     *
     */
    public static void loadDeadlineFromStorage(String fileInput, TaskManager tasksFromFile, int taskID) {
        String descriptionAndTime = fileInput.substring(8);
        String[] parts = descriptionAndTime.split("\\|", 2);
        LocalDateTime by = convertDateTimeFormat(parts[1].trim());
        Task deadline = new Deadline(parts[0].trim(), taskID, by);
        tasksFromFile.addTask(deadline);
        checkStatus(fileInput, tasksFromFile);
    }


    /**
     * converts String parameter to LocalDateTime object
     *
     * @param dateAndTime full argument String, extracted after the action word
     * @return the LocalDateTime object
     */
    private static LocalDateTime convertDateTimeFormat(String dateAndTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
        return dateTime;
    }


    /**
     * checks status of the task loaded from duke.txt
     * if done, marks the task just added in taskFromFile as done
     *
     * @param fileInput a full line in duke.txt file
     * @param tasksFromFile a TaskManager object to contains all tasks read from duke.txt
     *
     */
    public static void checkStatus(String fileInput, TaskManager tasksFromFile) {
        String status = fileInput.substring(3, 6);
        if (status.contains("[\u2713]")) {
            tasksFromFile.setTaskAsDone(tasksFromFile.getNumTasks()-1);
        }
    }


    /**
     * Updates file whenever there is modification to the TaskManager
     *
     * @param tasks Instance of TaskManager class
     * @param filePath Path of duke.txt file
     *
     * @throws DukeException if there is problem writing tasks to the file created
     *
     */
    public static void saveToStorage(TaskManager tasks, Path filePath) throws DukeException {
        try {
            FileWriter fw = new FileWriter(String.valueOf(filePath));
            for (Task task : tasks.getAllTasks()) {
                fw.write(task.toFile() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException(UPDATE_FILE_ERROR_MESSAGE);
        }
    }

}
