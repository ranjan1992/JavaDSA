package LinkedList;

class Node<E> {
    E val;
    Node<E> next;
    Node<E> prev;

    public Node(E val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
