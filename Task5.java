import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();

        int sum = 0;
        int product = 1;

        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            sum += number;
            product *= number;
        }

        System.out.println("Сумма чисел: " + sum);
        System.out.println("Произведение чисел: " + product);
    }
}
