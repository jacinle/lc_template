package lrucache;

public class Node<T> {
    Node prev;
    Node next;

    T data;

    public Node(T t) {
        data = t;
    }

    public String toString() {
        return data.toString();
    }
}
