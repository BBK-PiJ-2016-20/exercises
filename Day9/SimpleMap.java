public class SimpleMap<K, V> {
    Object[] storage;

    private final static int SIZE = 1000;

    public SimpleMap() {
        storage = new Object[SIZE];

        for (int i = 0; i < SIZE; i++) {
            storage[i] = null;
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        storage[hash(key)] = value;
    }

    public V get(K key) {
        return (V) storage[hash(key)];
    }

    public void delete(K key) {
        storage[hash(key)] = null;
    }
}