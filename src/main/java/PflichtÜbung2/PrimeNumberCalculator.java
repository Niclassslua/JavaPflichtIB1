package PflichtÜbung2;

import java.util.Scanner;

public class PrimeNumberCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine ganze Zahl ein: ");
        int maximum = scanner.nextInt();  // Lese die Obergrenze

        for (int currentNumber = 2; currentNumber <= maximum; currentNumber++) {
            if (isPrime(currentNumber)) {
                System.out.println(currentNumber);  // Gib die Primzahl aus
            }
        }
    }

    private static boolean isPrime(int numberToCheck) {
        if (numberToCheck <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= numberToCheck / 2; divisor++) {
            if (numberToCheck % divisor == 0) {
                return false;  // Wenn ein Teiler gefunden wird, ist es keine Primzahl
            }
        }
        return true;  // Wenn kein Teiler gefunden wird, ist es eine Primzahl
    }
}