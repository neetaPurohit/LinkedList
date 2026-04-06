package Questions;

import BasicsOfLL.LinkedList;

public class ReverseLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    static Node head;
        static class LinkedList{
            Node head;

//            reverse linked list funx
            void reverse() {
                Node prev = null;
                Node curr = head;
                Node next = null;


                while (curr != null) {
                    next = curr.next; //save next node
                    curr.next = prev; //reverse the arrow
                    prev = curr; //prev++
                    curr = next; //curr++
                }
                head = prev; //set the new head
            }
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

        }

    static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.print();
        ll.reverse();
        ll.print();

    }
}
