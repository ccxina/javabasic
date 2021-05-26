package online.cx.javabasic.leetcode.day.may;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Cao Xin
 * @since 2021/5/26
 */
public class LeetCode26 {

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode26().reverseParentheses("(ccu(love)i)"));
    }
}
