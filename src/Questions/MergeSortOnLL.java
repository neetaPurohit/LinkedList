package Questions;

import JFC.LinkedListt;

public class MergeSortOnLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
        public static Node head;

//        get mid-code
        private Node getMid(Node head){
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow; //mid node
        }

//         merge code
        private Node merge(Node head1, Node head2){
            Node mergeLL = new Node(-1);//dummy node
            Node temp = mergeLL;

            while (head1 != null  && head2 != null){
                if (head1.data <= head2.data){
                    temp.next = head1;
                    head1 = head1.next;
                    temp= temp.next;
                }else {
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                }
            }
            while (head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp =  temp.next;
            }
            return mergeLL.next;
        }
        public Node mergeSort(Node head){
//            base case
            if (head == null || head.next == null){
                return head;
            }
//            find mid
            Node mid = getMid(head);

//            left and right merge sort
            Node rightHead = mid.next;
            mid.next =null;
            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);

//            merge
            return merge(newLeft,newRight);
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


    static void main(String[] args) {
        MergeSortOnLL ll = new MergeSortOnLL();
        ll.add(5);
        ll.add(3);
        ll.add(4);
        ll.add(9);
        ll.print();
        System.out.print("before sorting: ");
        ll.print();

        head = ll.mergeSort(head);

        System.out.print("After sorting: ");
        ll.print();

    }
}
