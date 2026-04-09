package Questions;

import java.util.HashMap;

public class BreakCycle {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public static Node head;
    public static Node tail;
    public static int size;

    //    print LinkedList
    public void printLL(){
        //T.c = O(n)
//        base case if ll is empty
        if (head==null){
            System.out.println("ll is empty");
            return;
        }

        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int data) {
        //step-1 create new node
        Node newNode = new Node(data);
        size++;
        //if linked list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //step-2 newNode-->next = head
        newNode.next = head; //link

        //step-3 head = newNode
        head = newNode;
    }

    //    detect Cycle in LL (Floyd's CFA(cycle finding algo))
            public static boolean isCycle(){
       Node slow = head;
       Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;//+1 move
            fast = fast.next.next;//+2 move

            if (slow==fast){
                return true;//cycle exist
            }
        }
        return false; //cycle doesn't exist
    }

//    break loop or cycle
    public static void removeCycle(){
//        detect cycle
          Node slow = head;
          Node fast = head;
          boolean cycle = false;
          while (fast!=null && fast.next!=null){
              slow = slow.next;//+1
              fast = fast.next.next;//+2
              if (fast==slow){
                  cycle=true;
                  break;
              }
          }
          if (cycle==false){
              return;                 //return from the code cycle does not exist
          }

//        find meeting point
          slow = head;
          Node prev=null; //stores last node
          while (slow != fast){
               prev=fast;
               slow = slow.next;//+1
               fast = fast.next;//+1
          }
//        remove cycle--->last.next = null
          prev.next = null;
    }
    static void main(String[] args) {
       head = new Node(1);
       Node temp = new Node(2);
       head.next = temp;
       head.next.next = new Node(3);
       head.next.next.next = temp;

//       1-->2-->3-->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

    }
}
