package thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from MyRunnable");
    }

    public static void main() {
        var runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        runnable.run();

    }
}
