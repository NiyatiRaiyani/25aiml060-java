
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.BufferedWriter;
import java.io.IOException;

public class FolderReport {
    public static void main(String[] args) {
        Path folder = Paths.get(".");
        Path report = Paths.get("report.txt");

        System.out.println("Program started...");

        try (BufferedWriter writer =
                 Files.newBufferedWriter(report)) {

            writer.write("FOLDER TREE REPORT");
            writer.newLine();

            Files.walkFileTree(folder,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(
                            Path file,
                            BasicFileAttributes attr)
                            throws IOException {

                        System.out.println("File: " + file);

                        writer.write("Name: " + file);
                        writer.newLine();
                        writer.write("Size: "
                                      + attr.size() + " bytes");
                        writer.newLine();
                        writer.write("Modified: "
                                      + attr.lastModifiedTime());
                        writer.newLine();
                        writer.write("------------------");
                        writer.newLine();

                        return FileVisitResult.CONTINUE;
                    }
                });

            System.out.println("Report created: "
                               + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
