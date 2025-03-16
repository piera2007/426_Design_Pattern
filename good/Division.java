package good;

public class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch Null ist nicht erlaubt!");
        }
        return a / b;
    }
}

