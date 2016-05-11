package io.moj.java.sdk.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * A lightweight log class that enables runtime configuration of behaviour so clients can enable or disable SDK logging
 * conditionally.
 *
 * Created by skidson on 16-02-10.
 */
public class Log {

    private static final List<Logger> LOGGERS = new ArrayList<>();

    /**
     * Logs at the indicated level.
     *
     * @param level
     * @param tag
     * @param msg
     * @param tr
     */
    public static void log(Level level, String tag, String msg, Throwable tr) {
        for (Logger logger : LOGGERS) {
            logger.log(level, tag, msg, tr);
        }
    }

    /**
     * Logs at the indicated level.
     *
     * @param level
     * @param tag
     * @param message
     */
    public static void log(Level level, String tag, String message) {
        log(level, tag, message, null);
    }

    public static void v(String tag, String message) {
        log(Level.FINER, tag, message);
    }

    public static void v(String tag, String message, Throwable e) {
        log(Level.FINER, tag, message, e);
    }

    public static void d(String tag, String message) {
        log(Level.FINE, tag, message);
    }

    public static void d(String tag, String message, Throwable e) {
        log(Level.FINE, tag, message, e);
    }

    public static void i(String tag, String message) {
        log(Level.INFO, tag, message);
    }

    public static void i(String tag, String message, Throwable e) {
        log(Level.INFO, tag, message, e);
    }

    public static void w(String tag, String message) {
        log(Level.WARNING, tag, message);
    }

    public static void w(String tag, String message, Throwable e) {
        log(Level.WARNING, tag, message, e);
    }

    public static void e(String tag, String message) {
        log(Level.SEVERE, tag, message);
    }

    public static void e(String tag, String message, Throwable e) {
        log(Level.SEVERE, tag, message, e);
    }

    public static synchronized void append(Logger logger) {
        LOGGERS.add(logger);
    }

    public static synchronized void remove(Logger logger) {
        LOGGERS.remove(logger);
    }

    public static void clearLoggers() {
        LOGGERS.clear();
    }

    public interface Logger {
        void log(Level level, String tag, String msg, Throwable tr);
    }

}