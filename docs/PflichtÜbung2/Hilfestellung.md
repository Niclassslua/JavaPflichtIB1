# Aufgabe 1: Berechnung von Primzahlen 🔍

Entwickeln Sie ein Java-Programm zur Berechnung von Primzahlen ohne die Verwendung von Arrays. Das Programm soll Primzahlen bis zu einer vom Benutzer bestimmten Zahl n berechnen.

## Was sind Primzahlen?
Primzahlen sind natürliche Zahlen größer als 1, die nur durch 1 und sich selbst ohne Rest teilbar sind.

## Aufgabenstellung 🎯
- **Eingabe**: Der Benutzer wird aufgefordert, eine ganze Zahl n von der Konsole einzugeben.
- **Verarbeitung**: Das Programm berechnet alle Primzahlen, die kleiner oder gleich n sind.
- **Ausgabe**: Die gefundenen Primzahlen werden direkt ausgegeben.

## Pseudocode
```plaintext
BEGINN
  AUSGABE "Geben Sie eine ganze Zahl ein:"
  LESE maximum
  FÜR jede Zahl currentNumber von 2 bis maximum
    WENN isPrime(currentNumber) gleich WAHR
      AUSGABE currentNumber  // Gib die Primzahl aus
    ENDE WENN
  ENDE FÜR
ENDE

FUNKTION isPrime(numberToCheck)
  WENN numberToCheck <= 1
    RÜCKGABE FALSCH
  ENDE WENN
  
  FÜR divisor von 2 bis numberToCheck / 2
    WENN numberToCheck modulo divisor gleich 0
      RÜCKGABE FALSCH  // Wenn ein Teiler gefunden wird, ist es keine Primzahl
    ENDE WENN
  ENDE FÜR
  
  RÜCKGABE WAHR  // Wenn kein Teiler gefunden wird, ist es eine Primzahl
ENDE FUNKTION
```

## Fehlerbehandlung
- Das Programm überprüft, ob die eingegebene Zahl n kleiner als 2 ist, und gibt in diesem Fall eine entsprechende Nachricht aus. Dies ist wichtig, da es keine Primzahlen kleiner als 2 gibt.

## Technische Details
- **maximum**: Die obere Grenze für die Primzahlsuche, eingegeben vom Benutzer als Ganzzahl (`int`).
- **currentNumber**: Die aktuell geprüfte Zahl (`int`).
- **divisor**: Zählvariable in der Schleife, verwendet, um mögliche Teiler der aktuellen Zahl zu testen (`int`).
- **isPrime**: Eine Funktion, die prüft, ob eine gegebene Zahl eine Primzahl ist. Sie nimmt eine Ganzzahl (`int`) als Argument und gibt einen booleschen Wert (`boolean`) zurück.

## Ausführungsdetails
- Das Programm nutzt eine Funktion `isPrime`, um die Lesbarkeit und Wartbarkeit des Codes zu verbessern. Diese Funktion isoliert die Logik zur Primzahlerkennung, was eine klare Trennung der Funktionalität ermöglicht.




# Aufgabe 2: Einfacher Verschlüsselungsalgorithmus 🗝️

Implementieren Sie ein Java-Programm, das einen gegebenen Text durch Verschieben jedes Buchstabens um eine Position im Alphabet verschlüsselt. Nicht-Buchstaben bleiben unverändert.

## Verschlüsselungsverfahren
Das Programm verschiebt jeden Buchstaben des Eingabetextes um eine Position im Alphabet weiter:
- A wird zu B, B wird zu C, ..., Y wird zu Z, und Z geht zurück zu A.
- a wird zu b, b wird zu c, ..., y wird zu z, und z geht zurück zu a.
- Alle anderen Zeichen bleiben unverändert.

## Aufgabenstellung 🎯
- **Eingabe**: Ein vordefinierter String (z.B. "Julius Caesar").
- **Verarbeitung**: Verschieben Sie jeden Buchstaben um eine Position im Alphabet.
- **Ausgabe**: Geben Sie den verschlüsselten String aus.

## Pseudocode
```plaintext
BEGINN
  DEFINIERE input als "Julius Caesar"  // Beispiel-Eingabe
  DEFINIERE encrypted als encryptString(input)
  AUSGABE encrypted  // Ausgabe: Kvmjvt Dbftbs
ENDE

FUNKTION encryptString(input)
  DEFINIERE output als ein Array der Länge von input
  FÜR jeden Index i von 0 bis Länge von input - 1
    LESE currentCharacter aus input an Position i
    WENN currentCharacter zwischen 'A' und 'Y' oder zwischen 'a' und 'y'
      SETZE output[i] auf currentCharacter + 1
    SONST WENN currentCharacter ist 'Z'
      SETZE output[i] auf 'A'
    SONST WENN currentCharacter ist 'z'
      SETZE output[i] auf 'a'
    SONST
      SETZE output[i] auf currentCharacter  // Unverändert lassen
    ENDE WENN
  ENDE FÜR
  RÜCKGABE neuen String aus output
ENDE FUNKTION
```

## Technische Details
- **input**: String, der die Eingabezeichenkette darstellt (`String`).
- **encrypted**: String, der die verschlüsselte Zeichenkette speichert (`String`).
- **output**: Charakterarray, das die einzelnen verschlüsselten Zeichen speichert (`char[]`).
- **currentCharacter**: Variable zur Speicherung des aktuellen Zeichens während der Verschlüsselung (`char`).

