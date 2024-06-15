package PflichtÜbung4;

/**
 * The Crypto class provides methods for Caesar cipher encryption and decryption.
 * It includes password validation and handling of shift values for encryption.
 */
class Crypto {
    // The password used for validation
    public static String password = "thesupersecretcompanypassword";

    /**
     * Checks if the input password matches the predefined password.
     *
     * @param inputPassword the password entered by the user
     * @return true if the passwords match, false otherwise
     */
    public static boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    /**
     * Normalizes the shift value to ensure it is within the range of 0-25.
     *
     * @param shift the original shift value
     * @return the normalized shift value
     */
    public static int normalizeShiftValue(int shift) {
        return (shift % 26 + 26) % 26;
    }

    /**
     * Encrypts the given text using the Caesar cipher with the specified shift value.
     *
     * @param textToEncrypt the text to be encrypted
     * @param shift the shift value for the Caesar cipher
     * @return the encrypted text
     */
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

    /**
     * Prepares the encrypted text by adding a prefix of the normalized shift value.
     *
     * @param shift the shift value used for encryption
     * @param encryptedText the encrypted text
     * @return the encrypted text with the shift value as a prefix
     */
    public static String normalizeShiftValueAndSetShiftAsPrefix(int shift, String encryptedText) {
        shift = normalizeShiftValue(shift);
        if (shift <= 9) {
            return "0" + shift + encryptedText;
        } else {
            return shift + encryptedText;
        }
    }

    /**
     * Decrypts the given text using the Caesar cipher with the specified shift value.
     *
     * @param textToDecrypt the text to be decrypted
     * @param shift the shift value for the Caesar cipher
     * @return the decrypted text
     */
    public static String caesarDecrypt(String textToDecrypt, int shift) {
        return caesarEncrypt(textToDecrypt, -shift);
    }

    /**
     * Extracts the shift value from the encrypted text that includes a shift value prefix.
     *
     * @param textToDecryptWithShift the encrypted text with the shift value prefix
     * @return the extracted shift value
     */
    public static int extractShiftValueFromEncryptedTextWithShiftPrefix(String textToDecryptWithShift) {
        return Integer.parseInt(textToDecryptWithShift.substring(0, 2));
    }

    /**
     * Extracts the actual encrypted text from the text that includes a shift value prefix.
     *
     * @param textToDecryptWithShift the encrypted text with the shift value prefix
     * @return the extracted encrypted text
     */
    public static String extractEncryptedTextFromEncryptedTextWithShiftPrefix(String textToDecryptWithShift) {
        return textToDecryptWithShift.substring(2);
    }
}
