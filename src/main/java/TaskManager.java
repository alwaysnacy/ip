public class TaskManager {
    private Task[] tasks = new Task[100];
    private int numTasks =0;

    public void addTask(String task) throws InvalidTaskTypeException{
        try {
            if (task.contains("todo")) {
                addToDo(task);
            } else if (task.contains("deadline")) {
                addDeadline(task);
            } else if (task.contains("event")) {
                addEvent(task);
            } else {
                throw new InvalidTaskTypeException();
            }
        } catch (DukeException e) {
            System.out.println("OOPS!!! You have to provide the date!");
        }

        numTasks++;
    }

    public void addToDo(String task) {
        try {
            String description = task.split(" ", 2)[1];
            tasks[numTasks] = new ToDo(description, numTasks);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public void addDeadline(String task) throws DukeException{
        try {
            task = task.split(" ", 2)[1];
            String description = task.split("/by")[0].trim();
            if (description.length() < 2) {
                throw new DukeException();
            } else {
                String byTime = task.split("/by")[1].trim();
                tasks[numTasks] = new Deadline(description, numTasks, byTime);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public void addEvent(String task) throws DukeException{
        try {
            task = task.split(" ", 2)[1];
            String description = task.split("/at")[0].trim();
            if (description.length() < 2) {
                throw new DukeException();
            } else {
                String byTime = task.split("/at")[1].trim();
                tasks[numTasks] = new Event(description, numTasks, byTime);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The description of an event cannot be empty.");
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void printTasks() {
        for (int i = 0; i <numTasks; i++) {
            System.out.println((i + 1) + "." + tasks[i].toString());
        }
    }

    public void printOneTask(int id) {
        System.out.println(tasks[id].toString());
    }

    public void setTaskAsDone(int id) {
        tasks[id].setAsDone();
    }

}
