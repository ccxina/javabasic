package online.cx.javabasic.leetcode.day.may;

import java.util.*;

/**
 * @author Cao Xin
 * @since 2021/5/11
 */
public class LeetCode11 {
    /**
     *    1734. 解码异或后的排列
     */
    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 1;
        for (int i = 2; i <= n; i++) {
            total ^= i;
        }
        for (int i = 1; i < n - 1; i += 2) {
            total ^= encoded[i];
        }
        int[] res = new int[n];
        res[0] = total;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }

    /**
     * 整数反转
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x = x/10;
        }
        return res;
    }

    /**
     * 字符串种第一个唯一的字符
     */
    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        int[] index = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i] - 'a']++;
            index[chars[i] - 'a'] = i;
        }
        for (char aChar : chars) {
            if (hash[aChar - 'a'] == 1) {
                return index[aChar - 'a'];
            }
        }
        return -1;
     }

    /**
     * 有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : sc) {
            int temp = sMap.getOrDefault(c, 0) + 1;
            sMap.put(c, temp);
        }
        for (char c : tc) {
            if (sMap.containsKey(c)) {
                int temp = sMap.get(c) - 1;
                if (temp == 0) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, temp);
                }
            } else {
                return false;
            }
        }
        return !sMap.isEmpty();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
    public static void main(String[] args) {
        int[] encode = new int[]{3,1};
        int[] res = decode(encode);
        System.out.println(Arrays.toString(res));
    }
}
