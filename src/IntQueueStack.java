public class IntQueueStack implements IntStack{
    // use two queues as back-end
    IntLinkedListQueue queue1 = new IntLinkedListQueue();
    IntLinkedListQueue queue2 = new IntLinkedListQueue();
    @Override
    public void push(int value) {
        queue2.enqueue(value);
        while (!queue1.isEmpty()){
            queue1.enqueue(queue1.dequeue());
        }
        IntLinkedListQueue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    @Override
    public int pop() {
        return  queue1.dequeue();
    }

    @Override
    public int peek() {
        return queue1.peek();
    }

    @Override
    public int size() {
        return queue1.size();
    }

    @Override
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    @Override
    public String toString() {
        // returns String representation of the stack
        // "[]" for empty stack
        // "[7, 8, 6]" for non-empty one (bottom-element-first)
        return queue1.toString();
    }
}
