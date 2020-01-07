package structuresUtil.queue;

/**
 * @Author: dhcao
 * @Version: 1.0
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
