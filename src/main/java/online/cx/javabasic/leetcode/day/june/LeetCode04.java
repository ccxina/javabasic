package online.cx.javabasic.leetcode.day.june;

import online.cx.javabasic.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Cao Xin
 * @since 2021/6/4
 */
public class LeetCode04 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while (tempA != null) {
            ListNode tempB = headB;
            while (tempB != null) {
                if (tempB.equals(tempA)) {
                    return tempB;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> integerList = new ArrayList<>();
        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }
        int l = integerList.size() - 1;
        for (int i = 0; i < integerList.size(); i++) {
            if (!integerList.get(i).equals(integerList.get(l - i))) {
                return false;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
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
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
}
