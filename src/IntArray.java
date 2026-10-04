import java.util.Arrays;

public class IntArray {
    private int[] array;
    private int size;

    public IntArray(){
        // creates an empty array
        size = 0;
        array = new int[4];
    }

    public void add(int value){
        if(size == array.length){
            int [] B = new int[array.length*2];
            for(int i=0;i<array.length;i++){
                B[i] = array[i];
            }
            array = B;
        }
        size++;
        array[size-1] = value;
    }

    public void add(int index, int value){
        // adds value at index
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){
            int[] B = new int[array.length*2];
            for(int i=0;i<array.length;i++){
                B[i] = array[i];
            }
            array = B;
        }
        for (int i=size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        size++;
    }

    public int get(int index){
        // returns value at index
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, int value){
        // updates value at index

        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    public int remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int value = array[index];
        for (int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        size--;
        return value;
    }

    public int size(){
        // returns the current size of array
        return size;
    }

    public boolean isEmpty(){
        // returns whether array is empty
        return size == 0;
    }

    public void add(int[] values){
        // adds entire array values
        for(int i = 0; i < values.length; i++){
            add(values[i]);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "[]";
        } else{
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=0; i < size-1; i++){
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[size-1]);
            sb.append("]");
            return sb.toString();
        }
        // return String representation of array
        // "[]" empty array
        // "[7, 8, 6]" non-empty array
    }
    //for IntArrayDeque
    public int capacity() {
        return array.length;
    }

    public void setPhysical(int index, int value) {
        array[index] = value;
    }
}