package online.cx.javabasic.loop;

import online.cx.javabasic.common.Node;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/21 16:48
 */
public class LinkedListDeleter {

    public Node deleteIfEquals(Node head, int value){

        while(head != null && head.getValue() == value){
            head = head.getNext();
        }

        if(head == null){
            return null;
        }

        Node prev = head;

        while(prev.getNext() != null){
            if(prev.getNext().getValue() == value){
                //delete it
                prev.setNext(prev.getNext().getNext());
            }else{
                prev = prev.getNext();
            }
        }

        return head;
    }

}
