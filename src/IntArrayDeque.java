public class IntArrayDeque implements IntDeque{
    // use IntArray as a circular array as back-end for this deque
    IntArray deque = new IntArray();
    private int front;

    public IntArrayDeque() {
        // creates an empty deque
    }

    @Override
    public void addFirst(int value) {
        if (deque.size() == deque.capacity()) {
            // resize using your existing IntArray logic
            IntArray newDeque = new IntArray();

            for (int i = 0; i < deque.size(); i++) {
                newDeque.add(deque.get((front + i) % deque.capacity()));
            }

            deque = newDeque;
            front = 0;
        }

        front = (front - 1 + deque.capacity()) % deque.capacity();
        deque.setPhysical(front, value);

        deque.add(0);
    }

    @Override
    public void addLast(int value) {
        if (deque.size() == deque.capacity()) {
            IntArray newDeque = new IntArray();

            for (int i = 0; i < deque.size(); i++) {
                newDeque.add(deque.get((front + i) % deque.capacity()));
            }

            deque = newDeque;
            front = 0;
        }

        int index = (front + deque.size()) % deque.capacity();
        deque.setPhysical(index, value);
        deque.add(0);

    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int value = deque.get(front);
        front = (front + 1) % deque.capacity();

        deque.remove(deque.size() - 1);

        if (deque.isEmpty()) {
            front = 0;
        }

        return value;
    }

    @Override
    public int removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int index = (front + deque.size() - 1) % deque.capacity();
        int value = deque.get(index);

        deque.remove(deque.size() - 1);

        if (deque.isEmpty()) {
            front = 0;
        }

        return value;
    }

    @Override
    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return deque.get(0);
    }

    @Override
    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return deque.get(deque.size()-1);
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public String toString() {
        // "[]" for empty deque
        // "[7, 8, 6]" for deque containing elements: 7, 8, 6. (front-first)
        return deque.toString();
    }
}