package structuresUtril.stack;


import structuresUtril.array.Array;

/**
 * @Author: dhcao
 * @Version: 1.0
 */
public class ArrayStack<E> implements Stack {

    private Array<E> array;

    public ArrayStack(){
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
