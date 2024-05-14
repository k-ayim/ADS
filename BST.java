import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    public class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public V get(K key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.value;
    }

    private Node get(Node x, K key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inOrder(root, nodes);
        return nodes;
    }

    private void inOrder(Node x, List<Node> nodes) {
        if (x != null) {
            inOrder(x.left, nodes);
            nodes.add(x);
            inOrder(x.right, nodes);
        }
    }
}
