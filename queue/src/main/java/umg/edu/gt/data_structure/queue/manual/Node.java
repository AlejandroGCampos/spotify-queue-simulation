package umg.edu.gt.data_structure.queue.manual;


public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public T getdata(){
    	return data;
    }
    
    public Node<T> getnext(){
    	return next;
    } 
    
    public void setNext(Node<T> next){
    	this.next = next;
    }
    
}