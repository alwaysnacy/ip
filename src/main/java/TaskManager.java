public class TaskManager {
    private Task[] tasks = new Task[100];
    private int numTasks =0;

    public void addTask(String task) {
        String description = "";
        String byTime = "";

        if (task.contains("todo")) {
            description = task.split(" ", 2)[1];
            tasks[numTasks] = new ToDo(description, numTasks);
        } else if (task.contains("deadline")) {
            task = task.split(" ", 2)[1];
            description = task.split("/by")[0].trim();
            byTime =  task.split("/by")[1].trim();
            tasks[numTasks] = new Deadline(description, numTasks, byTime);
        } else if (task.contains("event")) {
            task = task.split(" ", 2)[1];
            description = task.split("/at")[0].trim();
            byTime =  task.split("/at")[1].trim();
            tasks[numTasks] = new Event(description, numTasks, byTime);
        }

        numTasks++;
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
