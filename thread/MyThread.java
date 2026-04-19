package thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        var thread1 = new MyThread();
        thread1.start();
        thread1.join();
        var thread2 = new MyThread();
        thread2.start();
        thread2.join();
    }
}
