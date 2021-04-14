package online.cx.javabasic.sort;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @author Cao Xin
 * @since 2021/4/13
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    private static boolean less(Comparable v, Comparable b) {
        return v.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public static boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static String[] randomArray(int size, int count) {
        String[] a = new String[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomStringUtils.random(count,"abcdefghijklmnopqrstuvwxyz");
        }
        return a;
    }

    public static Integer[] randomIntegerArray(int size, int max) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtils.nextInt(0, max);
        }
        return a;
    }

    public static void main(String[] args) {
        String[] a = randomArray(100, 5);
        sort(a);
        assert isSort(a);
        show(a);
    }
}
