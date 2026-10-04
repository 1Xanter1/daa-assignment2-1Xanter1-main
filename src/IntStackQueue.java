public class IntStackQueue implements IntQueue{
    // use two stacks as back-end
    IntArrayStack stackQueue1 =  new IntArrayStack();
    IntArrayStack stackQueue2 =  new IntArrayStack();
    public IntStackQueue() {
        // creates an empty stack
    }

    @Override
    public void enqueue(int value) {
        stackQueue1.push(value);
    }

    @Override
    public int dequeue() {
        if(stackQueue2.isEmpty()){
            while(!stackQueue1.isEmpty()){
                stackQueue2.push(stackQueue1.pop());
            }
        }
        return stackQueue2.pop();
    }

    @Override
    public int peek() {
        if(stackQueue2.isEmpty()){
            while(!stackQueue1.isEmpty()){
                stackQueue2.push(stackQueue1.pop());
            }
        }
        return stackQueue2.peek();
    }

    @Override
    public int size() {
        return stackQueue2.size() + stackQueue1.size();
    }

    @Override
    public boolean isEmpty() {
        if (stackQueue2.isEmpty() && stackQueue1.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // "[]" for empty queue
        // "[7, 8, 6]" for queue containing elements: 7, 8, 6. (head-first)
        if (stackQueue2.isEmpty() && stackQueue1.isEmpty()){
            return "[]";
        }
        if (stackQueue2.isEmpty()) {
            while(!stackQueue1.isEmpty()){
                stackQueue2.push(stackQueue1.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!stackQueue2.isEmpty()) {
            int value = stackQueue2.pop();

            sb.append(value);

            if (!stackQueue2.isEmpty()) {
                sb.append(", ");
            }

            stackQueue1.push(value);
        }
        sb.append("]");
        while (!stackQueue1.isEmpty()) {
            stackQueue2.push(stackQueue1.pop());
        }

        return sb.toString();
    }
}
