import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

    /*
     * Plano de Testes - Schedule
     * Criar um novo compromisso ✔️
     */

    private static Schedule agenda;

    @BeforeAll
    public static void init() {
        agenda = new Schedule();
    }

    @Test
    public void registraNovaAgenda() {
        agenda.createAppointment("07/09/2022",
         "Reunião cá Senior",
          "Senior salvando o dia ",
           0,
            0
            );
    }

    @Test
    public void registraNovaAgendaDeFormaPeriodica() {
        agenda.createAppointment("07/09/2022",
         "Reunião cá Senior",
          "Senior salvando o dia ",
           2,
            3
            );
    }

}