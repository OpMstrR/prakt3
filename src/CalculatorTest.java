import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) throws InvalidInputException {
        Calculator calculator = new Calculator();

        checkResult("Додавання", 12, calculator.add(8, 4));
        checkResult("Віднімання", 4, calculator.subtract(8, 4));
        checkResult("Множення", 32, calculator.multiply(8, 4));
        checkResult("Ділення", 2, calculator.divide(8, 4));
        checkResult("Від’ємні числа", -5, calculator.add(-8, 3));
        checkResult("Дробові числа", 2.5, calculator.divide(5, 2));

        try {
            calculator.divide(10, 0);
            throw new AssertionError("Ділення на нуль: виняток не виник.");

        } catch (ArithmeticException e) {
            System.out.println("Ділення на нуль: тест пройдено.");
        }

        try {
            calculator.add(Double.NaN, 5);
            throw new AssertionError("NaN: власний виняток не виник.");

        } catch (InvalidInputException e) {
            System.out.println("Власний виняток для NaN: тест пройдено.");
        }

        try {
            calculator.multiply(5, Double.POSITIVE_INFINITY);
            throw new AssertionError("Нескінченність: власний виняток не виник.");

        } catch (InvalidInputException e) {
            System.out.println("Власний виняток для нескінченності: тест пройдено.");
        }

        try (Scanner scanner = new Scanner("hello")) {
            scanner.nextDouble();
            throw new AssertionError("Текст замість числа: виняток не виник.");

        } catch (InputMismatchException e) {
            System.out.println("Текст замість числа: тест пройдено.");
        }
    }

    private static void checkResult(String name, double expected, double actual) {
        if (Math.abs(expected - actual) > 0.000001 || !Double.isFinite(actual)) {
            throw new AssertionError(
                    name + ": очікувалося " + expected + ", отримано " + actual
            );
        }

        System.out.println(name + ": тест пройдено.");
    }
}