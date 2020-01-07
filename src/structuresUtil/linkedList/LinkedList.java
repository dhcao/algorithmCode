package structuresUtil.linkedList;

/**
 * 自定义链表
 * @Author: dhcao
 * @Version: 1.0
 */
public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 自定义内部数据节点
     */
    private class Node<E>{

        public E e;
        public Node next;

        public Node(E e, Node<E> next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    public int getSize(){
        return size;
    }

    /**
     * 是否为空
     * @return true or false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在索引index上添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // 插入节点
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 链表头增加节点
     * @param e 节点数据
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 链表尾部添加节点；
     * @param e 需要添加的节点
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public E get(int index){

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return (E) cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 设置值
     * @param index
     * @param e
     */
    public void set(int index, E e){

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 是否包含
     * @param e
     * @return
     */
    public boolean contains(E e){

        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /**
     * 删除索引为index的元素
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node prve = dummyHead;
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }

        Node ret = prve.next;
        prve.next = ret.next;

        ret.next = null;
        size --;
        return (E) ret.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();

        Node cur = dummyHead.next;
        while(cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
