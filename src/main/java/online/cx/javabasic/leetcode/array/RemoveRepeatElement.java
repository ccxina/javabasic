package online.cx.javabasic.leetcode.array;

/**
 * Created on 2020/11/1.
 *
 * @author 曹鑫
 */
public class RemoveRepeatElement {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++ ){
            if (nums[i] != nums[k]) {
                k ++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }



    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 3, 12, 19};
        RemoveRepeatElement r = new RemoveRepeatElement();
        r.removeDuplicates(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }


    }
}
