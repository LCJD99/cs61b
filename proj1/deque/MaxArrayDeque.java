package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> {
    private ArrayDeque<T> array;
    private Comparator<T> cmp;

    public MaxArrayDeque() {
        array = new ArrayDeque<>();
    }

    public MaxArrayDeque(Comparator<T> c) {
        array = new ArrayDeque<>();
        cmp = c;
    }

    public void addFirst(T item) {
        array.addFirst(item);
    }

    public void addLast(T item) {
        array.addLast(item);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int size() {
        return array.size();
    }


    public void printDeque() {
        array.printDeque();
    }


    public T removeFirst() {
        return array.removeFirst();
    }

    public T removeLast() {
        return array.removeLast();
    }

    public T get(int index) {
        return array.get(index);
    }

    public boolean equal(Object o) {
        return false;
    }

    public java.util.Iterator<T> iterator() {
        return null;
    }

    public T max() {
        return max(cmp);
    }

    public T max(Comparator<T> c) {
        if (array.isEmpty()) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (c.compare(array.get(i), array.get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return array.get(maxIndex);
    }


}
