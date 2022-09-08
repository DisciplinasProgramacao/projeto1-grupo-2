
public class Task {
    // #region attributes
    private String name;
    private String description;
    private Date date;
    // #endregion

    // #region methods

    /**
     * builder to create a new appointment
     * 
     * @param date             date of commitment (dd/MM/AAAA)
     * @param name             appointment name
     * @param description      description of the appointment
     * @param periodicity      interval of days
     * @param periodicityLimit periodicity repetitions
     */
    public Task(String date, String name, String description, int periodicity) {
        init(name, description);
        if (verifyPeriodicity(periodicity))
            createTaskPeriodicity(date, periodicity);
        else
            createTask(date);
    }

    /**
     * creation of new date
     * 
     * @param date of commitment (dd/MM/AAAA)
     */
    private void createTask(String date) {
        int day, month, year;
        String[] detailDate = date.split("/");

        day = Integer.parseInt(detailDate[0]);
        month = Integer.parseInt(detailDate[1]);
        year = Integer.parseInt(detailDate[2]);

        this.date = new Date(day, month, year);
    }

    /**
     * creation of a new periodic date
     * 
     * @param date of commitment (dd/MM/AAAA)
     */
    private void createTaskPeriodicity(String date, int periodicity) {
        createTask(date);
        date = this.date.incrementDate(date, periodicity);

    }

    /**
     * attribute initializer method
     * 
     * @param name             appointment name
     * @param description      description of the appointment
     * @param periodicity      interval of days
     * @param periodicityLimit periodicity repetitions
     */
    private void init(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * if periodicity checks was informed
     * 
     * @return "true" for periodicity > 0 or "false" for periodicity <= 0
     */
    private boolean verifyPeriodicity(int periodicity) {
        if (periodicity > 0)
            return true;
        else
            return false;
    }
    // #endregion

    // #region getters e setters
    public String getName() {
        return name;
    }

    public String getDate() {
        return date.formatedDate();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // #endregion
}