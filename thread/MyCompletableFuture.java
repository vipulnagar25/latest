package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyCompletableFuture {

    public static String supplyAsync() throws ExecutionException, InterruptedException {
        // some async computation
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> {
            // some async computation
            return "Hello from CompletableFuture";
        });
        return greetingFuture.get();
    }

    public static String composingCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> helloFuture
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture
                = helloFuture.thenCombine(
                greetingFuture, (m1, m2) -> m1 + " " + m2);

        return combinedFuture.get();
    }

    public static void handlingMultipleCompletableFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        // Running multiple tasks in parallel
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2);
        // Waits for both futures to complete
        allOf.join();

        System.out.println("Future1 Result: " + f1.get());
        System.out.println("Future2 Result: " + f2.get());
    }

    public static void handlingExceptionInCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> resultFuture
                // java.lang.ArithmeticException: / by zero
                = CompletableFuture.supplyAsync(() -> 10 / 0)
                .exceptionally(ex -> 0);

        // 0 - returned by exceptionally block
        System.out.println(resultFuture.get());
    }

    public static void runAsyncInCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> resultFuture
                // java.lang.ArithmeticException: / by zero
                = CompletableFuture.runAsync(() -> System.out.println("Running some task"));
        // 0 - returned by exceptionally block
        System.out.println(resultFuture.get());
    }

    public static void main(String[] args) throws Exception {

//        System.out.println(supplyAsync());
//        System.out.println(composingCompletableFuture());
//        handlingMultipleCompletableFutures();
//        handlingExceptionInCompletableFuture();
        runAsyncInCompletableFuture();
    }
}
