public class IntMinHeapBottomUp implements IntQueue{
    // use IntArray as back-end for this heap
    IntArray heap =  new IntArray();
    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() &&
                    heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() &&
                    heap.get(right) < heap.get(smallest)) {
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
    }


    public IntMinHeapBottomUp() {
        // creates an empty MinHeap
        heap =  new IntArray();
    }

    public IntMinHeapBottomUp(int [] values) {
        // builds a MinHeap using bottom-up approach from an array of values
        heap = new IntArray();
        for(int i = 0; i < values.length; i++){
            heap.add(values[i]);
        }
        for(int i = heap.size() / 2 - 1; i >= 0; i++){
            siftDown(i);
        }
    }

    @Override
    public void enqueue(int value) {
        // insert into heap
        heap.add(value);
        int i = heap.size() - 1;
        while(i > 0){
            int parent = i / 2;
            if(heap.get(i) >= heap.get(parent)){
                break;
            }

            int temp =  heap.get(parent);
            heap.set(heap.get(parent),i);
            heap.set(i,temp);
        }
    }

    @Override
    public int dequeue() {
        // remove and return the minimum from the heap
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int min = heap.get(0);
        int last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.remove(heap.size()-1);

        if(!isEmpty()){
            siftDown(0);
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
