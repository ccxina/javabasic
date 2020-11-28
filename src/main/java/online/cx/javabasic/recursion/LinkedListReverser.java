package online.cx.javabasic.recursion;

import online.cx.javabasic.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/20 15:22
 */
public class LinkedListReverser {

    /**
     * reverser a Linked List
     * @param head the linked list to reverser
     * @return head of the reversed linked list
     */
    public Node reverserLinkedList(Node head){
        // size == 0
        if(head == null){
            return null;
        }
        // size == 1
        if(head.getNext() == null){
            return head;
        }

        Node newHead = reverserLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListReverser reverser = new LinkedListReverser();
        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList
                (reverser.reverserLinkedList
                        (creator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList
                (reverser.reverserLinkedList
                        (creator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList
                (reverser.reverserLinkedList
                        (creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
