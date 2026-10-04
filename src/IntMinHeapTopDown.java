public class IntMinHeapTopDown implements IntQueue{
    // use IntArray as back-end for this heap
    private IntArray heap;
    public IntMinHeapTopDown() {
        // creates an empty MinHeap
        heap = new IntArray();
    }

    public IntMinHeapTopDown(int [] values) {
        // builds a MinHeap using top-down approach from an array of values
        heap = new IntArray();
        for (int i = 0; i < values.length; i++) {
            enqueue(values[i]);
        }
    }

    @Override
    public void enqueue(int value) {
        // insert into heap
        heap.add(value);

        int i = heap.size()-1;

        while (i > 0 && heap.get((i-1)/2)>value){
            int parent = heap.get((i-1)/2);

            if (heap.get(parent) <= heap.get(i)) {
                break;
            }

            heap.set((i-1)/2,value);
            heap.set(i,parent);
            i = parent;
        }
    }

    @Override
    public int dequeue() {
        // remove and return the minimum from the heap
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int min = heap.get(0);

        int last = heap.get(heap.size() - 1);
        heap.set(0, last);

        heap.remove(heap.size() - 1);

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);

            i = smallest;
        }

        return min;
    }

    @Override
    public int peek() {
        // return the minimum
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        // returns String representation of the internal IntArray
        return heap.toString();
    }
}