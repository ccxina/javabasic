package online.cx.javabasic.leetcode.day;

public class Fibonacci {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        return fib(n - 1 ) + fib(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fib(4);
        System.out.println(res);
    }
}
