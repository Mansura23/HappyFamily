package logs;

import enums.LogTypes;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    public static void writeLog(LogTypes type, String message) {
        try(FileWriter fileWriter = new FileWriter("application.log", true)) {
            StringBuilder sb = new StringBuilder();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            sb.append(time);
            switch (type) {
                case ERROR -> sb.append("[ERROR] ");
                case WARNING -> sb.append("[WARNING] ");
                case INFO -> sb.append("[INFO] ");
                default -> throw new IllegalArgumentException("Unknown Log Type: " + type);
            }
           sb.append(message);
           fileWriter.write(sb + "\n");
        } catch (Exception e) {
            System.out.println("Error writing log file");
        }
    }
}
