# 📌 Crypto

### 📖 Klassenübersicht
Die `Crypto`-Klasse stellt Methoden für die Verschlüsselung und Entschlüsselung mittels des Caesar-Verschlüsselungsverfahrens bereit. Sie enthält zudem eine Passwortvalidierung und Handhabung von Verschiebewerten für die Verschlüsselung.

### 🛠 Hauptkomponenten

- **Statisches Passwort**: 
  - Das Passwort für die Validierung.
- **Methode `checkPassword`**: 
  - Überprüft, ob das eingegebene Passwort dem vordefinierten Passwort entspricht.
- **Methode `normalizeShiftValue`**: 
  - Normalisiert den Verschiebewert, um sicherzustellen, dass er im Bereich von 0-25 liegt.
- **Methode `caesarEncrypt`**: 
  - Verschlüsselt den gegebenen Text mit dem Caesar-Verschlüsselungsverfahren.
- **Methode `normalizeShiftValueAndSetShiftAsPrefix`**: 
  - Bereitet den verschlüsselten Text vor, indem ein Präfix des normalisierten Verschiebewerts hinzugefügt wird.
- **Methode `caesarDecrypt`**: 
  - Entschlüsselt den gegebenen Text mit dem Caesar-Verschlüsselungsverfahren.
- **Methode `extractShiftValueFromEncryptedTextWithShiftPrefix`**: 
  - Extrahiert den Verschiebewert aus dem verschlüsselten Text mit Präfix.
- **Methode `extractEncryptedTextFromEncryptedTextWithShiftPrefix`**: 
  - Extrahiert den tatsächlichen verschlüsselten Text aus dem Text mit Präfix.

### 📝 Detaillierte Code-Erklärung

#### Passwortvalidierung

```java
public static boolean checkPassword(String inputPassword) {
    return password.equals(inputPassword);
}
```

- **Parameter `inputPassword`**: Das vom Benutzer eingegebene Passwort.
- **Vergleich**: Überprüft, ob das eingegebene Passwort mit dem vordefinierten Passwort übereinstimmt.

#### Normalisierung des Verschiebewerts

```java
public static int normalizeShiftValue(int shift) {
    return (shift % 26 + 26) % 26;
}
```

- **Parameter `shift`**: Der ursprüngliche Verschiebewert.
- **Normalisierung**: Stellt sicher, dass der Verschiebewert im Bereich von 0-25 liegt.

#### Verschlüsselung mit dem Caesar-Verschlüsselungsverfahren

```java
public static String caesarEncrypt(String textToEncrypt, int shift) {
    shift = normalizeShiftValue(shift);
    char[] chars = new char[textToEncrypt.length()];
    for (int charIndex = 0; charIndex < textToEncrypt.length(); charIndex++) {
        char character = textToEncrypt.charAt(charIndex);
        if (character >= 'a' && character <= 'z') {
            char base = 'a';
            chars[charIndex] = (char) (base + (character - base + shift) % 26);
        } else if (character >= 'A' && character <= 'Z') {
            char base = 'A';
            chars[charIndex] = (char) (base + (character - base + shift) % 26);
        } else {
            chars[charIndex] = character;
        }
    }
    return new String(chars);
}
```

- **Parameter `textToEncrypt`**: Der zu verschlüsselnde Text.
- **Parameter `shift`**: Der Verschiebewert für das Caesar-Verschlüsselungsverfahren.
- **Normalisierung**: Normalisiert den Verschiebewert.
- **Verschlüsselung**: Verschlüsselt den Text, indem jeder Buchstabe um den Verschiebewert verschoben wird.

#### Vorbereiten des verschlüsselten Textes mit Präfix

```java
public static String normalizeShiftValueAndSetShiftAsPrefix(int shift, String encryptedText) {
    shift = normalizeShiftValue(shift);
    if (shift <= 9) {
        return "0" + shift + encryptedText;
    } else {
        return shift + encryptedText;
    }
}
```

