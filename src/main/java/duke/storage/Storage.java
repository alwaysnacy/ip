package duke.storage;

import duke.exceptions.DukeException;
import duke.task.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public static final String DEFAULT_STORAGE_FILEPATH = "duke.txt";
    private static final String UPDATE_FILE_ERROR = "Something went wrong when updating file.";
    private static final String LOAD_FILE_ERROR = "Something went wrong when loading file.";
    private static final String NO_FILE_ERROR = "File not found, new duke.txt file will be created.";
    public static final String DATE_FORMAT_OF_FILE = "MMM dd yyyy";
    private static final int LENGTH_OF_DATE = 11;
    public static final String TIME_FORMAT_OF_FILE = "HH:mm";

    public final Path path;

    public Storage() {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    public Storage(String filePath) {
        path = Paths.get(filePath);
    }

    public Path getPath() {
        return path;
    }

    public TaskManager load() throws DukeException {

        TaskManager tasksFromFile = new TaskManager();
        int taskCounter =0;

        Scanner s;
        try {
            s = new Scanner(path);
        } catch (NoSuchFileException e) {
            throw new DukeException(NO_FILE_ERROR);
        } catch (IOException e) {
            throw new DukeException(LOAD_FILE_ERROR);
        }
        while (s.hasNext()) {
            taskCounter++;
            String fileInput = s.nextLine();
            String taskType = fileInput.substring(0, 1);
            addTaskFromFile(fileInput, taskType, tasksFromFile, taskCounter);
        }

        return tasksFromFile;
    }

    public static void addTaskFromFile(String fileInput, String taskType, TaskManager tasksFromFile, int taskID) {
        switch (taskType) {
        case "T":
            addTodoFromFile(fileInput, tasksFromFile, taskID);
            break;
        case "E":
            addEventFromFile(fileInput, tasksFromFile, taskID);
            break;
        case "D":
            addDeadlineFromFile(fileInput, tasksFromFile, taskID);
            break;
        default:
            break;
        }
    }

    public static void addTodoFromFile(String fileInput, TaskManager tasksFromFile, int taskID) {
        String description = fileInput.substring(7).trim();
        Task todo = new ToDo(description, taskID);
        tasksFromFile.addTask(todo);
        checkStatus(fileInput, tasksFromFile);
    }

    public static void addEventFromFile(String fileInput, TaskManager tasksFromFile, int taskID) {
        String descriptionAndTime = fileInput.substring(8);
        String[] parts = descriptionAndTime.split("\\|", 2);
        Task event = new Event(parts[0].trim(), taskID, parts[1].trim());
        tasksFromFile.addTask(event);
        checkStatus(fileInput, tasksFromFile);
    }

    public static void addDeadlineFromFile(String fileInput, TaskManager tasksFromFile, int taskID) {
        String descriptionAndTime = fileInput.substring(8);
        String[] parts = descriptionAndTime.split("\\|", 2);
        Task deadline = new Deadline(parts[0].trim(), taskID, parts[1].trim());
        tasksFromFile.addTask(deadline);
        checkStatus(fileInput, tasksFromFile);
    }

    public static void checkStatus(String fileInput, TaskManager taskFromFile) {
        String status = fileInput.substring(3, 6);
        if (status.contains("[\u2713]")) {
            taskFromFile.setTaskAsDone(taskFromFile.getNumTasks()-1);
        }
    }

    public static void updateFile(TaskManager tasks, Path filePath) throws DukeException {
        try {
            FileWriter fw = new FileWriter(String.valueOf(filePath));
            for (Task t : tasks.getAllTasks()) {
                fw.write(t.toFile() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException(UPDATE_FILE_ERROR);
        }
    }

}
