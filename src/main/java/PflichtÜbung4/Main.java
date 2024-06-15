package PflichtÜbung4;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class provides the user interface for the program, allowing users to write and read encrypted notes.
 */
public class Main {

    // Creates a Scanner object for console input
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main method serves as the entry point for the program.
     * It continuously presents the user with options to write a note, read a note, or exit the program.
     * 
     * @param args command line arguments (not used)
     * @throws IOException if an I/O error occurs during file operations
     */
    public static void main(String[] args) throws IOException {
        // Declaration of variables for the encrypted text
        String filename, password;
        int shift;

        // Infinite loop to repeatedly offer options to the user
        while (true) {
            // User interface displaying available options
            System.out.println("Choose an operation:");
            System.out.println("1. Write a note");
            System.out.println("2. Read a note");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Reads the user's selection
            int selection = scanner.nextInt();
            // Removes the remaining newline character after numeric input
            scanner.nextLine();
            System.out.println();

            // Handle the user's selection
            switch (selection) {
                case 1: // Option 1: Write a note

                    // Prompt for and read input for encryption
                    System.out.print("Enter text to encrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter shift value: ");
                    shift = scanner.nextInt();
                    // Removes the remaining newline character after numeric input
                    scanner.nextLine();
                    System.out.print("Enter filename: ");
                    filename = scanner.nextLine();

                    // Encrypts the input text using the Caesar cipher
                    String encryptedText = Crypto.caesarEncrypt(text, shift);
                    // Adjusts the shift value if necessary and prepares the encrypted text for file output
                    String encryptedTextWithShiftPrefix = Crypto.normalizeShiftValueAndSetShiftAsPrefix(shift, encryptedText);
                    // Writes the encrypted text to a file
                    FileHandler.writeToFile(filename, encryptedTextWithShiftPrefix);
                    System.out.println("Encrypted text written to file: " + encryptedTextWithShiftPrefix + "\n");
                    break;

                case 2: // Option 2: Read a note
                    System.out.print("Enter password for decryption: ");
                    password = scanner.nextLine();
                    // Checks if the entered password is correct
                    if (Crypto.checkPassword(password)) {
                        System.out.print("Enter filename: ");
                        filename = scanner.nextLine();
                        // Reads the encrypted text with shift value from the file
                        String textToDecryptWithShift = FileHandler.readFromFile(filename);
                        // Extracts the shift value from the encrypted text
                        shift = Crypto.extractShiftValueFromEncryptedTextWithShiftPrefix(textToDecryptWithShift);
                        // Extracts the actual encrypted text from the text with shift value
                        String textToDecrypt = Crypto.extractEncryptedTextFromEncryptedTextWithShiftPrefix(textToDecryptWithShift);
                        // Decrypts the text using the Caesar cipher
                        String decryptedText = Crypto.caesarDecrypt(textToDecrypt, shift);
                        System.out.println("Decrypted text read from file: " + decryptedText);
                    } else {
                        System.out.println("Incorrect password, try again.");
                    }
                    System.out.println();
                    break;

                case 3: // Option 3: Exit the program
                    // Closes the scanner and exits the program
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    // Handles invalid selections
                    System.out.println("Invalid selection, please try again.");
                    break;
            }
        }
    }
}
