package online.cx.javabasic.leetcode.exam;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Cao Xin
 * @since 2021/4/23
 */
public class Barcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {

        int[] counts = new int[10001], res = new int[barcodes.length];
        for (int barcode : barcodes) counts[barcode]++;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> counts[o2] - counts[o1]);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) queue.offer(i);
        }
        int id = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            res[id++] = a;
            res[id++] = b;
            if (counts[a] > 1) {
                counts[a]--;
                queue.offer(a);
            }
            if (counts[b] > 1) {
                counts[b]--;
                queue.offer(b);
            }
        }
        if (!queue.isEmpty()) res[id] = queue.poll();
        return res;
    }


    public static void main(String[] args) {
        Barcodes b = new Barcodes();
//        int[] ints = new int[]{1,1,1,2,2,2};
        int[] ints = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(b.rearrangeBarcodes(ints)));
    }
}
