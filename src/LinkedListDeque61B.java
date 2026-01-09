import java.util.ArrayList;
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
        Node firstNode = new Node(x);
        firstNode.item = x;
        this.sentinel.next.prev = firstNode;
        firstNode.next = this.sentinel.next;
        this.sentinel.next = firstNode;
        firstNode.prev = this.sentinel;
    }

    @Override
    public void addLast(T x) {
        Node lastNode = new Node(x);
        lastNode.item = x;
        this.sentinel.prev.next = lastNode;
        lastNode.prev = this.sentinel.prev;
        lastNode.next = this.sentinel;
        this.sentinel.prev = lastNode;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node node = this.sentinel.next;
        while (!node.equals(sentinel)){
            returnList.add(node.item);
            node = node.next;
        }
        return returnList;
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
