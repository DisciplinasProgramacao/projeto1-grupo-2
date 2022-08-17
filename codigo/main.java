public class Main {
    public static void main(String[] args) {

        Task xTask = new Task();

        xTask.setDescription("Reuniao semanal");
        xTask.setName("Reuniao");
        xTask.setPeriodicity(5);

        System.out.println("\nName --> " + xTask.getName() + '\n' +
                "Description --> " + xTask.getDescription() + '\n' +
                "Periodicity --> " + xTask.getPeriodicity() + "\n");
    }
}
