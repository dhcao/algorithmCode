package structuresUtil.linkedList;

/**
 * @Author: dhcao
 * @Version: 1.0
 */
public class TestMain {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,66);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(4));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
