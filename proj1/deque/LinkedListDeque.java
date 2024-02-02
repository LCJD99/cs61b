package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private Node<T> root;

    private class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> last;
        Node(T i) {
            item = i;
            next = null;
            last = null;
        }
    }

    public LinkedListDeque() {
        root = new Node<T>(null);
        root.next = root;
        root.last = root;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<T>(item);
        n.next = root.next;
        n.last = root;
        n.next.last = n;
        root.next = n;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> n = new Node<T>(item);
        n.last = root.last;
        n.next = root;
        n.last.next = n;
        root.last = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> n = root.next;
        while (n != root) {
            System.out.print(n.item + " ");
            n = n.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ret = root.next.item;
        root.next.next.last = root;
        root.next = root.next.next;
        size--;
        return ret;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T ret = root.last.item;
        root.last.last.next = root;
        root.last = root.last.last;
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        int k = 0;
        Node<T> n = root.next;
        while (k < index) {
            n = n.next;
            k++;
        }
        return n.item;
    }

    private T getRecursive(int index, Node<T> r) {
        if (index == 0) {
            return r.item;
        } else {
            return getRecursive(index - 1, r.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, root.next);
    }
    public boolean equals(Object o) {
        if (o instanceof Deque) {
            Deque<T> other = (Deque<T>) o;
            int s2 = other.size();
            if (s2 != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if(!get(i).equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node<T> p;

        LinkedListDequeIterator() {
            p = root.next;
        }

        @Override
        public boolean hasNext() {
            return p != root;
        }

        @Override
        public T next() {
            T tmp = p.item;
            p = p.next;
            return tmp;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }
}
