public class TaskManager {
    private Task[] tasks = new Task[100];
    private int numTasks =0;

    public void addTask(String task) {
        if (task.contains("todo")) {
            addToDo(task);
        } else if (task.contains("deadline")) {
            addDeadline(task);
        } else if (task.contains("event")) {
            addEvent(task);
        }
        numTasks++;
    }

    public void addToDo(String task) {
        String description = task.split(" ", 2)[1];
        tasks[numTasks] = new ToDo(description, numTasks);
    }

    public void addDeadline(String task) {
        task = task.split(" ", 2)[1];
        String description = task.split("/by")[0].trim();
        String byTime =  task.split("/by")[1].trim();
        tasks[numTasks] = new Deadline(description, numTasks, byTime);
    }

    public void addEvent(String task) {
        task = task.split(" ", 2)[1];
        String description = task.split("/at")[0].trim();
        String byTime =  task.split("/at")[1].trim();
        tasks[numTasks] = new Event(description, numTasks, byTime);
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
