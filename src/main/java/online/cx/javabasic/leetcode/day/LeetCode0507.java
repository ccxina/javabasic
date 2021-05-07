package online.cx.javabasic.leetcode.day;

import java.util.Arrays;

/**
 * @author Cao Xin
 * @since 2021/5/7
 */
public class LeetCode0507 {


    /**
     * 1486. 数组异或操作
     */
    public static int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            int temp = start + 2 * i;
            res ^= temp;
        }
        return res;
    }

    /**
     * 删除排序数组中的重复项
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return ++left;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,4,5,5,6,6};
        int len = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len; i++) {
            System.out.printf("%d\t", nums[i]);
        }
    }
}
