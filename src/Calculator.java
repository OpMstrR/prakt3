public class Calculator {

    public double add(double a, double b) throws InvalidInputException {
        checkNumbers(a, b);
        return a + b;
    }

    public double subtract(double a, double b) throws InvalidInputException {
        checkNumbers(a, b);
        return a - b;
    }

    public double multiply(double a, double b) throws InvalidInputException {
        checkNumbers(a, b);
        return a * b;
    }

    public double divide(double a, double b) throws InvalidInputException {
        checkNumbers(a, b);

        if (b == 0) {
            throw new ArithmeticException("Ділити на нуль не можна.");
        }

        return a / b;
    }

    // Спільна перевірка для всіх чотирьох методів.
    private void checkNumbers(double a, double b) throws InvalidInputException {
        if (!Double.isFinite(a) || !Double.isFinite(b)) {
            throw new InvalidInputException(
                    "Числа мають бути скінченними. NaN та нескінченність недопустимі."
            );
        }
    }
}