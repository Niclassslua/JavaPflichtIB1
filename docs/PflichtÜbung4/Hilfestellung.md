# `Main` - Benutzerschnittstelle für das Notizprogramm 🖥️

## Klassenbeschreibung
Die `Main`-Klasse stellt die Benutzerschnittstelle für das Programm bereit und ermöglicht dem Benutzer das Schreiben und Lesen von verschlüsselten Notizen.

## Funktionen der `Main`-Klasse 🎯
1. **Hauptmenü anzeigen und Benutzereingaben verarbeiten**:
   - Optionen: "1. Write a note", "2. Read a note", "3. Exit"
   - Basierend auf der Auswahl des Benutzers, werden entsprechende Aktionen durchgeführt.

2. **Option 1: Eine Notiz schreiben**:
   - Benutzereingaben: Text, Verschiebungswert (Shift), Dateiname.
   - Text verschlüsseln und in die Datei schreiben.

3. **Option 2: Eine Notiz lesen**:
   - Benutzereingaben: Passwort, Dateiname.
   - Dateiinhalt lesen, entschlüsseln und anzeigen.

## Pseudocode
```plaintext
BEGINN
  ERSTELLE Scanner-Objekt
  SCHLEIFE unendlich
    ANZEIGE Menüoptionen
    LESE Benutzerauswahl
    SCHALTE Basierend auf Benutzerauswahl
      FALL 1: Schreibe eine Notiz
        LESE Text, Shift-Wert und Dateiname
        VERSCHLÜSSEL den Text
        SCHREIBE den verschlüsselten Text in die Datei
        ANZEIGE Erfolgsmeldung
      FALL 2: Lese eine Notiz
        LESE Passwort
        WENN Passwort korrekt
          LESE Dateiname
          LESE verschlüsselten Text aus der Datei
          ENTSCHLÜSSEL den Text
          ANZEIGE den entschlüsselten Text
        SONST
          ANZEIGE Fehlermeldung
      FALL 3: Beende das Programm
        BEENDEN
      STANDARD: Ungültige Auswahl
        ANZEIGE Fehlermeldung
    ENDE SCHALTE
  ENDE SCHLEIFE
ENDE
```

## Technische Details
- **scanner**: Scanner-Objekt für die Konsoleneingabe (`Scanner`).
- **filename**: Der Dateiname für die Notizdatei (`String`).
- **password**: Das Passwort für die Entschlüsselung (`String`).
- **shift**: Der Verschiebungswert für die Caesar-Verschlüsselung (`int`).

---

# `Crypto` - Verschlüsselungslogik 🗝️

## Klassenbeschreibung
Die `Crypto`-Klasse stellt Methoden zur Verschlüsselung und Entschlüsselung von Texten mittels des Caesar-Verschlüsselungsalgorithmus bereit.

## Funktionen der `Crypto`-Klasse 🎯
1. **Passwortüberprüfung**:
   - Überprüft, ob das eingegebene Passwort korrekt ist.

2. **Verschiebungswert normalisieren**:
   - Normalisiert den Verschiebungswert, um sicherzustellen, dass er im Bereich von 0-25 liegt.

3. **Caesar-Verschlüsselung**:
   - Verschlüsselt einen gegebenen Text mit dem angegebenen Verschiebungswert.

4. **Caesar-Entschlüsselung**:
   - Entschlüsselt einen gegebenen Text mit dem angegebenen Verschiebungswert.

5. **Verschiebungswert aus verschlüsseltem Text extrahieren**:
   - Extrahiert den Verschiebungswert aus dem verschlüsselten Text mit Präfix.

## Pseudocode
```plaintext
FUNKTION checkPassword(inputPassword)
  VERGLEICHE inputPassword mit dem gespeicherten Passwort
  RÜCKGABE true WENN sie übereinstimmen, sonst false

FUNKTION normalizeShiftValue(shift)
  BERECHNE shift % 26
  RÜCKGABE des normierten shift

FUNKTION caesarEncrypt(textToEncrypt, shift)
  NORMALISIERE den shift
  ITERIERE durch jedes Zeichen im textToEncrypt
    VERSCHIEBE das Zeichen basierend auf dem shift-Wert
  RÜCKGABE des verschlüsselten Textes

FUNKTION caesarDecrypt(textToDecrypt, shift)
  VERSCHIEBE textToDecrypt mit -shift
  RÜCKGABE des entschlüsselten Textes

FUNKTION extractShiftValueFromEncryptedTextWithShiftPrefix(textToDecryptWithShift)
  EXTRAHIERE die ersten zwei Zeichen als shift
  RÜCKGABE des shift

FUNKTION extractEncryptedTextFromEncryptedTextWithShiftPrefix(textToDecryptWithShift)
  ENTFERNE die ersten zwei Zeichen aus dem Text
  RÜCKGABE des restlichen Textes
```

## Technische Details
- **password**: Vordefiniertes Passwort für die Überprüfung (`String`).
- **shift**: Der Verschiebungswert für die Verschlüsselung/Entschlüsselung (`int`).

---

# `FileHandler` - Dateioperationen 💾

## Klassenbeschreibung
Die `FileHandler`-Klasse stellt Methoden zum Schreiben und Lesen von Textdateien bereit.

## Funktionen der `FileHandler`-Klasse 🎯
1. **Schreiben in Datei**:
   - Schreibt einen gegebenen Text in eine Datei.

2. **Lesen aus Datei**:
   - Liest den Inhalt einer Datei und gibt ihn als String zurück.

## Pseudocode
```plaintext
FUNKTION writeToFile(filename, text)
  ERSTELLE FileWriter-Objekt
  SCHREIBE text in die Datei
  SCHLIEẞE FileWriter

FUNKTION readFromFile(filename)
  ERSTELLE StringBuilder
  ERSTELLE BufferedReader-Objekt
  SCHLEIFE durch jede Zeile der Datei
    FÜGE Zeile zum StringBuilder hinzu
  SCHLIEẞE BufferedReader
  RÜCKGABE des gesamten Textes als String
```

## Technische Details
- **defaultFilePath**: Der Standardpfad für Dateioperationen (`String`).
- **filename**: Der Name der Datei, die geschrieben oder gelesen wird (`String`).
- **text**: Der Text, der in die Datei geschrieben oder aus der Datei gelesen wird (`String`).
