package online.cx.javabasic.leetcode.removeelement;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/28 11:09
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (k != i) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k ++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 19};
        Solution s = new Solution();
        int length = s.removeElement(arr, 0);
        System.out.println(length);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
