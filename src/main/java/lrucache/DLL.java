package lrucache;

public class DLL<T> {

    Node head;
    Node tail;

    /**
     * Append the node to end of DLL
     * @param node
     */
    void append(Node node) {
        if(tail == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;

            tail = node;
        }
    }

    /**
     * move a node from its current position to tail
     * @param node
     */
    void moveToTail(Node node) {
        node.prev.next = node.next;

        node.prev = tail;
        node.next = null;
    }

    public String toString() {
        Node node = head;
        StringBuffer result = new StringBuffer();
        int count =0;
        while(node != null ) {
            count++;
            result.append(node.toString());
            result.append(",");
            node = node.next;
        }
        return result.toString();
    }


}
