public class Task {

    // #region attributes
    private String name;
    private String description;
    private Date date;
    private int periodicity;
    private int periodicityRepetitions;
    // #endregion
    // #region methods

    private void init(String dateInput, String name, String description, int periodicity, int periodicityRepetitions) {
        
        this.date.formatDate(dateInput);
        this.name = name;
        this.description = description;
        this.periodicity = periodicity;
        this.periodicityRepetitions = periodicityRepetitions;
    }
    
    public Task(String dateInput, String name, String description, int periodicity, int periodicityRepetitions) {
        init(dateInput, name, description, periodicity, periodicityRepetitions);
    }

    public Task(String dateInput, String name, String description) {
        init(dateInput, name, description, 0, 0);
    }

    // public boolean verifyPeriodicity() {
    //     return (this.periodicity > 0);
    // }

    private void createTaskPeriodicity(String date, int periodicity, int periodicityLimit) {
        periodicTasks = new ArrayList<>(); 
        for (int i = 0; i < periodicityLimit; i++) {
            createTask(date);
            periodicTasks.add(this);
            date = this.date.incrementDate(date, periodicity);
        }
    }


}