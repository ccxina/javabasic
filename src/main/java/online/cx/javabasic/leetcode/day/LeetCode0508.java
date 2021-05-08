package online.cx.javabasic.leetcode.day;

import java.util.Arrays;
import java.util.List;

/**
 * @author Cao Xin
 * @since 2021/5/8
 */
public class LeetCode0508 {

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }


    public static void rotate2(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        change(l, r, nums);
        l = 0;
        r = k % nums.length - 1;
        change(l, r, nums);
        l = k % nums.length;
        r = nums.length - 1;
        change(l, r, nums);
    }

    public static void change(int l, int r, int[] nums) {
        while (l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }


    /**
     * 存在重复元素
     * int[] res = Arrays.stream(nums).distinct().toArray();
     * return res.length != nums.length;
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


    /**
     * 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
        rotate2(nums, 1);
        System.out.println(Arrays.toString(nums));
    }
}