- **Parameter `shift`**: Der Verschiebewert für die Verschlüsselung.
- **Parameter `encryptedText`**: Der verschlüsselte Text.
- **Präfix hinzufügen**: Fügt den normalisierten Verschiebewert als Präfix hinzu.

#### Entschlüsselung mit dem Caesar-Verschlüsselungsverfahren

```java
public static String caesarDecrypt(String textToDecrypt, int shift) {
    return caesarEncrypt(textToDecrypt, -shift);
}
```

- **Parameter `textToDecrypt`**: Der zu entschlüsselnde Text.
- **Parameter `shift`**: Der Verschiebewert für das Caesar-Verschlüsselungsverfahren.
- **Entschlüsselung**: Entschlüsselt den Text, indem der Verschiebewert negativ verwendet wird.

#### Extrahieren des Verschiebewerts aus dem verschlüsselten Text mit Präfix

```java
public static int extractShiftValueFromEncryptedTextWithShiftPrefix(String textToDecryptWithShift) {
    return Integer.parseInt(textToDecryptWithShift.substring(0, 2));
}
```

- **Parameter `textToDecryptWithShift`**: Der verschlüsselte Text mit Präfix.
- **Extraktion**: Extrahiert den Verschiebewert aus den ersten zwei Zeichen des Textes.

#### Extrahieren des tatsächlichen verschlüsselten Textes aus dem Text mit Präfix

```java
public static String extractEncryptedTextFromEncryptedTextWithShiftPrefix(String textToDecryptWithShift) {
    return textToDecryptWithShift.substring(2);
}
```

- **Parameter `textToDecryptWithShift`**: Der verschlüsselte Text mit Präfix.
- **Extraktion**: Extrahiert den tatsächlichen verschlüsselten Text ab dem dritten Zeichen.


# 📌 FileHandler

### 📖 Klassenübersicht
Die `FileHandler`-Klasse stellt Methoden zur Verwaltung von Dateioperationen bereit, wie z.B. das Schreiben in und Lesen von Textdateien. Sie verwendet einen Standard-Dateipfad, der festgelegt werden kann, um das Verzeichnis für Dateioperationen zu spezifizieren.

### 🛠 Hauptkomponenten

- **Standard-Dateipfad**:
  - Der Standard-Dateipfad für Dateioperationen, der auf ein beliebiges Verzeichnis gesetzt werden kann.
- **Methode `writeToFile`**:
  - Schreibt den gegebenen Text in eine Datei mit dem angegebenen Dateinamen.
- **Methode `readFromFile`**:
  - Liest den Inhalt einer Datei mit dem angegebenen Dateinamen und gibt ihn als String zurück.

### 📝 Detaillierte Code-Erklärung

#### Schreiben in eine Datei

```java
public static void writeToFile(String filename, String text) throws IOException {
    FileWriter writer = new FileWriter(defaultFilePath + filename);
    try {
        writer.write(text);
    } finally {
        writer.close();
    }
}
```

- **Parameter `filename`**: Der Name der Datei, in die geschrieben werden soll.
- **Parameter `text`**: Der Text, der in die Datei geschrieben werden soll.
- **FileWriter**: Ein Objekt, das zum Schreiben in die Datei verwendet wird.
- **Schreiben**: Schreibt den Text in die Datei.
- **Schließen**: Schließt den FileWriter, um Systemressourcen freizugeben.

#### Lesen aus einer Datei

```java
public static String readFromFile(String filename) throws IOException {
    StringBuilder text = new StringBuilder();
    BufferedReader reader = new BufferedReader(new FileReader(defaultFilePath + filename));
    try {
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append("\n");
        }
    } finally {
        reader.close();
    }
    return text.toString();
}
```

- **Parameter `filename`**: Der Name der Datei, aus der gelesen werden soll.
- **StringBuilder**: Ein Objekt, das verwendet wird, um den Dateiinhalt effizient zu sammeln.
- **BufferedReader**: Ein Objekt, das zum Lesen aus der Datei verwendet wird.
- **Lesen**: Liest jede Zeile der Datei und fügt sie dem StringBuilder hinzu.
- **Schließen**: Schließt den BufferedReader, um Systemressourcen freizugeben.
- **Rückgabe**: Gibt den gesammelten Dateiinhalt als String zurück.


