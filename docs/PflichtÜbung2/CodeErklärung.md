# Aufgabe 1: Primzahlenberechnung 🔢

Primzahlen sind Zahlen, die nur durch 1 und sich selbst teilbar sind. Hier ist ein einfacher Weg, um Primzahlen zu berechnen:


## 📌 PrimeNumberCalculator

### 📖 Programmübersicht
Das Programm `PrimeNumberCalculator` nutzt Java, um alle Primzahlen bis zu einer vom Benutzer festgelegten Obergrenze zu identifizieren und anzuzeigen. Eine Primzahl ist eine natürliche Zahl größer als 1, die nur durch sich selbst und 1 teilbar ist.

### 🛠 Hauptkomponenten

- **Scanner**:
  - Ein Scanner-Objekt wird verwendet, um Eingaben von der Konsole zu lesen.
- **Hauptmethode (`main`)**:
  - Diese Methode startet das Programm, fordert den Benutzer auf, eine Zahl einzugeben, und steuert die Berechnung der Primzahlen.
- **Hilfsmethode (`isPrime`)**:
  - Eine Hilfsmethode, die bestimmt, ob eine gegebene Zahl eine Primzahl ist.

### 📝 Detaillierte Code-Erklärung

#### Einlesen der Eingabe

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Geben Sie eine ganze Zahl ein: ");
int maximum = scanner.nextInt();  // Lese die Obergrenze
```

- **Scanner-Objekt**: Ein Objekt, das Eingaben vom Standard-Eingabegerät (üblicherweise die Tastatur) liest.
- **System.out.print**: Gibt eine Nachricht auf der Konsole aus, die den Benutzer auffordert, eine Zahl einzugeben.
- **nextInt()**: Liest die nächste Eingabe als Ganzzahl (`int`).

#### Durchlaufen aller Zahlen bis zur oberen Grenze

```java
for (int currentNumber = 2; currentNumber <= maximum; currentNumber++) {
    if (isPrime(currentNumber)) {
        System.out.println(currentNumber);  // Gib die Primzahl aus
    }
}
```

- **For-Schleife**: Iteriert über alle Zahlen von 2 bis zur eingegebenen Obergrenze `maximum`.
- **isPrime-Methode**: Überprüft, ob die aktuelle Zahl `currentNumber` eine Primzahl ist.
- **System.out.println**: Gibt die Primzahl aus, wenn die Bedingung `isPrime(currentNumber)` `true` zurückgibt.

#### Bestimmung der Primzahleigenschaft

```java
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
```

- **Parameter `numberToCheck`**: Die Zahl, die auf Primzahleigenschaften überprüft wird.
- **Frühe Rückkehr**: Gibt sofort `false` zurück, wenn `numberToCheck` kleiner oder gleich 1 ist, da 1 keine Primzahl ist.
- **Innere For-Schleife**: Überprüft die Teilbarkeit von `numberToCheck` durch jede Zahl von 2 bis `numberToCheck / 2`.
- **Modulo-Operator `%`**: Bestimmt, ob `numberToCheck` ohne Rest durch `divisor` teilbar ist.
- **Rückgabe `true`**: Gibt `true` zurück, wenn keine Zahl gefunden wurde, die `numberToCheck` teilt, was bedeutet, dass `numberToCheck` eine Primzahl ist.

---


# Aufgabe 2: Einfacher Verschlüsselungsalgorithmus 🔒

Entwickeln Sie einen Algorithmus, der jeden Buchstaben in einer Zeichenkette durch seinen Nachfolger ersetzt. Hier ist eine detaillierte Beschreibung des Verschlüsselungsverfahrens:


## 📜 SimpleCipher

### 📖 Programmübersicht
Das Programm `SimpleCipher` ist eine einfache Implementierung eines Verschlüsselungsalgorithmus, der jeden Buchstaben in einem gegebenen Text durch seinen nachfolgenden Buchstaben im Alphabet ersetzt. Zahlen und Sonderzeichen bleiben unverändert. Es wird hauptsächlich in Java geschrieben.

### 🛠 Hauptkomponenten

- **Hauptmethode (`main`)**:
  - Startet das Programm und gibt das Ergebnis der Verschlüsselung auf der Konsole aus.
- **Verschlüsselungsmethode (`encryptString`)**:
  - Nimmt einen Eingabestring entgegen und gibt den verschlüsselten String zurück.

### 📝 Detaillierte Code-Erklärung

#### Einlesen der Eingabe und Ausführen der Verschlüsselung

```java
String input = "Julius Caesar";  // Beispiel-Eingabe
String encrypted = encryptString(input);
System.out.println(encrypted);  // Ausgabe: Kvmjvt Dbftbs
```

- **Eingabezeichenfolge**: "Julius Caesar" wird als Beispiel verwendet, um die Funktionsweise des Algorithmus zu demonstrieren.
- **Verschlüsselte Ausgabe**: Der verschlüsselte String "Kvmjvt Dbftbs" wird ausgegeben.

#### Verschlüsselungsfunktion `encryptString`

```java
private static String encryptString(String input) {
    char[] output = new char[input.length()];  // Ein Array, das jeden Buchstaben der Eingabe speichert

    for (int i = 0; i < input.length(); i++) {
        char currentCharacter = input.charAt(i); // Aktueller Buchstabe
        if (currentCharacter >= 'A' && currentCharacter < 'Z') {
            output[i] = (char)(currentCharacter + 1);  // Erhöhe den Buchstaben um eins
        } else if (currentCharacter == 'Z') {
            output[i] = 'A';  // Wenn Z, dann gehe zurück zu A
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
```

- **Array zur Speicherung der Zeichen**: Ein Array wird verwendet, um die veränderten Zeichen zu speichern.
- **Durchlauf jedes Zeichens**: Der Code durchläuft jedes Zeichen des Eingabestrings.
- **Bedingungen für Buchstaben**: Unterscheidet zwischen Groß- und Kleinbuchstaben und passt sie entsprechend an. Zum Beispiel wird `A` zu `B`, `Z` zu `A`, etc.
- **Unveränderte Zeichen**: Nicht-alphabetische Zeichen bleiben in der Ausgabe unverändert.


# Aufgabe 3: Sieb des Eratosthenes 📏

Implementieren Sie das bekannte Verfahren zur Primzahlberechnung, das "Sieb des Eratosthenes", unter Nutzung eines Arrays. Das Ziel ist es, Primzahlen effizient zu identifizieren.





# Aufgabe 4: Umwandlung von Dezimalzahlen in Römische Zahlen 🏛️

Diese Aufgabe behandelt die Konvertierung von Dezimalzahlen in das römische Zahlensystem gemäß festgelegter Regeln.

