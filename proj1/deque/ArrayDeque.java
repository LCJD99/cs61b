package deque;

public class ArrayDeque<T> {
    private int capacity;
    private Object[] array;
    private int first;
    private int size;

    private void resize(int s) {
        Object[] tmp = new Object[s];
        for(int i = 0; i < size; ++i) {
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
    public void addFirst(T item) {
        if(size + 1 > capacity) {
            resize(capacity * 2);
        }
        first = (first - 1 + capacity) % capacity;
        size++;
        array[first] = item;
    }

    public void addLast(T item) {
        if(size + 1 > capacity) {
            resize(capacity * 2);
        }
        int last = (first + size) % capacity;
        size++;
        array[last] = item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = first; i < size; ++i) {
            int t = (i + size) % capacity;
            System.out.print(array[t] + " ");
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        if(capacity > 8 && (size-1) * 4 < capacity) {
            resize(capacity / 2);
        }
        T ret = (T) array[first];
        first = (first + 1 ) % capacity;
        size--;
        return ret;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        if(capacity > 8 && (size-1) * 4 < capacity) {
            resize(capacity / 2);
        }
        T ret = (T) array[(first + size - 1) % capacity];
        size--;
        return ret;
    }

    public T get(int index) {
        return (T) array[(first + index) % capacity];
    }

}
