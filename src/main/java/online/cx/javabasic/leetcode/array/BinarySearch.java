package online.cx.javabasic.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/11/1.
 * 二分查找
 * @author 曹鑫
 */
public class BinarySearch {

    static int binarySearch(List<Integer> array, int n, Integer target) {
        int l = 0, r = n -1; // 在 [l...r ] 的范围内寻找 target
        while (l <= r) { // 当 l==r时 [l...r ] 区间有效
            int mid = (l+r) / 2;
            if (array.get(mid).equals(target)) {
                return mid;
            }
            if (target > array.get(mid)) {
                l = mid + 1; // target 在[mid+1 ... r]中
            } else {
                r = mid - 1; // target 在[l ... mid-1]中
            }
        }
        return -1;
    }


    static List generaOrderList(int n) {
        if (n < 0) {
            return null;
        }
        int[] arr = new int[n];
        List list = new ArrayList();
        for(int i = 0; i < arr.length; i++ ){
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        List list = BinarySearch.generaOrderList(1000000);
        int tagert = 100;
        System.out.println(BinarySearch.binarySearch(list, 1000000, 0));
    }
}
