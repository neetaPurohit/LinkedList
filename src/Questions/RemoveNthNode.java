package Questions;

public class RemoveNthNode {
    public class Node{
        int data;
        Node next;

        Node(int data){
             this.data = data;
             this.next = null;
         }
    }

    static Node head;

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


void deleteNthFromEnd(int n){
//         calculate size of LinkedList
        int sz = 0;
        Node temp = head;

        while (temp!=null){
            temp = temp.next;
            sz++;
        }
//        what if i have to delete head
        if (n == sz){
            head = head.next; //remove first
            return;
        }

//        sz-n
        int i =1;
        int indexToFind = sz-n;
        Node prev = head;
        while (i < indexToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }

    static void main(String[] args) {
       RemoveNthNode r1 = new RemoveNthNode();
       r1.add(1);
       r1.add(2);
       r1.add(3);
       r1.add(4);
       r1.add(5);

       r1.print();

       r1.deleteNthFromEnd(3);
       r1.print();
    }
  }

