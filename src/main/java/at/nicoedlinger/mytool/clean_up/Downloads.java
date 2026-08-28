package at.nicoedlinger.mytool.clean_up;

import at.nicoedlinger.mytool.information.Information;

import java.nio.file.Path;

import static at.nicoedlinger.mytool.path.Path.getDownloadsPath;

public class Downloads extends CleanUp {
    // static variable to save the message
    private static final String INFOMATION_TEXT = "Downloads sorted.";

    public static void sort(){
        CleanUp.setPath(Path.of(getDownloadsPath()));
        CleanUp.sort();

        Information.showInformationWindow(INFOMATION_TEXT);
    }
}
