package link;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/19 10:18
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
//        testLinkedList();
        testLinkedListR();
    }
    public static void testLinkedListR(){
        LinkedListR<Integer> linkedList = new LinkedListR<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.add(0, i);
            System.out.println(linkedList);
        }

//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.addLast(688);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(2));
//
//        System.out.println(linkedList.getFirst());
//
//        System.out.println(linkedList.getLast());
//
//        System.out.println(linkedList.contains(2));
//
//        System.out.println(linkedList);
//        System.out.println(linkedList.remove(2));
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.removeElement(1));
//        System.out.println(linkedList);

        /*linkedList.set(2, 688);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(688));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeElement(3);
        System.out.println(linkedList);*/
    }
    public static void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        /*linkedList.set(2, 688);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(688));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeElement(3);
        System.out.println(linkedList);*/

//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }
}
