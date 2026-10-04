public class IntMinHeapTopDown implements IntQueue{
    // use IntArray as back-end for this heap
    private IntArray heap;
    public IntMinHeapTopDown() {
        // creates an empty MinHeap
    }

    public IntMinHeapTopDown(int [] values) {
        // builds a MinHeap using top-down approach from an array of values
    }

    @Override
    public void enqueue(int value) {
        // insert into heap
        if (isEmpty()){
            heap.add(value);
        } else{
            heap.add(value);
            int child = heap.size()-1;
            while (child > 0 && heap.get(child-1)){

            }
        }
    }

    @Override
    public int dequeue() {
        // remove and return the minimum from the heap
        return 0;
    }

    @Override
    public int peek() {
        // return the minimum
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {

    }

    @Override
    public String toString() {
        // returns String representation of the internal IntArray

        return heap.toString();
    }
}