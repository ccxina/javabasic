package online.cx.javabasic.leetcode.day.may;

import java.util.*;

/**
 * @author Cao Xin
 * @since 2021/5/6
 */
public class LeetCode06 {
    /**
     * 1720. 解码异或后的数组
     * a ^ b = c
     * a^b^b = a
     * 即 c^b=a 同理 c^a =b
     */
    public static int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 1; i < decode.length; i++) {
            decode[i] = decode[i - 1] ^ encoded[i -1];
        }
        return decode;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();

        for (int value : nums1) {
            res.add(value);
        }
        Set<Integer> res1 = new HashSet<>();
        for (int i : nums2) {
            if (res.contains(i)) {
                res1.add(i);
            }
        }
        int[] resInt = new int[res1.size()];
        int index = 0;
        for (Integer i : res1) {
            resInt[index ++] = i;
        }
        return resInt;
    }

    /**
     * 1561. 你可以获得的最大硬币数目
     */
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        System.out.println(Arrays.toString(piles));
        int res = 0;
        for(int i = piles.length - 2; i >= piles.length / 3 - 1; i = i - 2) {
            System.out.println(i);
            res += piles[i];
        }
        return res;
    }



    /**
     * 4. 寻找两个正序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] resArr = new int[length];
        int k = 0;
        for (int i: nums1) {
            resArr[k++] = i;
        }
        for (int i: nums2) {
            resArr[k++] = i;
        }
        Arrays.sort(resArr);
        int i = length / 2;
        if (length % 2 == 0) {
            return (resArr[i - 1] + resArr[i + 1]) / 2.0;
        } else {
            return resArr[i - 1];
        }
    }
}
