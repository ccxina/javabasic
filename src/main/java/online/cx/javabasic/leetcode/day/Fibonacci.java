package online.cx.javabasic.leetcode.day;

public class Fibonacci {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fib(4);
        System.out.println(res);
    }
}
