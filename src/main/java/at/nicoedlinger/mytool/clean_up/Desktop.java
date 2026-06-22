package at.nicoedlinger.mytool.clean_up;

import java.nio.file.Path;

import static at.nicoedlinger.mytool.path.Path.getDesktopPath;

public class Desktop extends CleanUp {
    public static void sort(){
        CleanUp.setPath(Path.of(getDesktopPath()));
        CleanUp.sort();
    }
}
