public class IntLinkedListDeque implements IntDeque{
    // use IntLinkedList as back-end for this deque
    IntLinkedList deque  = new IntLinkedList();
    public IntLinkedListDeque() {
        // creates an empty deque
    }

    @Override
    public void addFirst(int value) {
        deque.add(0,value);
    }

    @Override
    public void addLast(int value) {
        deque.add(value);
    }

    @Override
    public int removeFirst() {
        return deque.remove(0);
    }

    @Override
    public int removeLast() {
        return deque.remove(deque.size()-1);
    }

    @Override
    public int peekFirst() {
        return deque.get(0);
    }

    @Override
    public int peekLast() {
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