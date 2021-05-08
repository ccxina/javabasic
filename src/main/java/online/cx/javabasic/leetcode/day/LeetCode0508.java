package online.cx.javabasic.leetcode.day;

import java.util.*;

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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     * 有效的数独
     */
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int[][] line = new int[length][length];
        int[][] column = new int[length][length];
        int[][] cell = new int[length][length];
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                // 表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }

    /**
     * 旋转图像
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < i ; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] ints : matrix) {
            int l = 0, r = length - 1;
            change(l, r, ints);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
