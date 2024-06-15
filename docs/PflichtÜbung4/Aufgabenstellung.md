# Aufgabe: Internes Notizprogramm erweitern 📑

Im Rahmen Ihrer Tätigkeit als Werkstudent bei der Secure-File-Company haben Sie die Gelegenheit, Ihr Fachwissen einzubringen, um ein internes Notizprogramm an die neuen Datenschutzanforderungen anzupassen. Ihr Ziel ist es, das Programm um die Möglichkeit zu erweitern, verschlüsselte Notizen in Dateien zu speichern und diese später wieder zu lesen.

## Aufgabe 1: Erweiterung des Programms 🛠️

### Implementierung von Dateioperationen 💾
Erweitern Sie die FileHandler-Klasse um folgende Methoden:
1. **writeToFile**: Diese Methode soll einen übergebenen String in eine Datei schreiben.
   - **Signatur**: `public static void writeToFile(String filename, String text)`
2. **readFromFile**: Diese Methode soll es erlauben, die mit der writeToFile-Methode erstellten und beschriebenen Dateien wieder auszulesen und deren Inhalt zurückzugeben.
   - **Signatur**: `public static String readFromFile(String filename)`

### Erweiterung der Benutzerschnittstelle 🖥️
Passen Sie die Main-Klasse folgendermaßen an:
1. **Option "1. Write a note"**:
   - Verschlüsseln Sie den Text.
   - Schreiben Sie den verschlüsselten Text in eine beliebige Datei.
2. **Neue Option "2. Read a note"**:
   - Lesen Sie eine verschlüsselte Notiz aus einer Datei.
   - Geben Sie den verschlüsselten Text mittels der Konsole aus.

### Zusätzliche Informationen ℹ️
- **Main-Klasse**: Diese Klasse dient als Schnittstelle zum Benutzer und steuert die Interaktion über die Konsole.
- **FileHandler-Klasse**: Diese Klasse ist für alle Dateioperationen zuständig, einschließlich Schreiben und Lesen von Textdateien.
- **Crypto-Klasse**: Diese Klasse enthält die Logik zur Verschlüsselung von Texten und wird Ihnen bereits vollständig bereitgestellt. An der Crypto-Klasse sollen keine Änderungen vorgenommen werden.

### Beispielhafte Konsoleninteraktionen 🌟
```java
Choose an operation:
1. Write a note
2. Read a note
0. Exit
Enter your choice: 1

Enter text to encrypt: Hello World!
Enter shift value: 13
Enter filename: secret.txt
Encrypted text written to file: 13Uryyb Jbeyq!

Choose an operation:
1. Write a note
2. Read a note
0. Exit
Enter your choice: 2

Enter filename: secret.txt
Encrypted text read from file: 13Uryyb Jbeyq!
```

### Schritte zur Durchführung:
1. **Methoden implementieren**:
   - Implementieren Sie die Methode `writeToFile` in der FileHandler-Klasse, um einen Text in eine Datei zu schreiben.
   - Implementieren Sie die Methode `readFromFile` in der FileHandler-Klasse, um den Inhalt einer Datei zu lesen.
2. **Benutzerschnittstelle anpassen**:
   - Passen Sie die Main-Klasse so an, dass die Option "1. Write a note" den verschlüsselten Text in eine Datei schreibt.
   - Fügen Sie die Option "2. Read a note" hinzu, um eine verschlüsselte Notiz aus einer Datei zu lesen und auf der Konsole anzuzeigen
