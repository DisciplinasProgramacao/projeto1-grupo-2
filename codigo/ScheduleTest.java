import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

    /*
     * Plano de Testes - Schedule
     * Criar um novo compromisso ✔️
     * Criar um compromisso periodico ✔️
     * Buscar por compromissos numa data especifica ✔️
     * Buscar por compromissos em uma data que não foi cadastrada
     */

    private static Schedule agenda;

    @BeforeAll
    public static void init() {
        agenda = new Schedule();
    }

    @Test
    public void registerNewAppointment() {
        agenda.createAppointment("07/09/2022",
                "Reunião em grupo",
                "Trabalho de PM",
                0,
                0);
    }

    @Test
    public void registerARecurringAppointment() {
        agenda.createAppointment("11/09/2022",
                "Reunião em grupo",
                "Trabalho de PM",
                2,
                3);
        assertEquals("Compromissos para a data: 11/09/2022" +
                "\n\n\nTitulo: Reunião em grupo" +
                "\nDescrição: Trabalho de PM",
                agenda.searchTasksByDate("11/09/2022"));
    }

    @Test
    @Order(2)
    public void listTaksInAChosenDate() {
        registerNewAppointment();
        registerNewAppointment();
        assertEquals("Compromissos para a data: 07/09/2022" +
                "\n\n\nTitulo: Reunião em grupo" +
                "\nDescrição: Trabalho de PM" +
                "\n\nTitulo: Reunião em grupo" +
                "\nDescrição: Trabalho de PM",
                agenda.searchTasksByDate("07/09/2022"));
    }

    @Test
    @Order(2)
    public void listTasksInAWrongDate() {
        registerNewAppointment();
        registerNewAppointment();
        System.out.println(agenda.searchTasksByDate("06/09/2022"));
        assertEquals("Compromissos para a data: 06/09/2022\n",
                agenda.searchTasksByDate("06/09/2022"));
    }

}