## Fehlerbehandlung
- Das Programm behandelt spezielle Fälle wie den Übergang von 'Z' zu 'A' und von 'z' zu 'a', um sicherzustellen, dass das Alphabet korrekt zirkuliert.




# Aufgabe 3: Sieb des Eratosthenes 🔍

Implementieren Sie das "Sieb des Eratosthenes", einen effizienten Algorithmus zur Identifizierung aller Primzahlen bis zu einer vom Benutzer bestimmten maximalen Zahl.

## Was sind Primzahlen?
Primzahlen sind natürliche Zahlen größer als 1, die keine anderen Teiler außer 1 und sich selbst haben.

## Aufgabenstellung 🎯
- **Eingabe**: Der Benutzer gibt eine maximale Zahl von der Konsole ein.
- **Verarbeitung**: Das Programm identifiziert alle Primzahlen bis zu dieser maximalen Zahl.
- **Ausgabe**: Die gefundenen Primzahlen werden auf der Konsole ausgegeben.

## Pseudocode
```plaintext
BEGINN
  AUSGABE "Geben Sie eine maximale Zahl ein:"
  LESE maxNumber
  DEFINIERE isPrime als ein Array von Booleschen Werten der Länge maxNumber + 1
  SETZE alle Einträge von isPrime ab Index 2 auf WAHR
  
  FÜR jede Zahl number von 2 bis maxNumber / 2
    WENN isPrime[number] gleich WAHR
      SETZE multiple auf number
      WÄHREND multiple + number <= maxNumber
        SETZE multiple auf multiple + number
        SETZE isPrime[multiple] auf FALSCH
      ENDE WÄHREND
    ENDE WENN
  ENDE FÜR
  
  AUSGABE "Primzahlen bis " + maxNumber + ":"
  FÜR jede Zahl i von 2 bis maxNumber
    WENN isPrime[i] gleich WAHR
      AUSGABE i + " "
    ENDE WENN
  ENDE FÜR
ENDE
```

## Technische Details
- **maxNumber**: Die maximale Zahl, bis zu der Primzahlen gefunden werden sollen, eingegeben als Ganzzahl (`int`).
- **isPrime**: Ein Boolesches Array, das für jede Zahl bis maxNumber angibt, ob sie eine Primzahl ist (`boolean[]`). Anfänglich werden alle Werte ab Index 2 auf `true` gesetzt, um sie als potenzielle Primzahlen zu markieren.
- **multiple**: Hilfsvariable zum Markieren der Vielfachen einer Primzahl als nicht prim (`int`).

## Fehlerbehandlung
- Die Eingabe wird davon ausgegangen, dass sie eine positive ganze Zahl ist. Fehlerhafte oder ungültige Eingaben könnten durch zusätzliche Validierung abgefangen werden.




# Aufgabe 4: Umwandlung von Dezimalzahlen in Römische Zahlen 🏛️

Implementieren Sie ein Java-Programm zur Umwandlung von Dezimalzahlen in römische Zahlen. Der gültige Bereich für Eingabewerte ist von 1 bis 3999.

## Was sind römische Zahlen?
Römische Zahlen sind eine Ziffernfolge, die zur Darstellung von Zahlen im alten Rom verwendet wurde und noch heute in bestimmten Kontexten genutzt wird.

## Aufgabenstellung 🎯
- **Eingabe**: Der Benutzer gibt eine Zahl zwischen 1 und 3999 von der Konsole ein.
- **Überprüfung**: Das Programm überprüft, ob die Zahl im gültigen Bereich liegt.
- **Verarbeitung**: Wenn die Zahl gültig ist, wird sie in eine römische Zahl umgewandelt.
- **Ausgabe**: Die umgewandelte römische Zahl wird ausgegeben.

## Pseudocode
```plaintext
BEGINN
  AUSGABE "Geben Sie eine Zahl zwischen 1 und 3999 ein:"
  LESE number
  WENN number < 1 ODER number > 3999
    AUSGABE "Fehler: Die Zahl liegt außerhalb des gültigen Bereichs."
  SONST
    DEFINIERE roman als toRoman(number)
    AUSGABE "Römische Zahl: " + roman
  ENDE WENN
ENDE

FUNKTION toRoman(number)
  DEFINIERE values als Array von [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
  DEFINIERE romanLiterals als Array von ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
  DEFINIERE roman als leerer String
  FÜR jeden Index i von 0 bis Länge von values - 1
    WÄHREND number >= values[i]
      FÜGE romanLiterals[i] zu roman hinzu
      REDUZIERE number um values[i]
    ENDE WÄHREND
  ENDE FÜR
  RÜCKGABE roman
ENDE FUNKTION
```

## Technische Details
- **number**: Die eingegebene Dezimalzahl, die in eine römische Zahl umgewandelt wird (`int`).
- **values**: Ein Array von Ganzzahlen, das die Werte der römischen Ziffern enthält (`int[]`).
- **romanLiterals**: Ein Array von Zeichenketten, das die römischen Ziffern darstellt (`String[]`).
- **roman**: Die Zeichenkette, die die resultierende römische Zahl enthält (`String`).

## Fehlerbehandlung
- Eine Fehlermeldung wird ausgegeben, wenn die eingegebene Zahl außerhalb des gültigen Bereichs liegt. Dies stellt sicher, dass nur korrekte Werte verarbeitet werden.
