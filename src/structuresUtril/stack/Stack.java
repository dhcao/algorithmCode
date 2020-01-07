package structuresUtril.stack;

/**
 * @Author: dhcao
 * @Version: 1.0
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    E pop();
    E peek();
}
