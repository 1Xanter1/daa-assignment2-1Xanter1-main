public class IntLinkedList {
    Node head;
    Node tail;
    int size;

    // internal class that represents a list node.
    static class Node {
        int value;
        Node next;
        Node prev;
        Node() {
            value = 0;
            next = null;
            prev = null;
        }

        Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public IntLinkedList(){
        // creates an empty list
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int value){
        // adds a value at the end
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, int value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            head.next = newNode;
            newNode.prev = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else{
            Node current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;

            current.prev.next = newNode;
            current.prev = newNode;

        }
        size++;
    }

    public int get(int index){
        // returns a value at index
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }

    public void set(int index, int value){
        // updates a value at index
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.value = value;
    }

    public int remove(int index){
        // removes and returns value at index
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for(int i = 0; i < index; i++){
            current = current.next;
        }

        int value = current.value;

        if(size == 1){
            head = null;
            tail = null;
        }
        else if(index == 0){
            head = current.next;
            head.prev = null;
        } else if(index == size - 1){
            tail = current.prev;
            tail.next = null;
        } else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;

        return value;
    }

    public int size(){
        // returns size of list
        return size;
    }

    public boolean isEmpty(){
        // returns whether list is empty
        return size == 0;
    }

    @Override
    public String toString() {
        // returns String representation of list
        // "[]" for empty list
        // "[7, 8, 6]" for non-empty list
        if(isEmpty()){
            return "[]";
        } else{
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node current = head;
            for(int i = 0; i < size; i++){
                sb.append(current.value);
                current = current.next;
                if(current != null){
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}