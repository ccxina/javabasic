package online.cx.javabasic.leetcode.exam;

import java.util.*;

/**
 * @author Cao Xin
 * @since 2021/5/6
 */
public class LeetCode0506 {
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

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}
