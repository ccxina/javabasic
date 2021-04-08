package online.cx.javabasic.algorithm;

import java.util.Iterator;

/**
 * @author Cao Xin
 * @since 2021/3/17
 */
public class Test {

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for(Integer i: stack) {
            if (i == 2) stack.pop();
            System.out.println(i);
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push("aaa");
        stringStack.push("aaaa");
        stringStack.push("aasss");
        Iterator<String> stringIterable = stringStack.iterator();
        while (stringIterable.hasNext()) {
            System.out.println(stringIterable.next());
        }
    }
}
