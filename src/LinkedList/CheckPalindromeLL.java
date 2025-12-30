package LinkedList;

public class CheckPalindromeLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(3);

        head.next = n2; n2.next = n3; n3.next = n4;

        System.out.println(isLLPalindrome(head));
    }

    static boolean isLLPalindrome(Node head) {
        Node middle = findMiddle(head);
        Node reversedHalf = reverseLinkedList(middle);
        Node current = head;

        while (reversedHalf != null) {
            if (current.val != reversedHalf.val) {
                return false;
            }
            current = current.next;
            reversedHalf = reversedHalf.next;
        }
        return true;
    }

    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node reverseLinkedList(Node head) {
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
}
