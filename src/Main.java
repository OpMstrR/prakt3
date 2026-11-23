
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            while (true) {

                try {
                    System.out.println("\nКалькулятор! Підказка: Дробові числа вводьте через крапку");

                    System.out.print("Введіть перше число: ");
                    double a = scanner.nextDouble();

                    System.out.print("Введіть друге число: ");
                    double b = scanner.nextDouble();

                    System.out.print("Введіть операцію (+, -, *, /): ");
                    String operation = scanner.next();

                    double result;

                    switch (operation) {
                        case "+":
                            result = calculator.add(a, b);
                            break;

                        case "-":
                            result = calculator.subtract(a, b);
                            break;

                        case "*":
                            result = calculator.multiply(a, b);
                            break;

                        case "/":
                            result = calculator.divide(a, b);
                            break;

                        default:
                            throw new InvalidInputException("Невідома операція.");
                    }

                    System.out.println("Результат: " + result);

                } catch (InputMismatchException e) {
                    System.out.println("Помилка: потрібно ввести число.");
                    scanner.next();

                } catch (ArithmeticException e) {
                    System.out.println("Помилка: " + e.getMessage());
                    scanner.next();

                } catch (InvalidInputException e) {
                    System.out.println("Помилка введення: " + e.getMessage());

                } finally {
                    System.out.println("Обробку запиту завершено.");
                }

                System.out.println("\nЩо бажаєте зробити?");
                System.out.println("1 - Ще зробити обчислення");
                System.out.println("2 - Закінчити");
                System.out.print("Ваш вибір: ");

                String choice = scanner.next();

                if (!choice.equals("1")) {
                    System.out.println("Програму буде завершено. Дякую, що скористались.");
                    break;
                }
            }
        }
    }
}
