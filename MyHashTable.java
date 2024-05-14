public class MyHashTable<K, V> {
    public class HashNode<K, V> {
        public K key;
        public V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashNode<K, V>[] buckets;
    private int capacity;
    private int size;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        buckets = (HashNode<K, V>[]) new HashNode[capacity];
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return (hash & 0x7fffffff) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (HashNode<K, V> current = buckets[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
        }
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        for (HashNode<K, V> current = buckets[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}
