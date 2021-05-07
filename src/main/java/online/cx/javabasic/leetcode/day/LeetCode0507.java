package online.cx.javabasic.leetcode.day;

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
}
