
public class Date {
    

    // #region attributes
    // constante: dias de cada mês
    private static final int[] MONTHDAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int CURRENTYEAR = 2022;


    // Fields

    private int day;
    private int month;
    private int year;
    // #endregion

    // #region Construtores

    /**
     * 
     * @param day
     * @param month 
     * @param year 
     */
    private void init(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        if (!this.isDateValid()) { 
            this.day = this.month = 1;
            this.year = 1900;
        }

    }

    /**
     * 
     * @param day 
     * @param month 
     * @param year 
     */
    public Date(int day, int month, int year) {
        this.init(day, month, year);
    }

    /**
    
     * 
     * @param dia 
     * @param mes 
     * 
     */
    public Date(int dia, int mes) {
        this.init(dia, mes, CURRENTYEAR);
    }

    /**
     * Construtor para data padrão: 01/01/1900
     */
    public Date() {
        this.init(1, 1, 1990);
    }
    // #endregion

    /**
     * 
     * @return 
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
     *
     * 
     * @return 
     */
    private Boolean isDateValid() {
        Boolean answer = true; 
        int maxDays = 0;

        if (this.year < 1900)
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
     * 
     * 
     * @return 
     */
    public String formatedDate() {

        return (String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/"
                + String.format("%4d", this.year));
    }

    public String incrementDate(String date, int quantity) {
        int day, month, year;
        String[] detailDate = date.split("/");
        day = Integer.parseInt(detailDate[0]);
        month = Integer.parseInt(detailDate[1]);
        year = Integer.parseInt(detailDate[2]);

        Date auxDate = new Date(day, month, year);

        this.day = auxDate.day += quantity;

        if (auxDate.day >= MONTHDAYS[auxDate.month]) {
            if (auxDate.month == 12) {
                this.year = auxDate.year++;
                this.month = auxDate.month = 1;
            } else {
                this.month = auxDate.month++;
            }
            auxDate.day = auxDate.day - MONTHDAYS[auxDate.month];
            this.day = auxDate.day;
        }

        return formatedDate();

    }

}
