
public class Date {
    
    // #region atributos
    // constante: days de cada mês
    private static final int[] daySDOmonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int ANO_ATUAL = 2022;
    private static final String[] daySDASEMANA = { "sábado", "domingo", "segunda", "terça", "quarta", "quinta",
            "sexta" }; // 2022 começa em um sábado
    
            // atributos
    private String date;
    private int day;
    private int month;
    private int year;

    // #endregion

    private void init() {
        this.day = ;
        this.month = ;
        this.year = ;
    }

    public void formatDate(String dateInput) {
        String[] datePart = dateInput.split("/");
        int day, month, year;

        day = Integer.parseInt(datePart[0]);
        month = Integer.parseInt(datePart[1]);
        year = Integer.parseInt(datePart[2]);
    }
    
    
    public String incrementDate(String date, int quantity) {
        int day, month, year;
        String[] detailDate = date.split("/");

        day = Integer.parseInt(detailDate[0]);
        month = Integer.parseInt(detailDate[1]);
        year = Integer.parseInt(detailDate[2]);

        Date aux = new Date(day, month, year);

        aux.day += quantity;

        if (aux.day >= daySDOmonth[aux.month]) {
            if (aux.month == 12) {
                aux.year++;
                aux.month = 1;
            } else {
                 aux.month++;
            }
            aux.day = aux.day - daySDOmonth[aux.month];
        }

        return dataFormatada();
    }
    
    public boolean anoBissexto() {
        boolean resposta = false;
        if (this.year % 400 == 0)
            resposta = true;
        else if (this.year % 4 == 0 && this.year % 100 != 0)
            resposta = true;

        return resposta;
    }
    
    private Boolean dataValida() {
        Boolean resposta = true; // resposta sobre a validade
        int maximoDedays = 0;

        if (this.year < 1900)
            resposta = false;
        else {
            if (this.month < 1 || this.month > 12) // mês<1 ou mês>12 --> data inválida
                resposta = false;
            else {
                maximoDedays = daySDOmonth[month];
                if (this.anoBissexto() && month == 2) // caso de 29/02 em ano bissexto --> data válida
                    maximoDedays++;
                if (this.day > maximoDedays) // verifica validade de acordo com o mês atual
                    resposta = false;
            }
        }
        return resposta; // retorna a validação obtida
    }
    
   
    public String dataFormatada() {

        return (String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/"
                + String.format("%4d", this.year));
    }

}
