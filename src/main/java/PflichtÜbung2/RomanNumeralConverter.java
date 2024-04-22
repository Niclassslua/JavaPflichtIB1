package PflichtÜbung2;

import java.util.Scanner;

public class RomanNumeralConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine Zahl zwischen 1 und 3999 ein: ");
        int number = scanner.nextInt();

        if (number < 1 || number > 3999) {
            System.out.println("Fehler: Die Zahl liegt außerhalb des gültigen Bereichs.");
        } else {
            String roman = toRoman(number);
            System.out.println("Römische Zahl: " + roman);
        }
    }

    private static String toRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman += romanLiterals[i];  // Füge den entsprechenden römischen Literal hinzu
                number -= values[i];  // Verringere die Zahl um den Wert des römischen Literals
            }
        }
        return roman;
    }
}