package LinkedList;

public class ReorderLL {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        l1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        printLinkedList(l1);
        Node reOrder = reorderLL(l1);

        printLinkedList(reOrder);
    }

    static Node reorderLL(Node head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node l2 = reverseLinkedList(slow.next);
        slow.next = null;  // Split the list into two halves

        // Step 3: Merge the two halves
        Node l1 = head;
        Node result = new Node(0);  // Dummy node to help with merging
        Node current = result;
        while (l1 != null && l2 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;

            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return result.next;  // Skip dummy node
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
