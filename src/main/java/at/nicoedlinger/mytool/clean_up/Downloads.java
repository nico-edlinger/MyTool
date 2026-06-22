package at.nicoedlinger.mytool.clean_up;

import java.nio.file.Path;

import static at.nicoedlinger.mytool.path.Path.getDownloadsPath;

public class Downloads extends CleanUp {
    public static void sort(){
        CleanUp.setPath(Path.of(getDownloadsPath()));
        CleanUp.sort();
    }
}
