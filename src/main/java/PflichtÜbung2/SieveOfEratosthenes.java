package PflichtÜbung2;

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine maximale Zahl ein: ");
        int maxNumber = scanner.nextInt();  // Lese die obere Grenze für die Primzahlberechnung

        // Array zur Markierung von Primzahlen
        boolean[] isPrime = new boolean[maxNumber + 1];

        // Initialisiere alle Zahlen als mögliche Primzahlen
        for (int i = 2; i <= maxNumber; i++) {
            isPrime[i] = true;
        }

        // Sieb des Eratosthenes ohne Multiplikation oder Division
        for (int number = 2; number <= maxNumber / 2; number++) {
            if (isPrime[number]) {
                int multiple = number;
                while (multiple + number <= maxNumber) {
                    multiple += number;
                    isPrime[multiple] = false;
                }
            }
        }

        // Ausgabe der Primzahlen
        System.out.println("Primzahlen bis " + maxNumber + ":");
        for (int i = 2; i <= maxNumber; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}