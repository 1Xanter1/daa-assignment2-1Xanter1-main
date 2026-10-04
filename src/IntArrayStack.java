public class IntArrayStack implements IntStack{
    // uses IntArray as back-end
    IntArray stack = new IntArray();
    public IntArrayStack(){
        // creates empty stack
    }

    @Override
    public void push(int value) {
        // pushes value on top of stack
        stack.add(value);
    }

    @Override
    public int pop() {
        int value = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return value;
    }

    @Override
    public int peek() {
        // returns the value from top of stack without removing it
        return stack.get(stack.size()-1);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        // returns String representation of the stack
        // "[]" for empty stack
        // "[7, 8, 6]" for non-empty one (bottom-element-first)
        return stack.toString();
    }
}
