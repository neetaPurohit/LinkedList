package Questions;

public class CycleInLL {

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
    static void main(String[] args) {

      head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = head; //cycle form

        System.out.println(isCycle());


    }
}
