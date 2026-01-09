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
        this.size++;
    }

    @Override
    public void addLast(T x) {
        Node lastNode = new Node(x);
        lastNode.item = x;
        this.sentinel.prev.next = lastNode;
        lastNode.prev = this.sentinel.prev;
        lastNode.next = this.sentinel;
        this.sentinel.prev = lastNode;
        this.size++;
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
        return this.sentinel.next == this.sentinel;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if(!this.isEmpty()){
            T item = this.sentinel.next.item;
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.prev = this.sentinel;
            this.size--;
            return item;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if(!this.isEmpty()){
            T item = this.sentinel.prev.item;
            this.sentinel.prev = this.sentinel.prev.prev;
            this.sentinel.prev.next = this.sentinel;
            this.size--;
            return item;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if(index < this.size()){
            Node currNode = this.sentinel;
            for(int i = 0; i <= index; i++) currNode = currNode.next;
            return currNode.item;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if(this.isEmpty() || this.size <= index) return null;
        return getRecursiveHelper(this.sentinel.next, index);
    }

    private T getRecursiveHelper(Node current, int index){
        if(index == 0) return current.item;
        return getRecursiveHelper(current.next, index-1);
    }
}
