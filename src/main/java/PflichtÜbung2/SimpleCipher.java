package PflichtÜbung2;

public class SimpleCipher {

    public static void main(String[] args) {
        String input = "Julius Caesar";  // Beispiel-Eingabe
        String encrypted = encryptString(input);
        System.out.println(encrypted);  // Ausgabe: Kvmjvt Dbftbs
    }

    private static String encryptString(String input) {
        char[] output = new char[input.length()];  // Ein Array, das jeden Buchstaben der Eingabe speichert

        // Durchlaufe jeden Buchstaben des Eingabestrings
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i); // Aktueller Buchstabe
            // Überprüfe, ob der Buchstabe ein Großbuchstabe ist
            if (currentCharacter >= 'A' && currentCharacter < 'Z') {
                output[i] = (char)(currentCharacter + 1);  // Erhöhe den Buchstaben um eins
            } else if (currentCharacter == 'Z') {
                output[i] = 'A';  // Wenn Z, dann gehe zurück zu A
                // Überprüfe, ob der Buchstabe ein Kleinbuchstabe ist
            } else if (currentCharacter >= 'a' && currentCharacter < 'z') {
                output[i] = (char)(currentCharacter + 1);  // Erhöhe den Buchstaben um eins
            } else if (currentCharacter == 'z') {
                output[i] = 'a';  // Wenn z, dann gehe zurück zu a
            } else {
                output[i] = currentCharacter;  // Lasse Zeichen, die keine Buchstaben sind, unverändert
            }
        }

        return new String(output);  // Mache aus dem Array von Buchstaben wieder einen zusammenhängenden Text
    }
}