package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        l1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        Node l2 = new Node(9);
        Node n6 = new Node(4);
        l2.next = n6;

        printLinkedList(l1);
        printLinkedList(l2);

        Node sum = addTwoLL(l1, l2);
        printLinkedList(sum);
    }

    static Node addTwoLL(Node l1, Node l2) {
        Node r1 = reverseLinkedList(l1);
        Node r2 = reverseLinkedList(l2);

        int carry = 0;
        Node ans = null;
        Node temp = null;
        while (r1 != null || r2 != null || carry != 0) {
            int sum = carry;
            if (r1 != null) {
                sum += (int)r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                sum += (int)r2.val;
                r2 = r2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;
            Node newNode = new Node(digit);
            if (ans == null) {
                ans = temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        return reverseLinkedList(ans);
    }

    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = head;
        Node cur = head.next;
        head.next = null;

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
        System.out.println();
    }
}
