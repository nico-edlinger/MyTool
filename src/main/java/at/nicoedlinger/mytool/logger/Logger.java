package at.nicoedlinger.mytool.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    /**
     * The path to the file {@code logFile.txt}
     */
    private static final String PATH = "src\\main\\resources\\logFile.txt";

    /**
     * Writes a message in the file {@code logFile.txt} with current date and time
     * @param message which is written in the file
     */
    public static void log(String message){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
                writer.write(now.format(formatter));
                writer.newLine();
                writer.write("\t" + message);
                writer.newLine();
            }
        } catch(Exception e){
            Logger.log(e.getMessage());
        }
    }
}
