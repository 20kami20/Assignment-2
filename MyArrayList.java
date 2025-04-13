public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not implemented yet");
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if ((object == null && data[i] == null) || (object != null && object.equals(data[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if ((object == null && data[i] == null) || (object != null && object.equals(data[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public T next() {
                return (T) data[index++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
    }
}