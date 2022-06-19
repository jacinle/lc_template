import java.util.*;

class LRUCache {
    class DLL<T> {

        Node<T> head;
        Node<T> tail;

        /**
         * Append the node to end of DLL
         * @param node
         */
        void append(Node<T> node) {
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
        void moveToTail(Node<T> node) {
            if(node != tail) {
                Node<T> oldprev = node.prev;
                Node<T> oldnext = node.next;

                if( oldprev != null)
                    oldprev.next = node.next;

                if( oldnext != null ) {
                    oldnext.prev = oldprev;
                    if(node == head)
                        head = oldnext;
                }

                node.prev = tail;
                tail.next = node;
                tail = node;
                node.next = null;
            }
        }

        Node<T> removeHead() {
            Node<T> oldhead = head;

            // case for 1 node
            if(head == tail) {
                head = null;
                tail = null;
            }

            if(oldhead != null) {
                head = oldhead.next;
                if (head != null) {
                    head.prev = null;
                    oldhead.next = null;
                }
            }

            return oldhead;
        }

        Node<T> remove(Node<T> node) {
            if(node == head)
            {
                head = node.next;

            } if (node == tail)
            {
                tail = node.prev;


            }

            Node<T> oldprev = node.prev;
            Node<T> oldnext = node.next;

            if( oldprev != null)
                oldprev.next = oldnext;
            if( oldnext != null )
                oldnext.prev = oldprev;

            //cleanup
            node.next=null;
            node.prev=null;
            return node;
        }

        public String toString() {
            Node<T> node = head;
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

    class Node<T> {
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

    class Data {
        int key;
        int value;

        Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{"+key+","+value+"}";
        }

    }

    HashMap<Integer, Node<Data>> cache;
    DLL order ;
    int capacity;

    Node<Data> default_value;

    public LRUCache(int capacity) {
        cache = new HashMap(capacity);
        order = new DLL();
        this.capacity = capacity;
        default_value = new Node(new Data(-1,-1));

    }

    private void updateUsage(Node data) {
        order.moveToTail(data);
        //System.out.println("updateUsage Order " + order);
    }

    private void removeUsage(Node data){
        order.remove(data);
    }

    private void addUsage(Node data){
        order.append(data);
    }

    private void evict(int key) {
        //evict
        //System.out.println("Before Evict Order " + order);
        Node<Data> oldest = order.removeHead();

        //System.out.println("Evict key " + oldest);

        cache.remove(oldest.data.key);
        //System.out.println("After Evict Order " + order);

    }

    public int get(int key) {
        //System.out.println("getkey " + key );
        if(cache.containsKey(key))
            updateUsage(cache.get(key));
        Node<Data> node = cache.getOrDefault(key, default_value);
        return node.data.value;
    }

    public void put(int key, int value) {
        // already exists case
        Node<Data> data = new Node(new Data(key,value));
        //System.out.println("put key " + key );
        if(cache.containsKey(key)) {
            //update
            removeUsage(cache.get(key));

            cache.put(key,data);

            addUsage(data);

        } else {


            cache.put(key, data);

            if(cache.size()>capacity) {
                evict(key);
            }

            addUsage(data);
        }

        //System.out.println("Order after adding key " + order);
        //System.out.println(Arrays.asList(cache));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */