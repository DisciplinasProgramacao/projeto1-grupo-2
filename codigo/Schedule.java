import java.util.ArrayList;

public class Schedule {

    //#region
    private ArrayList<Task> schedule = new ArrayList<>();
    //#endregion
    
    //#region - Methods

    /**
     * Insert a new task into the schedule's list
     * @param date
     * @param name
     * @param description
     * @param periodicity
     */
    private void newTask(String date, String name, String description, int periodicity) {
        Task newTask = new Task(date, name, description, periodicity);
        schedule.add(newTask);
    }
    

    /**
     * Creates and validates tasks with the chosen periodicity and periodicity limit
     * @param date
     * @param name
     * @param description
     * @param periodicity
     * @param periodicityLimit
     */
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

    //#endregion

}