package online.cx.javabasic.algorithm;

import java.util.Iterator;

/**
 * @author Cao Xin
 * @since 2021/3/19
 */
public class Stack<Item> implements Iterable<Item> {
    private int N;
    private Node first;


    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


}
