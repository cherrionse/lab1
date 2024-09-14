import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество аргументов:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Пропустить остаток строки

        String[] arguments = new String[n];
        System.out.println("Введите аргументы:");
        for (int i = 0; i < n; i++) {
            arguments[i] = scanner.nextLine();
        }

        System.out.println("Аргументы командной строки в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arguments[i] + " ");
        }
        System.out.println();
    }
}