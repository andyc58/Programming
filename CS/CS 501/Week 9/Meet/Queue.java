public class Queue<E> {

    private LinkedList<E> list;

    public Queue() {
        // FIFO
        this.list = new LinkedList<E>();
    }

    public boolean empty() {
        return this.list.size() == 0;
    }

    public void enqueue(E element) {
        this.list.append(element);
    }

    public E dequeue() {
        return this.list.pop(0).value();
    }

    public E front() {
        if (this.list.head() != null)
            return this.list.head().value();
        return null;
    }

    public E back() {
        if (this.list.tail() != null)
            return this.list.tail().value();
        return null;
    }
}