package structuresUtril.array;

/**
 * 自定义动态数组，类似ArrayList的实现
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * get size;
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * get element of the index from array;
     * @param index
     * @return
     */
    public E get(int index){
        return data[index];
    }

    /**
     * set value on the last index;
     * @param e
     */
    public void set(E e){
        if (size == data.length) {
            resize(2 << size);
        }
        data[size] = e;
        size ++;
    }

    /**
     * if the data array is full ,we make the space to new size;
     * @param newSize new size
     */
    private void resize(int newSize) {
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
