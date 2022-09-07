import java.util.ArrayList;

public class Schedule {

    private ArrayList<Task> tasks;

    public Schedule(){
        tasks = new ArrayList<>();
    }

   public void createTask(String date, String name, String description, int periodicity, int periodicityLimit) {
      Task newTask = new Task(date, name, description, periodicity, periodicityLimit);
      tasks.add(newTask); 
   }
   
 
    
}