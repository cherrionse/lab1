import java.text.SimpleDateFormat;
import java.util.Date;

public class Task6 {
    public static void main(String[] args) {
        String developerName = "Иванов Иван";
        String assignmentDate = "2024-09-13 12:00:00";  // Дата получения задания
        String submissionDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        System.out.println("Разработчик: " + developerName);
        System.out.println("Дата и время получения задания: " + assignmentDate);
        System.out.println("Дата и время сдачи задания: " + submissionDate);
    }
}
