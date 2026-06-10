class Node {
    int value;
    Node next;

    Node(int v) {
        value = v;
        next = null;
    }
}

class LinkedList {
    Node head = null;
    int length = 0;

    LinkedList() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList ll = new LinkedList();

        ll.reverse();
    }
}
