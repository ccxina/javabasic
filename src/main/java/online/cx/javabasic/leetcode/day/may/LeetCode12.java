package online.cx.javabasic.leetcode.day.may;

import online.cx.javabasic.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author Cao Xin
 * @since 2021/5/12
 */
public class LeetCode12 {

    /**
     * 1310. 子数组异或查询
     * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == r) {
                res[i] = arr[l];
                continue;
            }
            int temp = 0;
            while (l <= r) {
                temp ^= arr[l];
                l++;
            }
            res[i] = temp;
        }
        return res;
    }

    public static int[] xorQueries1(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[\\pP\\p{Punct}]", "").replaceAll(" ", "").toLowerCase();
        char[] chars = newStr.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    /**
     * 字符串转换整数 (atoi)
     */
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int res = 0;
        int sign = 1;
        //判断符号
        if (s.charAt(index) == '-' || s.charAt(index) == '+')
            sign = s.charAt(index++) == '+' ? 1 : -1;
        for (; index < s.length(); ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = s.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9)
                break;
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return sign * res;
    }

    public static int strStr(String haystack, String needle) {
        needle = needle.trim();
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            String temp = haystack.substring(i, needle.length() + i);
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 外观数列
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = "1";
        for (int i = 1; i < n; i++) {
            String temp = last;
            StringBuilder item = new StringBuilder();
            int count = 1;
            int first = temp.charAt(0) - '0';
            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) == temp.charAt(j - 1)) {
                    count++;
                } else {
                    item.append(count).append(first);
                    count = 1;
                    first = temp.charAt(j) - '0';
                }
            }
            last = item.append(count).append(first).toString();
        }
        return last;
    }

    /**
     * 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (String str : strs) {
            while (str.indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    /**
     * 删除列表倒数第n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        if (last == 0) {
            return head.next;
        }
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public int length(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{4,8,2,10};
//        int[][] queries = new int[][]{{2,3},{1,3},{0,0},{0,3}};
//        int[] res = xorQueries(arr, queries);
//        System.out.println(Arrays.toString(res));
//        System.out.println(myAtoi("42"));
        System.out.println(countAndSay(4));
    }
}
