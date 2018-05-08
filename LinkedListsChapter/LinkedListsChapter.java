import java.util.*;

public class LinkedListsChapter {
    Node head;

    public LinkedListsChapter(Node head) {
        this.head = head;
    }

    public void addNode(int data) {
        Node n = this.head;
        while(n.next != null) {
            n = n.next;
        }
        n.next = new Node(data);
    }

    public static void printLinkedList(Node head) {
        Node n = head;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void removeDuplicate(){
        HashSet<Integer> hs = new HashSet<Integer>();
        Node n = this.head;
        hs.add(this.head.data);
        while(n.next != null) {
            if(!hs.contains(n.next.data)) {
                hs.add(n.next.data);
                n = n.next;
            } else {
                n.next = n.next.next;
            }
        }
    }

    public Node returnKth(int k) {
        Node p1 = head;
        Node p2 = head;
        int count = 1;
        while(p2.next != null) {
            if(count<k) {
                p2 = p2.next;
                count++;
            }else {
            p1 = p1.next;
            p2 = p2.next;
            }
        }
        return p1;
    }

    public boolean removeGiven(Node toRemove) {
        if(toRemove == null || toRemove.next == null) {
            return false;
        }
        toRemove.data = toRemove.next.data;
        toRemove.next = toRemove.next.next;
        return true;
    }

    public int findValueIndex(Node head, int value) {
        Node n = head;
        int index = 1;
        int minIndex = 99999;
        while(n.next != null) {
            if(n.data == value && index<minIndex) {
                minIndex = index;
            }
            n = n.next;
            index++;
        }
        return minIndex;
    }
    public void partitionAround(Node head, int value) {
        int valueIndex = findValueIndex(head, value);
        Node n = head;
        Node n2 = n.next;
        int index = 1;
        while(n2.next != null) {
            System.out.println("valueIndex:" + valueIndex);
            System.out.println("index:" + index);
            if(n2.data < value && index > valueIndex) {
                head = partitionAroundHelper(head, n2, n);
                valueIndex++;
            }
            n = n.next;
            n2 = n2.next;
            index++;
        }
    }

    public Node partitionAroundHelper(Node head, Node n2, Node n) {
        Node dummy = new Node(n2.data);
        n.next = n2.next;
        dummy.next = head;
        return dummy;
    }

    public int getValue(Node n1) {
        Node n = n1;
        Stack<Integer> s = new Stack<Integer>();
        while(n != null) {
            s.push(n.data);
            n = n.next;
        }
        StringBuilder valueString = new StringBuilder();
        while(!s.isEmpty()) {
            valueString.append(s.pop());
        }
        return Integer.parseInt(valueString.toString());
    }

    public Node sumLists(Node n1, Node n2) {
        int value1 = getValue(n1);
        int value2 = getValue(n2);
        int sum = value1 + value2;
        Stack<Integer> s = new Stack<Integer>();
        while(sum > 0) {
            s.push(sum % 10);
            sum = sum / 10;
        }
        Node sumTail = new Node(s.pop());
        Node prev = sumTail;
        while(!s.isEmpty()){
            Node n = new Node(s.pop());
            n.next = prev;
            prev = n;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(8);
        LinkedListsChapter linkedlist1 = new LinkedListsChapter(head);
        linkedlist1.addNode(5);
        linkedlist1.addNode(2);
        linkedlist1.addNode(19);
        linkedlist1.addNode(6);
        linkedlist1.addNode(10);
        linkedlist1.addNode(2);
        Node head2 = new Node(7);
        LinkedListsChapter linkedlist2 = new LinkedListsChapter(head2);
        linkedlist2.addNode(1);
        linkedlist2.addNode(6);
        Node head3 = new Node(5);
        LinkedListsChapter linkedlist3 = new LinkedListsChapter(head3);
        linkedlist3.addNode(9);
        linkedlist3.addNode(2);
        Node sum = linkedlist2.sumLists(head2, head3);
//        linkedlist1.removeDuplicate();
//        int k = 4;
//        Node kth = linkedlist1.returnKth(k);
//        System.out.println(k + "th element is: " + kth.data);
//        Node toRemove = kth;
//        linkedlist1.removeGiven(toRemove);
//        int value = 19;
//        linkedlist1.partitionAround(head, 19);
        printLinkedList(sum);
    }
}
