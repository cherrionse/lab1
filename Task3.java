import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество случайных чисел:");
        int numberOfRandomNumbers = scanner.nextInt();

        Random random = new Random();

        System.out.println("Случайные числа с переходом на новую строку:");
        for (int i = 0; i < numberOfRandomNumbers; i++) {
            System.out.println(random.nextInt());
        }

        System.out.println("Случайные числа без перехода на новую строку:");
        for (int i = 0; i < numberOfRandomNumbers; i++) {
            System.out.print(random.nextInt() + " ");
        }
        System.out.println();
    }
}
