public class Task {
    // #region attributes
    private String name;
    private String description;
    private Date date;
    private String dateString;
    private int periodicity;
    private int periodicityRepetitions;
    // #endregion
    // #region methods

    private void init(String dateString, String name, String description, int periodicity, int periodicityRepetitions) {
        
        this.dateString = dateString;
        this.name = name;
        this.description = description;
        this.periodicity = periodicity;
        this.periodicityRepetitions = periodicityRepetitions;
    }
    
    public Task(String dateString, String name, String description, int periodicity, int periodicityRepetitions) {
        init(dateString, name, description, periodicity, periodicityRepetitions);
    }

    public Task(String dateString, String name, String description) {
        init(dateString, name, description, 0, 0);
    }

    public boolean verifyPeriodicity() {
        return (this.periodicity > 0);
    }

    private void createTaskPeriodicity(String date, int periodicity, int periodicityRepetitions) {
        
        for (int i = 0; i < periodicityRepetitions; i++) {
            date = this.date.incrementDate(date, periodicity);
        }
    }

}