package lrucache;

import org.junit.jupiter.api.Test;

public class testDLL {
    @Test
    public void testappend() {
        DLL dll = new DLL();

        Node<Integer> node;
        node = new Node<Integer>(0);

        dll.append(node);

        for (int i = 1; i < 3 ; i++) {
            node = new Node<Integer>(i);
            dll.append(node);
        }


        System.out.println(dll);
    }
}
