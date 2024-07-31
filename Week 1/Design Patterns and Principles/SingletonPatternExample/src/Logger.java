public class Logger {

    // Private static instance of the Logger class, volatile to ensure visibility of changes across threads
    private static volatile Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {

    }

    // Public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println(message);
    }
}

// The Logger class follows the Singleton design pattern with thread safety:
// A private static volatile instance of itself (instance).
// A private constructor to prevent instantiation from other classes.
// A public static method (getInstance) to provide the single instance of the class, using double-checked locking to ensure thread safety.
