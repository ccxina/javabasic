package online.cx.javabasic.common;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/20 14:53
 */
public class Node {

    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.getValue());
            System.out.print(" ");
            head = head.getNext();
        }
        System.out.println();
    }

    public boolean find(int value) {
        Node current = this;
        while (current != null){
            if (this.getValue() == value) return true;
            current = current.getNext();
        }
        return false;
    }

}
