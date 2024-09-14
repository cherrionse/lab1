import java.util.*;
import java.util.stream.Collectors;

public class Task7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 1. Четные и нечетные числа.
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
        System.out.println("Четные числа: " + evenNumbers);
        System.out.println("Нечетные числа: " + oddNumbers);

        // 2. Наибольшее и наименьшее число.
        int max = Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
        System.out.println("Наибольшее число: " + max);
        System.out.println("Наименьшее число: " + min);

        // 3. Числа, которые делятся на 3 или на 9.
        List<Integer> divisibleBy3Or9 = Arrays.stream(numbers)
                .filter(num -> num % 3 == 0 || num % 9 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Числа, которые делятся на 3 или на 9: " + divisibleBy3Or9);

        // 4. Числа, которые делятся на 5 и на 7.
        List<Integer> divisibleBy5And7 = Arrays.stream(numbers)
                .filter(num -> num % 5 == 0 && num % 7 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Числа, которые делятся на 5 и на 7: " + divisibleBy5And7);

        // 5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        List<Integer> threeDigitDistinct = Arrays.stream(numbers)
                .filter(num -> num >= 100 && num <= 999 && hasDistinctDigits(num))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Трехзначные числа с разными цифрами: " + threeDigitDistinct);

        // 6. Простые числа.
        List<Integer> primeNumbers = Arrays.stream(numbers)
                .filter(Task7::isPrime)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Простые числа: " + primeNumbers);

        // 7. Отсортированные числа в порядке возрастания и убывания.
        List<Integer> sortedNumbersAsc = Arrays.stream(numbers).sorted().boxed().collect(Collectors.toList());
        List<Integer> sortedNumbersDesc = Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Числа по возрастанию: " + sortedNumbersAsc);
        System.out.println("Числа по убыванию: " + sortedNumbersDesc);

        // 8. Числа в порядке убывания частоты встречаемости чисел.
        Map<Integer, Long> frequencyMap = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        List<Map.Entry<Integer, Long>> sortedByFrequency = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toList());
        System.out.println("Числа по убыванию частоты: " + sortedByFrequency);

        // 9. «Счастливые» числа (по условию задачи термин "счастливые" не определён, будем считать таковыми те, сумма цифр которых равна 7).
        List<Integer> luckyNumbers = Arrays.stream(numbers)
                .filter(num -> sumOfDigits(num) == 7)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("«Счастливые» числа: " + luckyNumbers);

        // 10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.
        List<Integer> palindromes = Arrays.stream(numbers)
                .filter(Task7::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Числа-палиндромы: " + palindromes);

        // 11. Элементы, которые равны полусумме соседних элементов.
        List<Integer> halfSumNeighbors = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (numbers[i] == (numbers[i - 1] + numbers[i + 1]) / 2) {
                halfSumNeighbors.add(numbers[i]);
            }
        }
        System.out.println("Элементы, равные полусумме соседних элементов: " + halfSumNeighbors);
    }

    // Метод для проверки, имеет ли число разные цифры
    private static boolean hasDistinctDigits(int number) {
        String strNum = String.valueOf(number);
        Set<Character> digits = new HashSet<>();
        for (char c : strNum.toCharArray()) {
            if (!digits.add(c)) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки, является ли число простым
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Метод для вычисления суммы цифр числа
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Метод для проверки, является ли число палиндромом
    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
