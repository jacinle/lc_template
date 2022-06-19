package disjointSet;

import java.util.*;

public class Test {

    public static void main(String args []) {
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);

        pairs.add(l);

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        pairs.add(l1);

        Test test = new Test();
        String result = test.smallestStringWithSwaps(s, pairs);
        System.out.println(result);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
        for (List<Integer> p : pairs) union(root, p.get(0), p.get(1));
        Map<Integer, PriorityQueue<Character>> map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < n; ++i) {
            int head = findRoot(root, i);
            root[i] = head;
            if (!map.containsKey(head)) map.put(head, new PriorityQueue<Character>());
            map.get(head).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append(map.get(root[i]).poll());
        return sb.toString();
    }

    private int findRoot(int[] root, int i) {
        if (root[i] == i) return i;
        int r = findRoot(root, root[i]);
        root[i] = r;
        return r;
    }

    private void union(int[] root, int src, int dst) {
        int srcRoot = findRoot(root, src);
        int dstRoot = findRoot(root, dst);
        if (srcRoot != dstRoot) root[srcRoot] = dstRoot;
    }

}
