package problemSolution;

public class Fibonacci {
   public static int fib(int n) {
       int n1 = 0, n2 = 1;

       for (int i = 0; i < n; i++) {
           System.out.print(n1 + " ");
           int n3 = n2 + n1;
           n1 = n2;
           n2 = n3;
       }
       return n2;
   }
    static void main() {
        int n = 10;
        System.out.println("Fibonacci series up to " + n + " terms:");
        System.out.println();
        System.out.println(fib(n)+"dddd");
    }
}
