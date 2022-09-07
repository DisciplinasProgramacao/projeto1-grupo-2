import java.util.ArrayList;

public class Schedule {

    private Task task;
    private static ArrayList<Task> schedule = new ArrayList<>();

    public void addTask(Task task) {
        
        schedule.add(task);
    }
 
    
}
