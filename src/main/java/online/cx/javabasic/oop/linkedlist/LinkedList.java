package online.cx.javabasic.oop.linkedlist;

import online.cx.javabasic.common.Node;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/24 8:31
 */
public class LinkedList implements Iterable<Integer> {

    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }


    public void add(int value){
        Node node = new Node(value);
        if(tail == null){
            head = node;
        }else{
            tail.setNext(node);
        }
        tail = node;
    }

    class ListIterator implements Iterator<Integer>{

        Node currentNode;

        public ListIterator(Node currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if(currentNode == null) {
                try {
                    throw new NoSuchFieldException();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            int value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return  value;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(head);
    }


}
