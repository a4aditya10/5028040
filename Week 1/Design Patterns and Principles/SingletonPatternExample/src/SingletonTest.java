public class SingletonTest {
    public static void main(String[] args) {

        // Create multiple threads that try to get the Logger instance and log a message
        Thread thread1 = new Thread(() -> {
            Logger logger1 = Logger.getInstance();
            logger1.log("Message from thread1");
            System.out.println("Logger instance from thread1: " + logger1);
        });

        Thread thread2 = new Thread(() -> {
            Logger logger2 = Logger.getInstance();
            logger2.log("Message from thread2");
            System.out.println("Logger instance from thread2: " + logger2);
        });

        Thread thread3 = new Thread(() -> {
            Logger logger3 = Logger.getInstance();
            logger3.log("Message from thread3");
            System.out.println("Logger instance from thread3: " + logger3);
        });

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Waiting for the threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifying that the same Logger instance is used in all threads
        Logger loggerMain = Logger.getInstance();
        loggerMain.log("Message from main thread");
        System.out.println("Logger instance from main thread: " + loggerMain);
    }
}


//The <hashcode1> represents the memory address of the singleton Logger instance.
//It will be the same for all threads, indicating they are using the same instance.