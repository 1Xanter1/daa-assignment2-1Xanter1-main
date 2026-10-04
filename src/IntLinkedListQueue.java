public class IntLinkedListQueue implements IntQueue{
    IntLinkedList queue = new IntLinkedList();

    public IntLinkedListQueue() {
        // creates an empty queue
    }

    @Override
    public void enqueue(int value) {
        // adds a value to queue
        queue.add(value);
    }

    @Override
    public int dequeue() {
        // removes, and returns a value from queue
        return queue.remove(0);
    }

    @Override
    public int peek() {
        // returns a value from queue
        return queue.get(0);
    }

    @Override
    public int size() {
        // return size of queue
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        // returns whether queue is empty
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        // "[]" for empty queue
        // "[7, 8, 6]" for queue containing elements: 7, 8, 6. (head-first)
        return queue.toString();
    }
}
