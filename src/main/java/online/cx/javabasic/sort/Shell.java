package online.cx.javabasic.sort;

/**
 * @author Cao Xin
 * @since 2021/4/13
 * 插入排序
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h ; j -= h) {
                    if (less(a[j], a[j-h]))exchange(a, j, j-h);
                }
            }
            h = h / 3 ;
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
        Integer[] a = Example.randomIntegerArray(10, 500);
        sort(a);
        assert isSort(a);
        show(a);
    }
}
