package umg.edu.gt.data_structure.queue.manual;

public class QueueLinked<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueLinked() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // O(1)
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // O(1)
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Cola vacía");
        
        T value = head.getdata();
        head = head.getnext();
        
        if (head == null) { 
            tail = null; 
        }
        
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
        	throw new IllegalStateException("Cola vacía");	
        }
        return head.getdata();
    }

    public boolean isEmpty() { 
        return size == 0; 
    }

    public int size() { 
        return size; 
    }
}