import java.util.ArrayList;

public class Schedule {

    private ArrayList<Task> schedule = new ArrayList<>();

    private void newTask(String date, String name, String description, int periodicity) {
        Task newTask = new Task(date, name, description, periodicity);
        schedule.add(newTask);
    }

    public void createAppointment(String date, String name, String description, int periodicity, int periodicityLimit) {

        if (periodicityLimit > 0) {
            for (int i = 0; i < periodicityLimit; i++) {

                if(i>0)
                    date = schedule.get(i-1).getDate();

                newTask(date, name, description, periodicity);
            }
        } else {
            newTask(date, name, description, periodicity);
        }

    }

}