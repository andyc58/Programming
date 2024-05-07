public class Stack<E> {

    private LinkedList<E> list;

    public Stack() {
        this.list = new LinkedList<E>();
    }

    public boolean empty() {
        return this.list.size() == 0;
    }

    public void push(E element) {
        this.list.insert(element, 0);
    }

    public E pop() {
        return this.list.pop(0).value();
    }
}