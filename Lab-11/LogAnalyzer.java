
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        Path folder = Paths.get("logs");
        String keyword = "ERROR";

        int totalLines = 0;
        int keywordCount = 0;

        try {
            // Create the folder if it does not exist
            Files.createDirectories(folder);

            // Create sample log files
            Path file1 = folder.resolve("log1.txt");
            Path file2 = folder.resolve("log2.txt");

            Files.write(file1, Arrays.asList(
                "INFO: Application started",
                "ERROR: File not found",
                "INFO: Application completed"
            ));

            Files.write(file2, Arrays.asList(
                "ERROR: Connection failed",
                "INFO: Restart successful"
            ));

            Path[] files = {file1, file2};

            // Analyze each file
            for (Path file : files) {
                System.out.println("\nFile: "
                                   + file.getFileName());

                List<String> lines = Files.readAllLines(file);
                long size = Files.size(file);

                for (String line : lines) {
                    totalLines++;

                    if (line.contains(keyword)) {
                        keywordCount++;
                    }
                }

                System.out.println("Size: " + size + " bytes");
                System.out.println("Lines: " + lines.size());
            }

            // Display final summary
            System.out.println("\n----- SUMMARY -----");
            System.out.println("Total lines: " + totalLines);
            System.out.println("ERROR occurrences: "
                               + keywordCount);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
