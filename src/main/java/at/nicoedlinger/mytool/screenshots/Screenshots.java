package at.nicoedlinger.mytool.screenshots;

import at.nicoedlinger.mytool.information.Information;
import at.nicoedlinger.mytool.logger.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static at.nicoedlinger.mytool.path.Path.getScreenshotsPath;

public class Screenshots {
    // static variable to save the message
    private static final String INFOMATION_TEXT = "Screenshots cleared.";

    /**
     * The path to the screenshots folder of the user
     */
    private static final Path PATH = Path.of(getScreenshotsPath());
    /**
     * All paths of the screenshots
     */
    private static List<Path> imagePaths = new ArrayList<>();

    /**
     * Method to delete all Screenshots of the user
     */
    public static void deleteAll() {
        getImagePaths();

        for (Path imagePath : imagePaths) {
            try {
                Files.delete(imagePath);
            } catch (Exception e) {
                Logger.log(e.getMessage());
            }
        }

        imagePaths.clear();

        Information.showInformationWindow(INFOMATION_TEXT);
    }

    /**
     * Helper method to save all paths of the screenshots in a list
     */
    private static void getImagePaths() {
        try {
            imagePaths = Files.list(PATH)
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }
    }
}
