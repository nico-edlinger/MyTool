package at.nicoedlinger.mytool.clean_up;

import at.nicoedlinger.mytool.logger.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class CleanUp {
    /**
     * The path to the wanted directory
     */
    private static Path PATH;

    /**
     * Helper method to save all paths of the files in a map and group it by its extensions
     */
    private static Map<String, List<Path>> getFilePathsAndGroupByExtension() {
        List<Path> filePaths = new ArrayList<>();
        Map<String, List<Path>> groupedByExtension;

        try {
            filePaths = Files.list(PATH)
                    .filter(Files::isRegularFile)
                    .filter(path -> !getFileExtension(path).equalsIgnoreCase("ini")) // exclude ini
                    .toList();
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }

        groupedByExtension = filePaths.stream().collect(Collectors.groupingBy(CleanUp::getFileExtension));

        return groupedByExtension;
    }

    /**
     * Helper method to get the extension of a file
     *
     * @param path of the file
     * @return the extension
     */
    private static String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');

        if (lastDotIndex <= 0) return "other"; // no extension

        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

    /**
     * Helper method to create a folder
     *
     * @param name of the folder
     */
    private static void createFolder(String name) {
        Path directoryPath = PATH.resolve(name);

        try {
            Files.createDirectories(directoryPath);
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }
    }

    /**
     * Helper method to move a file to its correct folder
     *
     * @param filePath the current path of the file
     */
    private static void moveFile(Path filePath) {
        try {
            Files.move(filePath, filePath.getParent().resolve(getFileExtension(filePath)).resolve(filePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }
    }

    /**
     * Method to sort files of the set directory by their extensions
     */
    protected static void sort() {
        if (PATH == null) throw new IllegalStateException("Path is null");

        Map<String, List<Path>> groupedByExtension = getFilePathsAndGroupByExtension();
        List<String> extensions = new ArrayList<>(groupedByExtension.keySet());

        for (String extension : extensions) {
            for (Path filePath : groupedByExtension.get(extension)) {
                createFolder(extension);
                moveFile(filePath);
            }
        }
    }

    /**
     * Method to set the path to the wanted directory
     *
     * @param path of the wanted directory
     */
    protected static void setPath(Path path) {
        PATH = path;
    }
}