# 📌 Main

### 📖 Klassenübersicht
Die `Main`-Klasse stellt die Benutzeroberfläche für das Programm bereit und ermöglicht es Benutzern, verschlüsselte Notizen zu schreiben und zu lesen.

### 🛠 Hauptkomponenten

- **Scanner**:
  - Ein Scanner-Objekt wird verwendet, um Eingaben von der Konsole zu lesen.
- **Hauptmethode (`main`)**:
  - Diese Methode dient als Einstiegspunkt für das Programm und bietet dem Benutzer kontinuierlich Optionen zum Schreiben und Lesen von Notizen oder zum Beenden des Programms.

### 📝 Detaillierte Code-Erklärung

#### Hauptmethode

```java
public static void main(String[] args) throws IOException {
    String filename, password;
    int shift;

    while (true) {
        System.out.println("Choose an operation:");
        System.out.println("1. Write a note");
        System.out.println("2. Read a note");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int selection = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (selection) {
            case 1:
                System.out

.print("Enter text to encrypt: ");
                String text = scanner.nextLine();
                System.out.print("Enter shift value: ");
                shift = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter filename: ");
                filename = scanner.nextLine();

                String encryptedText = Crypto.caesarEncrypt(text, shift);
                String encryptedTextWithShiftPrefix = Crypto.normalizeShiftValueAndSetShiftAsPrefix(shift, encryptedText);
                FileHandler.writeToFile(filename, encryptedTextWithShiftPrefix);
                System.out.println("Encrypted text written to file: " + encryptedTextWithShiftPrefix + "\n");
                break;

            case 2:
                System.out.print("Enter password for decryption: ");
                password = scanner.nextLine();
                if (Crypto.checkPassword(password)) {
                    System.out.print("Enter filename: ");
                    filename = scanner.nextLine();
                    String textToDecryptWithShift = FileHandler.readFromFile(filename);
                    shift = Crypto.extractShiftValueFromEncryptedTextWithShiftPrefix(textToDecryptWithShift);
                    String textToDecrypt = Crypto.extractEncryptedTextFromEncryptedTextWithShiftPrefix(textToDecryptWithShift);
                    String decryptedText = Crypto.caesarDecrypt(textToDecrypt, shift);
                    System.out.println("Decrypted text read from file: " + decryptedText);
                } else {
                    System.out.println("Incorrect password, try again.");
                }
                System.out.println();
                break;

            case 3:
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid selection, please try again.");
                break;
        }
    }
}
```

- **Scanner-Objekt**: Ein Objekt, das Eingaben vom Standard-Eingabegerät (üblicherweise die Tastatur) liest.
- **Endlosschleife**: Bietet dem Benutzer kontinuierlich Optionen zur Auswahl.
- **Benutzeroberfläche**: Zeigt die verfügbaren Optionen an und fordert den Benutzer zur Eingabe auf.
- **Fall 1 - Notiz schreiben**:
  - Liest den Text, den Verschiebewert und den Dateinamen ein.
  - Verschlüsselt den Text mit dem Caesar-Verschlüsselungsverfahren.
  - Fügt den normalisierten Verschiebewert als Präfix hinzu und schreibt den verschlüsselten Text in eine Datei.
  - Gibt den verschlüsselten Text auf der Konsole aus.
- **Fall 2 - Notiz lesen**:
  - Liest das Passwort und den Dateinamen ein.
  - Überprüft das Passwort.
  - Liest den verschlüsselten Text mit Präfix aus der Datei.
  - Extrahiert den Verschiebewert und den verschlüsselten Text.
  - Entschlüsselt den Text und gibt ihn auf der Konsole aus.
- **Fall 3 - Programm beenden**:
  - Schließt den Scanner und beendet das Programm.
- **Standardfall**: Handhabt ungültige Auswahlen.
