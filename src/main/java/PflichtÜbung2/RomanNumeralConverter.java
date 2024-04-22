package PflichtÜbung2;

import java.util.Scanner;

public class RomanNumeralConverter {

    public static void main(String[] args) {
        // Erstellt ein Scanner-Objekt, um Nutzereingaben von der Konsole zu lesen.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine Zahl zwischen 1 und 3999 ein: ");
        int number = scanner.nextInt(); // Liest die eingegebene Zahl.

        // Überprüft, ob die eingegebene Zahl im gültigen Bereich liegt.
        if (number < 1 || number > 3999) {
            // Gibt eine Fehlermeldung aus, wenn die Zahl außerhalb des Bereichs liegt.
            System.out.println("Fehler: Die Zahl liegt außerhalb des gültigen Bereichs.");
        } else {
            // Konvertiert die gültige Zahl in eine römische Zahl und gibt sie aus.
            String roman = toRoman(number);
            System.out.println("Römische Zahl: " + roman);
        }
    }

    // Methode zur Konvertierung einer Dezimalzahl in eine römische Zahl
    private static String toRoman(int number) {
        // Arrays, die die römischen Ziffern und ihre entsprechenden Werte enthalten.
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Initialisiert den String, der die römische Zahl darstellen wird.
        String roman = "";
        // Durchläuft die Werte und fügt entsprechende römische Ziffern zum Ergebnis hinzu.
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman += romanLiterals[i];  // Fügt die römische Ziffer zum String hinzu.
                number -= values[i];  // Reduziert die Dezimalzahl um den Wert der römischen Ziffer.
            }
        }
        return roman; // Gibt die gebildete römische Zahl zurück.
    }
}