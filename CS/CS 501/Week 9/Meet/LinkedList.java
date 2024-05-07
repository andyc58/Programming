/**
 * LinkedList.java
 * @author: John Zlotek
 * @version: 20220522
 */

 public class LinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int num = 0;

    public LinkedList() {}

    public int size() {
        return this.num;
    }

    public void insert(E element, int idx) {
        Node<E> node = new Node(element);
        if (idx == 0) {
            node.setNext(this.head);
            this.head = node;
            if (this.tail == null) {
                this.tail = node;
            }
        } else {
            Node<E> prev = this.get(idx);
            node.setNext(prev.next());
            prev.setNext(node);
        }
        this.num++;
    }

    public void append(E element) {
        Node<E> node = new Node(element);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.num++;
    }

    public Node<E> head() {
        return this.head;
    }

    public Node<E> tail() {
        return this.tail;
    }

    public Node<E> get(int idx) {
        if (idx >= this.num || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> curr = this.head();
        for (int i = 0; i < idx; i++) {
            curr = curr.next(); 
        }
        return curr;
    }

    public Node<E> pop(int idx) throws IndexOutOfBoundsException {
        if (idx >= this.num || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> curr = this.head();

        if (idx == 0) {
            this.head = curr.next();
        } else {
            Node<E> last = null;
            for (int i = 0; i < idx; i++) {
                last = curr;
                curr = curr.next(); 
            }
            last.setNext(curr.next());
        }

        this.num--;
        return curr;
    }

    public String toString() {
        String ret = "";

        Node <E> curr = this.head();
        while (curr != null) {
            ret += curr.value().toString();
            curr = curr.next();
        }

        return ret;
    }
}

class Node<E> {
    private E data;
    private Node<E> next = null;
    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E value() {
        return this.data;
    }

    public Node<E> next() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}