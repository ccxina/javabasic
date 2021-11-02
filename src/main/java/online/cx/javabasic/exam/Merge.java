package online.cx.javabasic.exam;

/**
 * Created on 2021/11/1.
 *
 * @author 曹鑫
 */
public class Merge {
    public Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node result = new Node();
        Node index = result;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                index.value = head1.value;
                head1 = head1.next;
            } else {
                index.value = head2.value;
                head2 = head2.next;
            }
            index.next = new Node();
            if (head1 == null) {
                index = head2;
            } else if (head2 == null) {
                index = head1;
            } else {
                index = index.next;
            }
        }
        return result;
    }
    static class Node {
        int value;
        Node next;
    }
}
