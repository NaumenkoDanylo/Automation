package Utilits;

import java.time.Duration;

public class PropertyHelper {
    public PropertyHelper(){

    }


    public static String getBrowserProperty() {
        return System.getProperty("browser", "chrome");
    }

    public static String getBrowserSizeProperty() {
        return System.getProperty("size", "1920x1080");
    }

    public static long getTimeoutProperty() {
        String defaultTimeout = String.valueOf(Duration.ofMinutes(2L).toMillis());
        String systemTimeout = System.getProperty("timeout", defaultTimeout);
        return Long.parseLong(systemTimeout);
    }

    public static long getPageLoadTimeout() {
        String systemPageLoadTimeout = System.getProperty("pageLoadTimeout", String.valueOf(180000));
        return Long.parseLong(systemPageLoadTimeout);
    }
}

