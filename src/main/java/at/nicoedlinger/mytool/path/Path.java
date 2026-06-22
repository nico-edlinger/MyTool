package at.nicoedlinger.mytool.path;

import at.nicoedlinger.mytool.username.Username;

public class Path {
    private static String desktopPath = null;
    private static String downloadsPath = null;
    private static String screenshotsPath = null;
    private static final String USERNAME = Username.getUsername();

    public static String getDesktopPath() {
        if (desktopPath == null) setDesktopPath();
        return desktopPath;
    }

    private static void setDesktopPath() {
        desktopPath = "C:\\Users\\" + USERNAME + "\\Desktop";
    }

    public static String getDownloadsPath() {
        if (downloadsPath == null) setDownloadsPath();
        return downloadsPath;
    }

    private static void setDownloadsPath() {
        downloadsPath = "C:\\Users\\" + USERNAME + "\\Downloads";
    }

    public static String getScreenshotsPath() {
        if (screenshotsPath == null) setScreenshotsPath();
        return screenshotsPath;
    }

    private static void setScreenshotsPath() {
        screenshotsPath = "C:\\Users\\" + USERNAME + "\\Pictures\\Screenshots";
    }
}
