package at.nicoedlinger.mytool.path;

import at.nicoedlinger.mytool.username.Username;

public class Path {
    // variables for the specific paths
    private static String desktopPath = null;
    private static String downloadsPath = null;
    private static String screenshotsPath = null;

    // variable for the username
    private static final String USERNAME = Username.getUsername();

    /**
     * Method to get the Desktop path
     * @return the Desktop path
     */
    public static String getDesktopPath() {
        if (desktopPath == null) setDesktopPath();
        return desktopPath;
    }

    /**
     * Method to create the Desktop path based on the username
     */
    private static void setDesktopPath() {
        desktopPath = "C:\\Users\\" + USERNAME + "\\Desktop";
    }

    /**
     * Method to get the Downloads path
     * @return the Downloads path
     */
    public static String getDownloadsPath() {
        if (downloadsPath == null) setDownloadsPath();
        return downloadsPath;
    }

    /**
     * Method to create the Downloads path based on the username
     */
    private static void setDownloadsPath() {
        downloadsPath = "C:\\Users\\" + USERNAME + "\\Downloads";
    }

    /**
     * Method to get the Screenshots path
     * @return the Screenshots path
     */
    public static String getScreenshotsPath() {
        if (screenshotsPath == null) setScreenshotsPath();
        return screenshotsPath;
    }

    /**
     * Method to create the Screenshots path based on the username
     */
    private static void setScreenshotsPath() {
        screenshotsPath = "C:\\Users\\" + USERNAME + "\\Pictures\\Screenshots";
    }
}
