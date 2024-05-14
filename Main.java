public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> myHashTable = new MyHashTable<>(10);
        for (int i = 0; i < 100; i++) {
            MyTestingClass testKey = new MyTestingClass("Key" + i);
            String testValue = "Value" + i;
            myHashTable.put(testKey, testValue);
        }

        for (int i = 0; i < myHashTable.buckets.length; i++) {
            MyHashTable<MyTestingClass, String>.HashNode<MyTestingClass, String> node = myHashTable.buckets[i];
            int count = 0;
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + " has " + count + " elements.");
        }

        MyTestingClass keyToFind = new MyTestingClass("Key50");
        System.out.println("Retrieved Value: " + myHashTable.get(keyToFind));
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < 20; i++) {
            bst.put(i, "Val" + i);
        }

        Iterable<BST<Integer, String>.Node> iterable = bst.iterator();
        for (BST<Integer, String>.Node node : iterable) {
            System.out.println("Key: " + node.key + ", Value: " + node.value);
        }
    }
}