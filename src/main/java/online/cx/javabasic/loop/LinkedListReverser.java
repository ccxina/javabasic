package online.cx.javabasic.loop;

import online.cx.javabasic.common.Node;
import online.cx.javabasic.recursion.LinkedListCreator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/21 15:57
 */
public class LinkedListReverser {

    public Node reverserLinkedList(Node head){
        Node newHead = null;
        Node curHead = head;

        while(curHead != null){
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListReverser reverser = new LinkedListReverser();
        LinkedListCreator creator = new LinkedListCreator();
        Node.printLinkedList
                (reverser.reverserLinkedList
                        (creator.createLargeLinkedList(100000)));
//        Node.printLinkedList
//                (reverser.reverserLinkedList
//                        (creator.createLinkedList(Arrays.asList(1))));
//        Node.printLinkedList
//                (reverser.reverserLinkedList
//                        (creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
