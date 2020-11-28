package online.cx.javabasic.leetcode.minsubarraylen;

import static java.lang.Math.min;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/28 20:42
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1;
        //nums[l...r] 为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length){
            if(r + 1 < nums.length && sum < s){
                r ++;
                sum += nums[r];
            }else{
                sum -= nums[l];
                l++;
            }

            if(sum >= s){
                res = min(res, r - l + 1);
            }

        }

        if(res == nums.length + 1){
            return 0;
        }
        return res;
    }


    public static void main(String[] args) {
        int res = MinSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }
}
