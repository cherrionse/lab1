import java.util.Scanner;
public class Main {
     public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваше имя:");
            String userName = scanner.nextLine(); // Чтение имени пользователя с консоли
            System.out.println("Привет, " + userName + "!");
        }
    }

