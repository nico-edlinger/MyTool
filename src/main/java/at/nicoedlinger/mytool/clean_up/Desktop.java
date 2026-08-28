package at.nicoedlinger.mytool.clean_up;

import at.nicoedlinger.mytool.information.Information;

import java.nio.file.Path;

import static at.nicoedlinger.mytool.path.Path.getDesktopPath;

public class Desktop extends CleanUp {
    // static variable to save the message
    private static final String INFOMATION_TEXT = "Desktop cleared.";

    public static void sort(){
        CleanUp.setPath(Path.of(getDesktopPath()));
        CleanUp.sort();

        Information.showInformationWindow(INFOMATION_TEXT);
    }
}
