package online.cx.javabasic.leetcode.sortcolors;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/28 15:36
 * 75 题
 * 88
 * 215
 */
public class Solution {

    public void sortColors(int[] nums){
        // 计算各个数的个数
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0 || nums[i] > 2){
                return;
            }
            count[nums[i]]++;
         }
        // 根据各个数的数量填充 nums
        for(int i = 0; i < nums.length; i++){
            if(i < count[0]){
                nums[i] = 0;
            }else if(i >= count[0] && i < count[1]){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
        /*int index = 0;
        for(int i = 0; i < count[0]; i++){
            nums[index++] = 0;
        }
        for(int i = 0; i < count[1]; i++){
            nums[index++] = 1;
        }
        for(int i = 0; i < count[2]; i++){
            nums[index++] = 2;
        }*/
    }

    public void sortColors2(int[] nums){

        int zero = -1;
        int two = nums.length;

        for(int i = 0; i < two;){
            if(nums[i] == 1){
                i ++;
            }else if(nums[i] == 2){
                two --;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            }else if(nums[i] == 0){
                zero ++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i ++;
            }else{
                return;
            }

        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >=0) && (p2 >= 0)) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1 --;
            } else {
                nums1[p] = nums2[p2];
                p2 --;
            }
            p --;
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }



    public static void main(String[] args) {
        int[] arr = {1,0,2,1};
        Solution solution = new Solution();
        solution.sortColors2(arr);
        for(int i: arr){
            System.out.print(i + " ");
        }

        int[] nums1 = {1,2,3,0,0,0,0};
        int[] nums2 = {1,2,4,5};
        solution.merge(nums1,3,nums2,4);
        System.out.println();
        for(int i: nums1){
            System.out.print(i + " ");
        }
        System.out.println("result");
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
    }
}
