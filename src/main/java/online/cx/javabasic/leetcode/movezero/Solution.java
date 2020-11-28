package online.cx.javabasic.leetcode.movezero;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/28 10:28
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 *
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */
public class Solution {
    /**
     * 时间复杂度  O(n)
     * 空间复杂度  O(n)
     * @param nums 需要处理的数组
     */
    public void moveZeroes(int[] nums) {
        // 存储所有的非0元素
        List<Integer> noZeroNums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                noZeroNums.add(nums[i]);
            }
        }
        // 把非0 元素 赋值到原数组中
        for(int i = 0; i < noZeroNums.size(); i++){
            nums[i] = noZeroNums.get(i);
        }
        // 剩余的位置赋值为 0
        for(int i = noZeroNums.size(); i < nums.length; i++){
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度  O(n)
     * 空间复杂度  O(1)
     * @param nums 需要处理的数组
     */
    public void moveZeroes2(int[] nums){
        int key = 0; // 在nums 中， [0...k]的元素为非0 元素
        // 遍历 到第i个元素后， 保证[0...i]中所有的非0元素
        // 都存放在  [0...k] 中
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[key] = nums[i];
                key ++;
            }
        }
        // nums后续设置为0
        for(int i = key; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度  O(n)
     * 空间复杂度  O(1)
     * @param nums 需要处理的数组
     */
    public void moveZeroes3(int[] nums){
        int key = 0; // 在nums 中， [0...k]的元素为非0 元素
        // 遍历 到第i个元素后， 保证[0...i]中所有的非0元素
        // 都存放在  [0...k] 中
        // 同时[k...i] 为0
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                // key 和 i 交换
                if(key != i){
                    int temp = nums[key];
                    nums[key] = nums[i];
                    nums[i] = temp;
                }
                key ++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 19};
        Solution solution = new Solution();
        solution.moveZeroes3(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
