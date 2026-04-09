package JFC;

import java.util.LinkedList;

public class LinkedListt {
    static void main(String[] args) {
//       we store objects in ll not data structure

//       create
        LinkedList<Integer> ll = new LinkedList<>();

//        add
        ll.addLast(3);
        ll.addFirst(2);
        ll.addFirst(1);
        System.out.println(ll);

//        remove
        ll.removeFirst();
        System.out.println(ll);
    }
}
