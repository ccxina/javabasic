package online.cx.javabasic.sort;

/**
 * @author Cao Xin
 * @since 2021/4/13
 * 选择排序
 */
public class Selection{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
        }
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

    public static void main(String[] args) {
        Integer[] a = Example.randomIntegerArray(100, 500);
        sort(a);
        assert isSort(a);
        show(a);
    }
}
