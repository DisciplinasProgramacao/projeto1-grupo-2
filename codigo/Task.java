
public class Task {
    // #region Attributes
    private String name;
    private String description;
    private Date date;
    // #endregion

    //#region - Constructors
    
    /**
     * Constructor to create a new appointment
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


    //#endregion
   
    // #region methods
    /**
     * Creation of new task
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
     * Void creation of a new periodic task 
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


    /**
     * Creates a String representing the data (name and description) of a created task
     * @return String
     */
    public String showTask(){
        return "\nTitulo: " + this.name + "\nDescrição: " + this.description;
    }
    // #endregion

    // #region getters and setters
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