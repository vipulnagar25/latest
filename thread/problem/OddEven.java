package thread.problem;


class PrinterThread implements Runnable {
    // Renamed for clarity and made it final as it's a constant.
    private static final int MAX_NUMBER_TO_PRINT = 10;
    private static int number = 1;
    private final int remainder;
    // Lock object is now private and final, which is a concurrency best practice.
    private static final Object lock = new Object();

    PrinterThread(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        // Loop until the number to be printed exceeds the max number.
        while (number <= MAX_NUMBER_TO_PRINT) {
            synchronized (lock) {
                // Wait until it's this thread's turn to print.
                // This thread prints if the number has the correct remainder.
                // Also check if the number is within the printing range.
                while (number % 2 != remainder && number <= MAX_NUMBER_TO_PRINT) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // In a real application, use a logger instead of printStackTrace.
                        e.printStackTrace();
                        // It's a good practice to restore the interrupted status.
                        Thread.currentThread().interrupt();
                    }
                }

                // Re-check the condition after waking up from wait().
                // The number might have been incremented by another thread and could have exceeded the max limit.
                if (number <= MAX_NUMBER_TO_PRINT) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    number++;
                    // Notify the other waiting thread to wake up and check if it's its turn.
                    lock.notifyAll();
                }
            }
        }
    }
}


public class OddEven {
    public static void main(String[] args) {
        PrinterThread oddPrinter = new PrinterThread(1);
        PrinterThread evenPrinter = new PrinterThread(0);
        // Giving names to threads is good for debugging.
        Thread oddThread = new Thread(oddPrinter, "Odd");
        Thread evenThread = new Thread(evenPrinter, "Even");
        oddThread.start();
        evenThread.start();
    }
}
