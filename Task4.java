import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String samplePassword = "password123";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль:");
        String enteredPassword = scanner.nextLine();

        if (enteredPassword.equals(samplePassword)) {
            System.out.println("Пароль верный.");
        } else {
            System.out.println("Пароль неверный.");
        }
    }
}
