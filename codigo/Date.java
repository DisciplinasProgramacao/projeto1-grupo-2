
public class Date {

    // #region attributes
    // constante: dias de cada mês
    private static final int[] MONTHDAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // Fields

    private int day;
    private int month;
    private int year;
    // #endregion

    // #region Construtores

    /**
     * Constructor that creates a date given a year.
     * 
     * @param day   The day number from 1 to 31***
     * @param month The month number from 1 to 12
     * @param year  The year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    /**
     * Tests if the year is a leap year
     * 
     * @return if it is a leap year or not
     */
    public boolean isLeapYear() {
        boolean answer = false;
        if (this.year % 400 == 0)
            answer = true;
        else if (this.year % 4 == 0 && this.year % 100 != 0)
            answer = true;

        return answer;
    }

    /**
     * Valitates the data
     * 
     * @return answers if the date is a valid date or not
     */
    public Boolean isDateValid() {
        Boolean answer = true;
        int maxDays = 0;

        if (this.year < 2022)
            answer = false;
        else {
            if (this.month < 1 || this.month > 12)
                answer = false;
            else {
                maxDays = MONTHDAYS[month];
                if (this.isLeapYear() && month == 2)
                    maxDays++;
                if (this.day > maxDays)
                    answer = false;
            }
        }
        return answer;
    }

    /**
     * Formate the string date
     * return a formated string DD/MM/YY
     */
    public String formatedDate() {

        return (String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/"
                + String.format("%04d", this.year));
    }

    /**
     * adjusts date according to validation rules
     * @param quantity how much you want to increment on the current date
     * @throws Exception negative values are not accepted
     */
    public void incrementDate(int quantity) throws Exception {

        if (quantity < 0) {
            this.month = this.day = this.year = 0;
            throw new Exception("Quantity must be greater than zero.");
        }

        this.day += quantity;

        if (this.day >= MONTHDAYS[this.month]) {
            if (this.month == 12) {
                this.year = this.year++;
                this.month = 1;
            } else {
                this.month++;
            }
            this.day = this.day - MONTHDAYS[this.month - 1];
        }
    }

}
