package online.cx.javabasic.leetcode.day.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cao Xin
 * @since 2021/5/21
 */
public class LeetCode21 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    map.put(nums1[i], nums2[j]);
                    break;
                }
            }
        }
        return 0;
    }
}
