package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node<T> root;

    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> last;
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

    private T getRecursive(int index, Node<T> root) {
        if (index == 0) {
            return root.item;
        } else {
            return getRecursive(index - 1, root.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, root.next);
    }
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> other = (LinkedListDeque<T>) o;
            Node<T> r0 = root.next;
            Node<T> r1 = other.root.next;
            while (r0 != null && r1 != null) {
                if (!r0.item.equals(r1.item)) {
                    return false;
                }
                r0 = r0.next;
                r1 = r1.next;
            }
            return r0 == null && r1 == null;
        } else {
            return false;
        }
    }

    // TODO
    public java.util.Iterator<T> iterator() {
        return null;
    }
}
