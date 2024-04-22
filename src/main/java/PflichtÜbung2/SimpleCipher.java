package PflichtÜbung2;

public class SimpleCipher {

    public static void main(String[] args) {
        String input = "Julius Caesar";  // Beispiel-Eingabe
        String encrypted = encryptString(input);
        System.out.println(encrypted);  // Ausgabe: Kvmjvt Dbftbs
    }

    private static String encryptString(String input) {
        char[] output = new char[input.length()];  // Erstelle ein char-Array der gleichen Länge wie der Eingabestring

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c < 'Z') {
                output[i] = (char)(c + 1);  // Ersetze den Buchstaben durch seinen Nachfolger im Alphabet
            } else if (c == 'Z') {
                output[i] = 'A';  // Spezialfall für Z zu A
            } else if (c >= 'a' && c < 'z') {
                output[i] = (char)(c + 1);  // Ersetze den Buchstaben durch seinen Nachfolger im Alphabet
            } else if (c == 'z') {
                output[i] = 'a';  // Spezialfall für z zu a
            } else {
                output[i] = c;  // Nicht-alphabetische Zeichen unverändert lassen
            }
        }

        return new String(output);  // Konvertiere das char-Array zurück in einen String
    }
}