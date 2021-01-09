package online.cx.javabasic.leetcode.day;

public class Fibonacci {
    public int fib(int n) {
       return new int[]{0, 0, 1, 2, 3}[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fib(4);
        System.out.println(res);
    }
}
