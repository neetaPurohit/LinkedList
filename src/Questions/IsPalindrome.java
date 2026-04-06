package Questions;

public class IsPalindrome {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;

    //add node
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

    // print the list
    void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    slow - fast approach
//   return type is head
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next; //Move with +1
            fast = fast.next.next; // Move with +2
        }
        //slow will be my middle
        return slow;
    }

//    find palindrome
    public boolean checkPalindrome(){
//        corner cases:
        if (head == null || head.next == null){
              return true;
        }
//        step:1 find mid
         Node midNode = findMid(head);


//        step:2 reverse 2nd half
         Node prev = null;
         Node curr = midNode;
         Node next;

         while (curr != null){
             next = curr.next;
             curr.next  = prev;
             prev = curr;
             curr = next;
         }

         Node right = prev; //right half head
         Node left = head;

//        step:3 check left half and right half for palindrome
         while (right != null){
             if (left.data != right.data){
                 return false;
             }
             left = left.next;
             right = right.next;
         }
         return true;
    }
    static void main(String[] args) {
        IsPalindrome p1 = new IsPalindrome();
        p1.add(1);
        p1.add(2);
        p1.add(2);
        p1.add(1);
        p1.print();
        System.out.println( p1.checkPalindrome());
    }

}
