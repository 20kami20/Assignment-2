public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        getNode(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            checkIndex(index);
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;
            Node newNode = new Node(item);
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        removeNode(getNode(index));
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        removeNode(tail);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not implemented yet");
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (Node current = tail; current != null; current = current.prev) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            array[i++] = current.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
    }

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
    }
}