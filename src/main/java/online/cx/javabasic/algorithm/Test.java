package online.cx.javabasic.algorithm;

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
    }
}
