package Questions;
//search for a key in linked List , return the position where it found. if not fount return -1. use recursion.
public class RecursiveSearch {
    public static class Node{
        int data;
       Node next;

        public Node(int data){
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
    public int helper(Node head, int key ){
//        T.c = O(n)
//        S.c = O(n)
//     base case
         if (head==null){
             return -1;
         }
         if (head.data == key){
             return 0; //cause head's index is 0
         }
         int idx = helper(head.next,key);

//         if key not found
         if (idx == -1){
             return -1;
         }
         return idx+1;//cause it goes to in multiple level, after each one step head changes it's position that's why (+1)
    }
    public int recursiveSearch(int key){
       return helper(head,key);

    }

    static void main(String[] args) {
        RecursiveSearch ll = new RecursiveSearch();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLL();

        System.out.println( ll.recursiveSearch(5));
        System.out.println(ll.recursiveSearch(20));

    }
}
