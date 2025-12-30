package LinkedList;

public class ReverseLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
        Node newHead = reverseLinkedList(head);
        printLinkedList(newHead);
    }

    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    static void printLinkedList(Node temp) {
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
