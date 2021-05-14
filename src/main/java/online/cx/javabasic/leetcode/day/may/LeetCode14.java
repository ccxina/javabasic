package online.cx.javabasic.leetcode.day.may;


/**
 * @author Cao Xin
 * @since 2021/5/14
 */
public class LeetCode14 {

    /**
     * 数字转罗马数字
     * 贪心 每次都取最大的数 1994 -> 1000 900 90 4 M CM XC IV
     */
    public static String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                res.append(romans[i]);
                num -= nums[i];
            }
            if (num == 0) break;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
