package bad;

public class BadCalculator {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("=== Schlechter Taschenrechner ===");
        System.out.println("Zahl A = " + a + ", Zahl B = " + b);
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraktion: " + (a - b));
        System.out.println("Multiplikation: " + (a * b));
        System.out.println("Division: " + (a / b));

        /*
         * PROBLEME:
         * 1) Alle Operationen sind in dieser einen Methode "zusammengeklebt".
         * 2) Jede Änderung (z.B. neue Operationen) erfordert das Editieren dieser Klasse.
         * 3) Verstösst gegen das Single Responsibility Principle.
         */
    }
}
