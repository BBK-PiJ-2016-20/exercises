public class ArrayStack<T> implements Stack<T> {
    private Object[] storage;
    private int size;

    private static final int INITIAL_SIZE = 1;

    public ArrayStack() {
        storage = new Object[INITIAL_SIZE];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return (T) storage[size - 1];
    }

    private void resize(int newSize) {
        Object[] newStorage = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        if (size < storage.length / 4) {
            resize(storage.length / 4);
        }

        T ret = (T) storage[size - 1];
        storage[size - 1] = null;
        size--;
        return ret;
    }

    public void push(T t) {
        if (size == storage.length) {
            resize(storage.length * 2);
        }
        storage[size] = t;
        size++;
    }

}