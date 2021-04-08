package online.cx.javabasic.recursion;

import online.cx.javabasic.common.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/20 14:53
 */
public class LinkedListCreator {

    /**
     * Create a linked list
     *
     * @param data the data to create the list
     * @return head of the linked list.
     * The returned linked list end with last node with getNext() == null.
     */
    public Node createLinkedList(List<Integer> data){
        if(data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        firstNode.setNext(createLinkedList(data.subList(1, data.size())));
        return firstNode;

    }

    public Node createLargeLinkedList(int size){
        Node prev = null;
        Node head = null;
        for (int i = 1; i <= size; i++){
            Node node = new Node(i);
            if(prev != null){
                prev.setNext(node);
            }else {
                head = node;
            }
            prev = node;
        }
        return head;
    }


    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();

//        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
//        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node linkedList = creator.createLinkedList(Arrays.asList(1,2,3,4));
        System.out.println(linkedList.find(5));

        Node.printLinkedList(linkedList);
    }
}
