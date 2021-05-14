package online.cx.javabasic.leetcode.day.may;


import online.cx.javabasic.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cao Xin
 * @since 2021/5/14
 */
public class LeetCode14 {

    /**
     * 数字转罗马数字
     * 贪心 每次都取最大的数 1994 -> 1000 900 90 4 M CM XC IV
     */
    public static String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                res.append(romans[i]);
                num -= nums[i];
            }
            if (num == 0) break;
        }
        return res.toString();
    }



    /**
     * 链表反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode root = head;
        while (root != null) {
            list.add(root.val);
            root = root.next;
        }
        if (list.isEmpty()) {return null;}
        if (list.size() == 1) {return head;}
        ListNode pre = new ListNode(list.get(list.size() - 1));
        ListNode cur = pre;
        for (int i = list.size() - 2; i >= 0; i --) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
//        System.out.println(intToRoman(1994));
        ListNode head = new ListNode(1);
        ListNode res = reverseList(head);
    }
}
