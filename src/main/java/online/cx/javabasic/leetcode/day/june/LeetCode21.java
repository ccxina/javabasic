package online.cx.javabasic.leetcode.day.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Cao Xin
 * @since 2021/6/21
 */
public class LeetCode21 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (getBitCount(h) + getBitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    public int getBitCount(int number) {
        String s = Integer.toBinaryString(number);
        int res = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') res ++;
        }
        return res;
    }

    public static int subsetXORSum(int[] nums) {
        if (nums.length == 0) {return 0;}
        int length = nums.length;
        int mark;
        int nEnd = 1 << length;
        int res = 0;
        for (mark = 0; mark < nEnd; mark++) {
            int temp = 0;
            for (int i = 0; i < length; i++) {
                if (((1 << i) & mark) != 0) {//该位有元素输出
                    temp = temp ^ nums[i];
                }
            }
            res = res + temp;
        }
        return res;
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return res;
        }
        res[0] = nums[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i] + res[i - 1];
        }
        return res;
    }

    public boolean isPowerOfThree(int n) {
        if (n % 3 != 0) {return false;}
        while (n / 3 != 1) {
            n = n / 3;
            if (n % 3 != 0) {return false;}
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(runningSum(new int[]{1, 3})));
    }
}
