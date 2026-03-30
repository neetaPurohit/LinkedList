package Questions;
//search for a key in a linked list. Return the position where it is found. if not found return -1.

import BasicsOfLL.LinkedList;

public class SearchInLL{
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

    public int searchInLL(int key){
//        T.c = O(n)
        Node temp = head;
        int i=0;

        while (temp!=null){
//            key found
            if (temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
//        key not found
        return -1;
    }

    static void main(String[] args) {
       SearchInLL ll = new SearchInLL();
       ll.addFirst(5);
       ll.addFirst(4);
       ll.addFirst(3);
       ll.addFirst(2);
       ll.addFirst(1);
       ll.printLL();


        System.out.println(ll.searchInLL(3));
        System.out.println(ll.searchInLL(11));

    }
}
