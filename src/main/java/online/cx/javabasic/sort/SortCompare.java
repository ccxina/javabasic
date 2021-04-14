package online.cx.javabasic.sort;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Cao Xin
 * @since 2021/4/14
 */
public class SortCompare {

    public static double time(String method, Comparable[] a) {
        long begin = System.currentTimeMillis();
        switch (method) {
            case "Insertion": Insertion.sort(a);break;
            case "Selection": Selection.sort(a);break;
            default:break;
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static double timeRandomInput(String method, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int n = 0; n < N; n++){
                a[n] = RandomUtils.nextDouble(0.0, 500.0);
            }
            total += time(method, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 1000;
        int T = 100;
        System.out.printf("method: %s, cost time: %.1f \n", "Insertion", timeRandomInput("Insertion", N, T));
        System.out.printf("method: %s, cost time: %.1f \n", "Selection", timeRandomInput("Selection", N, T));
    }
}
