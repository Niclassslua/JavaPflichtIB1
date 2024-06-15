package PflichtÜbung4;

import java.io.*;

/**
 * The FileHandler class provides methods for managing file operations such as writing to and reading from text files.
 * It uses a default file path which can be set to specify the directory for file operations.
 */
class FileHandler {
    // Default file path for file operations, can be set to any desired directory
    static String defaultFilePath = "";

    /**
     * Writes the given text to a file with the specified filename.
     * The file is created in the default file path directory.
     *
     * @param filename the name of the file to write to
     * @param text the text to write into the file
     * @throws IOException if an I/O error occurs during the file writing process
     */
    public static void writeToFile(String filename, String text) throws IOException {
        // Create a FileWriter object to write to the specified file
        FileWriter writer = new FileWriter(defaultFilePath + filename);
        try {
            // Write the text to the file
            writer.write(text);
        } finally {
            // Close the writer to release system resources
            writer.close();
        }
    }

    /**
     * Reads the contents of a file with the specified filename.
     * The file is read from the default file path directory.
     *
     * @param filename the name of the file to read from
     * @return the contents of the file as a String
     * @throws IOException if an I/O error occurs during the file reading process
     */
    public static String readFromFile(String filename) throws IOException {
        // Use a StringBuilder to efficiently accumulate the file contents
        StringBuilder text = new StringBuilder();
        // Create a BufferedReader to read from the specified file
        BufferedReader reader = new BufferedReader(new FileReader(defaultFilePath + filename));
        try {
            String line;
            // Read each line of the file and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } finally {
            // Close the reader to release system resources
            reader.close();
        }
        // Return the accumulated file contents as a String
        return text.toString();
    }
}
