package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    // Method to read the content of a file as a String
    public static String readFileToString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Method to write content to a file
    public static void writeStringToFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }

    // Method to delete a file
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    // Method to copy a file
    public static void copyFile(String sourcePath, String destinationPath) throws IOException {
        Files.copy(Paths.get(sourcePath), Paths.get(destinationPath));
    }

    // Method to check if a file exists
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
