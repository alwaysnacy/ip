public class TaskManager {
    private Task[] tasks = new Task[100];
    private int numTasks =0;

    public void addTask(String task) {
        tasks[numTasks] = new Task(task, numTasks);
        numTasks++;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void printTasks() {
        for (int i = 0; i <numTasks; i++) {
            System.out.println((i + 1) + "." + tasks[i].getStatus() + " " + tasks[i].getTask());
        }
    }

    public void setTaskAsDone(int id) {
        tasks[id].setAsDone();
    }

    public void printTaskDone(int id) {
        System.out.println(tasks[id].getStatus() + " " + tasks[id].getTask());
    }
}
