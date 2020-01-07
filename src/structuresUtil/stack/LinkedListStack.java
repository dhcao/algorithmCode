package structuresUtil.stack;

import structuresUtil.linkedList.LinkedList;

/**
 * 用链表来实现栈
 * @Author: dhcao
 * @Version: 1.0
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        final boolean empty = list.isEmpty();
        return empty;
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }
}
