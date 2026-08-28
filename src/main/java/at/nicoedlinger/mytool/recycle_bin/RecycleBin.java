package at.nicoedlinger.mytool.recycle_bin;

import at.nicoedlinger.mytool.information.Information;
import at.nicoedlinger.mytool.logger.Logger;

public class RecycleBin {
    // static variable to save the message
    private static final String INFOMATION_TEXT = "Recycle bin cleared.";
    /**
     * Method to delete all files in the recycle bin
     */
    public static void clean(){
        ProcessBuilder processBuilder = new ProcessBuilder(
                "powershell.exe",
                "-Command",
                "Clear-RecycleBin -Force"
        );
        try {
            Process process = processBuilder.start();

            process.waitFor();
        } catch (Exception e) {
            Logger.log(e.getMessage());

        }

        Information.showInformationWindow(INFOMATION_TEXT);
    }
}
