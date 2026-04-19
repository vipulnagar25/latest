package designPattern.behavioral.cos;

enum LogLevel {
    INFO, DEBUG, ERROR
}

abstract class Logger {
    protected LogLevel level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

// Concrete Logger 1: InfoLogger
class InfoLogger extends Logger {
    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("[INFO] " + message);
    }
}

// Concrete Logger 2: DebugLogger
class DebugLogger extends Logger {
    public DebugLogger(LogLevel level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }
}

// Concrete Logger 3: ErrorLogger
class ErrorLogger extends Logger {
    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("[ERROR] " + message);
    }
}


public class Cos {
    static void main(String[] args) {
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);
        Logger debugLogger = new DebugLogger(LogLevel.DEBUG);
        Logger infoLogger = new InfoLogger(LogLevel.INFO);

        // Set the chain: INFO -> DEBUG -> ERROR
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        // Logging messages
        infoLogger.logMessage(LogLevel.INFO, "This is an info message.");
        infoLogger.logMessage(LogLevel.DEBUG, "This is a debug message.");
        infoLogger.logMessage(LogLevel.ERROR, "This is an error message.");
    }
}
