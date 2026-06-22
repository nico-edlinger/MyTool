package at.nicoedlinger.mytool.recycle_bin;

import at.nicoedlinger.mytool.logger.Logger;

public class RecycleBin {
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
    }
}
