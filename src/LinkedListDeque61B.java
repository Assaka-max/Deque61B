import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private int size;
    private Node sentinel;
    public LinkedListDeque61B(){
        this.size = 0;
        this.sentinel = new Node(null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item){
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    @Override
    public void addFirst(T x) {

    }

    @Override
    public void addLast(T x) {

    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
