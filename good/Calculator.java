package good;

public class Calculator {
    private Operation operation;

    // Mit diesem Setter kann man bequem die "Strategie" (Operation) austauschen
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double executeCalculation(double a, double b) {
        if (operation == null) {
            throw new IllegalStateException("Es wurde keine Operation gesetzt.");
        }
        return operation.calculate(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double a = 10;
        double b = 5;

        System.out.println("=== Guter Taschenrechner ===");
        System.out.println("Zahl A = " + a + ", Zahl B = " + b);

        // Addition
        calculator.setOperation(new Addition());
        System.out.println("Addition: " + calculator.executeCalculation(a, b));

        // Subtraktion
        calculator.setOperation(new Subtraction());
        System.out.println("Subtraktion: " + calculator.executeCalculation(a, b));

        // Multiplikation
        calculator.setOperation(new Multiplication());
        System.out.println("Multiplikation: " + calculator.executeCalculation(a, b));

        // Division
        calculator.setOperation(new Division());
        System.out.println("Division: " + calculator.executeCalculation(a, b));
    }
}
