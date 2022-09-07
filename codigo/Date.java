
public class Date {
    
    // #region atributos
    // constante: dias de cada mês
    private static final int[] DIASDOMES = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int ANO_ATUAL = 2022;
    private static final String[] DIASDASEMANA = { "sábado", "domingo", "segunda", "terça", "quarta", "quinta",
            "sexta" }; // 2022 começa em um sábado
    
            // atributos
    private int dia;
    private int mes;
    private int ano;
    // #endregion

    // #region Construtores

    
    private void init(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (!this.dataValida()) { 
            this.dia = this.mes = 1;
            this.ano = 1900;
        }

    }
    
    public Date(int dia, int mes, int ano) {
        this.init(dia, mes, ano);
    }

    
    public Date(int dia, int mes) {
        this.init(dia, mes, ANO_ATUAL);
    }
    
    public Date() {
        this.init(1, 1, 1990);
    }
    // #endregion
    
    public boolean anoBissexto() {
        boolean resposta = false;
        if (this.ano % 400 == 0)
            resposta = true;
        else if (this.ano % 4 == 0 && this.ano % 100 != 0)
            resposta = true;

        return resposta;
    }
    
    private Boolean dataValida() {
        Boolean resposta = true; // resposta sobre a validade
        int maximoDeDias = 0;

        if (this.ano < 1900)
            resposta = false;
        else {
            if (this.mes < 1 || this.mes > 12) // mês<1 ou mês>12 --> data inválida
                resposta = false;
            else {
                maximoDeDias = DIASDOMES[mes];
                if (this.anoBissexto() && mes == 2) // caso de 29/02 em ano bissexto --> data válida
                    maximoDeDias++;
                if (this.dia > maximoDeDias) // verifica validade de acordo com o mês atual
                    resposta = false;
            }
        }
        return resposta; // retorna a validação obtida
    }
    
    public static String diaDaSemanaEm2022(String data) {

        int deslocamento = 0;
        int totalDias = 0;
        int mesParaSomar = 1;

        String[] detalhes = data.split("/");
        int dia = Integer.parseInt(detalhes[0]);
        int mes = Integer.parseInt(detalhes[1]);

        Date aux = new Date(dia, mes);

        while (mesParaSomar != aux.mes) { // somamos todos os dias dos meses anteriores ao atual
            totalDias += DIASDOMES[mesParaSomar];
            mesParaSomar++;
        }

        totalDias += (aux.dia - 1); // somamos os dias para chegar na data dentro do mês
        deslocamento = totalDias % 7; // o deslocamento em dias no vetor contante de dias da semana indica o dia da
                                      // data.

        return DIASDASEMANA[deslocamento];
    }

   
    public String dataFormatada() {

        return (String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/"
                + String.format("%4d", this.ano));
    }

    public String incrementDate(String date, int quantity) {
        int day, month, year;
        String[] detailDate = date.split("/");

        day = Integer.parseInt(detailDate[0]);
        month = Integer.parseInt(detailDate[1]);
        year = Integer.parseInt(detailDate[2]);

        Date aux = new Date(day, month, year);

        aux.dia += quantity;

        if (aux.dia >= DIASDOMES[aux.mes]) {
            if (aux.mes == 12) {
                aux.ano++;
                aux.mes = 1;
            } else {
                 aux.mes++;
            }
            aux.dia = aux.dia - DIASDOMES[aux.mes];
        }

        return dataFormatada();
    }

}
