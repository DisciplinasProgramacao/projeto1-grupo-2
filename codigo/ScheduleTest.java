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
         "Reunião cá Senior",
          "Senior salvando o dia ",
           0,
            0
            );
    }

    @Test
    public void registerARecurringAppointment() {
        agenda.createAppointment("07/09/2022",
         "Reunião cá Senior",
          "Senior salvando o dia ",
           2,
            3
            );
    }

    @Test
    @Order(2)
    public void listTaksInAChosenDate(){
        registerNewAppointment();
        registerNewAppointment();
        System.out.println(agenda.searchTasksByDate("07/09/2022"));
    }

    @Test
    @Order(2)
    public void listTasksInAWrongDate(){
        registerNewAppointment();
        registerNewAppointment();
        System.out.println(agenda.searchTasksByDate("06/09/2022"));
    }

}