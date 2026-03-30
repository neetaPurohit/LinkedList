package BasicsOfLL;

public class LinkedList {

    //    Nodes of linkedList class
    public static class Node {
        int data;
        Node next;

        //      constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
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

    public void addLast(int data) {
        //step-1 create new node
        Node newNode = new Node(data);
        size++;
        //for empty ll
        if (head == null) {
            //both(head and tail assigned to newNode's value)
            head = tail = newNode;
            return;
        }

        //step-2 tail.next = newNode
        tail.next = newNode;

        //step-3  tail = newNode
        tail = newNode;

    }

    public void addInMiddle(int idx, int data){
//        if i want to add at head
        if (idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1){ //i < idx-1 means temp is now on previous node
            temp = temp.next;
            i++;
        }
//        i = idx -1 means tem-->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

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

//    removing elements
    public int removeFirst(){
        if (size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
//            only node
            int val = head.data;
            head = tail = null;//make head and tail both as null
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            //only list (single list)
            int val = head.data; //head and tail both are this single list
            head = tail = null;
            size = 0;
            return val;
        }
//        reach to previous node
//        previous node = size-2
        Node prev = head;
        for (int i=0; i<size-2; i++){
          prev = prev.next;
        }
        int val = prev.next.data;//tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

  public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//      ll.head = new Node(1);
//      ll.head.next = new Node(2);

        ll.printLL();
        ll.addFirst(2);
        ll.printLL();
        ll.addFirst(1);
        ll.printLL();
      System.out.println(size);
        ll.addLast(3);
        ll.printLL();
        ll.addLast(4);
        ll.printLL();
        ll.addInMiddle(2,9);
        ll.printLL();
      System.out.println(size);
      ll.removeFirst();
      ll.printLL();
      ll.removeLast();
      ll.printLL();
      System.out.println(size);
    }
}

