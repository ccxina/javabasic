package online.cx.javabasic.exam;

import java.util.Arrays;

/**
 * Created on 2021/10/30.
 *
 * @author 曹鑫
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int count = 0;
        Arrays.sort(coins);
        int l = coins.length;
        for (int i = l - 1; i>= 0 ; i--) {
            int temp = amount / coins[i];
            count += temp;
            amount = amount % coins[i];
            if (amount == 0)
                return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{186,419,83,408};
        System.out.println(new Solution().coinChange(coins, 6249));
    }
}
