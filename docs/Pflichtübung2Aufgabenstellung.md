# Aufgabe 1: Primzahlenberechnung 🔢

Primzahlen sind Zahlen, die nur durch 1 und sich selbst teilbar sind. Hier ist ein einfacher Weg, um Primzahlen zu berechnen:

## Definition 📚
In einer Folge ganzer Zahlen größer als 1 wird jede Zahl daraufhin untersucht, ob sie durch mindestens eine andere Zahl, die kleiner als sie selbst ist, ohne Rest teilbar ist.

- **Nicht teilbar**: Die Zahl ist eine Primzahl.
- **Teilbar**: Die Zahl ist keine Primzahl.

## Aufgabenstellung 🎯
Entwickeln Sie eine Implementierung dieses Algorithmus zur Berechnung von Primzahlen. Beachten Sie folgende Anforderungen:
- Verwenden Sie kein Array.
- Implementieren Sie das Programm in Java unter Verwendung der IDE Eclipse.

### Schritte zur Durchführung:
1. **Eingabe lesen**: Lesen Sie eine ganze Zahl von der Konsole ein.
   - Geben Sie eine Eingabeaufforderung aus.
   - Lesen Sie die Zahl ein.
2. **Primzahlen ausgeben**: Geben Sie alle Primzahlen aus, die kleiner oder gleich der eingelesenen Zahl sind.
   - Die Primzahlen sollten direkt ausgegeben werden, ohne sie zu speichern.
   - Die Reihenfolge der Ausgabe (aufsteigend oder absteigend) ist nicht relevant.




# Aufgabe 2: Einfacher Verschlüsselungsalgorithmus 🔒

Entwickeln Sie einen Algorithmus, der jeden Buchstaben in einer Zeichenkette durch seinen Nachfolger ersetzt. Hier ist eine detaillierte Beschreibung des Verschlüsselungsverfahrens:

## Definition 📚
In der gegebenen Zeichenkette wird jeder Buchstabe durch den folgenden Buchstaben im Alphabet ersetzt:
- A → B, B → C, ..., Y → Z, Z → A
- Die Groß- und Kleinschreibung bleibt unverändert.
- Alle nicht-alphabetischen Zeichen bleiben unverändert.
- Deutsche Umlaute und Sonderzeichen werden nicht berücksichtigt.

### Beispiel 🌟
Aus "Julius Caesar" wird "Kvmjvt Dbftbs".

## Aufgabenstellung 🎯
Implementieren Sie diesen Verschlüsselungsalgorithmus in Java unter Verwendung der IDE Eclipse, ohne die folgenden Java-Methoden zu verwenden:
- Methoden, die einen String direkt in ein Array of Characters umwandeln und umgekehrt.

### Schritte zur Durchführung:
1. **Zeichenkette einlesen**: Lesen Sie eine Zeichenkette von der Konsole ein.
2. **Verschlüsseln**: Ersetzen Sie jeden Buchstaben durch seinen Nachfolger im Alphabet.
3. **Ausgabe**: Geben Sie die verschlüsselte Zeichenkette aus.




# Aufgabe 3: Sieb des Eratosthenes 📏

Implementieren Sie das bekannte Verfahren zur Primzahlberechnung, das "Sieb des Eratosthenes", unter Nutzung eines Arrays. Das Ziel ist es, Primzahlen effizient zu identifizieren.

## Definition 📚
Das "Sieb des Eratosthenes" ist ein Algorithmus zur Ermittlung aller Primzahlen bis zu einer maximalen Zahl n, die von der Konsole eingelesen wird. Hier ist, wie es funktioniert:

- Ein Array repräsentiert alle ganzen Zahlen bis n.
- Nacheinander werden alle Vielfachen aller Zahlen, die kleiner als n/2 sind, im Array markiert.
- Die Zahlen, die nach diesem Prozess keine Markierung tragen, sind Primzahlen.

## Besondere Anforderung ⚠️
Die Verwendung von Multiplikation und Division ist im gesamten Quellcode untersagt.

## Aufgabenstellung 🎯
1. **Eingabe lesen**: Lesen Sie die maximale Zahl n von der Konsole ein.
2. **Array initialisieren**: Legen Sie ein Array an, das alle Zahlen bis n enthält.
3. **Vielfache markieren**: Markieren Sie die Vielfachen aller Zahlen, die kleiner als n/2 sind.
4. **Primzahlen identifizieren**: Identifizieren Sie die Zahlen im Array, die unmarkiert sind, als Primzahlen.
5. **Ausgabe**: Geben Sie die gefundenen Primzahlen aus.

### Hinweise zur Implementierung:
- Überlegen Sie sich eine geeignete Größe für das Array, um den Speicherbedarf und die Verarbeitungsgeschwindigkeit zu optimieren.




# Aufgabe 4: Umwandlung von Dezimalzahlen in Römische Zahlen 🏛️

Diese Aufgabe behandelt die Konvertierung von Dezimalzahlen in das römische Zahlensystem gemäß festgelegter Regeln.

## Definition der Römischen Zahlen 📚
Römische Zahlen verwenden spezielle Symbole, um unterschiedliche Werte darzustellen:
- Grundzahlen: **I** (1), **X** (10), **C** (100), **M** (1000)
- Zwischenzahlen: **V** (5), **L** (50), **D** (500)

### Regeln zur Bildung Römischer Zahlen:
1. **Addition**: Gleiche Grundzahlen nebeneinander werden addiert (maximal drei gleiche nebeneinander).
2. **Keine Addition bei Zwischenzahlen**: Gleiche Zwischenzahlen dürfen nicht addiert oder nebeneinander gestellt werden.
3. **Subtraktion**:
   - Kleinere Grundzahlen links von größeren werden subtrahiert (z.B. I vor V oder X).
   - Grundzahlen I, X und C dürfen nur von der nächst höheren Zwischen- oder Grundzahl subtrahiert werden.
   - Zwischenzahlen dürfen nicht subtrahiert werden.

## Aufgabenstellung 🎯
Entwickeln Sie ein Java-Programm, das:
- Eine Dezimalzahl von 1 bis zur größten nach diesen Regeln darstellbaren Zahl m einliest.
- Die eingegebene Zahl in eine römische Zahl umwandelt.
- Fehlermeldungen ausgibt für Zahlen außerhalb dieses Bereichs.

### Zusatzfrage:
- **Reflektion**: Was fällt Ihnen auf, wenn Sie an eine Analoguhr mit römischem Zifferblatt denken?
