package PflichtÜbung2;

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        // Ein Scanner-Objekt, um Benutzereingaben von der Konsole zu lesen.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine maximale Zahl ein: ");
        int maxNumber = scanner.nextInt();  // Die maximale Zahl, bis zu der Primzahlen gefunden werden sollen.

        // Ein Array, das anzeigt, ob eine Zahl eine Primzahl ist (true) oder nicht (false).
        boolean[] isPrime = new boolean[maxNumber + 1];  // +1, weil wir bei Index 0 anfangen.

        // Initialisiere alle Zahlen ab 2 als mögliche Primzahlen.
        for (int i = 2; i <= maxNumber; i++) {
            isPrime[i] = true;
        }

        // Sieb des Eratosthenes ohne Multiplikation oder Division
        for (int number = 2; number <= maxNumber; number++) {
            if (isPrime[number]) {
                int multiple = number + number;  // Beginne mit dem ersten Vielfachen der Zahl, das größer als sie selbst ist.
                while (multiple <= maxNumber) {
                    isPrime[multiple] = false;  // Dieses Vielfache ist keine Primzahl.
                    multiple += number;  // Gehe zum nächsten Vielfachen, indem du die Zahl addierst.
                }
            }
        }

        // Ausgabe der Primzahlen bis zur eingegebenen maximalen Zahl.
        System.out.println("Primzahlen bis " + maxNumber + ":");
        for (int i = 2; i <= maxNumber; i++) {
            if (isPrime[i]) {  // Wenn die Zahl als Primzahl markiert ist, gib sie aus.
                System.out.print(i + " ");
            }
        }
    }
}
