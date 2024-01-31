package deque;

public class ArrayDeque<T> implements Deque<T> {
    private int capacity;
    private Object[] array;
    private int first;
    private int size;

    private void resize(int s) {
        Object[] tmp = new Object[s];
        for (int i = 0; i < size; ++i) {
            tmp[i] = array[(first + i) % capacity];
        }
        array = tmp;
        first = 0;
        capacity = s;
    }

    public ArrayDeque() {
        capacity = 8;
        array = new Object[8];
        first = 0;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size + 1 > capacity) {
            resize(capacity * 2);
        }
        first = (first - 1 + capacity) % capacity;
        size++;
        array[first] = item;
    }

    @Override
    public void addLast(T item) {
        if (size + 1 > capacity) {
            resize(capacity * 2);
        }
        int last = (first + size) % capacity;
        size++;
        array[last] = item;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = first; i < size; ++i) {
            int t = (i + size) % capacity;
            System.out.print(array[t] + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (capacity > 8 && (size-1) * 4 < capacity) {
            resize(capacity / 2);
        }
        T ret = (T) array[first];
        first = (first + 1 ) % capacity;
        size--;
        return ret;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (capacity > 8 && (size-1) * 4 < capacity) {
            resize(capacity / 2);
        }
        T ret = (T) array[(first + size - 1) % capacity];
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        return (T) array[(first + index) % capacity];
    }

    public boolean equal(Object o) {
        if (o instanceof ArrayDeque){
            ArrayDeque<T> other = (ArrayDeque<T>) o;
            if (((ArrayDeque<T>) other).size() != size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // TODO
    public java.util.Iterator<T> iterator() {
        return null;
    }

}
