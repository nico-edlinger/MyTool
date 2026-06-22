package at.nicoedlinger.mytool.screenshots;

import at.nicoedlinger.mytool.logger.Logger;
import at.nicoedlinger.mytool.username.Username;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Screenshots {
    /**
     * The path to the screenshots folder of the user
     */
    private static Path PATH = null;
    /**
     * All paths of the screenshots
     */
    private static List<Path> imagePaths = new ArrayList<>();

    /**
     * Method to delete all Screenshots of the user
     */
    public static void deleteAll() {
        setPath();
        getImagePaths();

        for (Path imagePath : imagePaths) {
            try {
                Files.delete(imagePath);
            } catch (Exception e) {
                Logger.log(e.getMessage());
            }
        }

        imagePaths.clear();
    }

    /**
     * Helper method to set the path to the screenshots folder of the user
     */
    private static void setPath() {
        PATH = Paths.get("C:\\Users\\" + Username.getUsername() + "\\Pictures\\Screenshots");
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
