package online.cx.javabasic.leetcode.day.may;


import online.cx.javabasic.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static ListNode createNode(int[] nums) {
        Arrays.sort(nums);
        ListNode pre = new ListNode(nums[0]);
        ListNode cur = pre;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return pre;
    }

    public static void foreach(ListNode root) {
        System.out.print("[");
        while (root != null) {
            System.out.print(root.val);
            System.out.print("\t");
            root = root.next;
        }
        System.out.print("]");
        System.out.println();
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

    /**
     * 合并链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }


    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
//        System.out.println(intToRoman(1994));
        ListNode node1 = createNode(new int[]{5, 4, 3, 2, 1});
        foreach(node1);
        ListNode node2 = createNode(new int[]{5, 4, 3, 2, 1});
        foreach(node2);
        ListNode node3 = mergeTwoLists(node1, node2);
        ListNode node4 = mergeTwoLists1(node1, node2);
        foreach(node3);
        foreach(node4);

    }
}
