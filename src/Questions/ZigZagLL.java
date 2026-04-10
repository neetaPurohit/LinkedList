package Questions;

public class ZigZagLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
public static Node head;

    //            print the list
    void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //            add node
    void add(int data){
       Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void zigZag(){
//        find mid
     Node slow = head;
     Node fast = head.next;
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }
     Node mid = slow;
//        reverse 2nd half
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL , nextR;


//        alt merge - zig-zag merge

         while (left!=null && right!=null){
             nextL = left.next;
             left.next = right;
             nextR = right.next;
             right.next = nextL;

             left = nextL;
             right = nextR;
         }
     }
    static void main(String[] args) {

        ZigZagLL ll = new ZigZagLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.print();
        ll.zigZag();
        ll.print();

    }

}
