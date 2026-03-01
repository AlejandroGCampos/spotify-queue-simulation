package umg.edu.gt.data_structure.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
        Queue<String> q = new ArrayDeque<>();
        q.offer("A");
        q.offer("B");
        q.offer("C");

        System.out.println(q.peek()); // A
        System.out.println(q.poll()); // A
        System.out.println(q.poll()); // B
        System.out.println(q.isEmpty()); // false
        logger.info("este es mi mensaje");
        logger.error("este es mi mensaje");
        
        QueueLinked<Integer> queue = new QueueLinked<>();
        queue.enqueue(10);
        queue.enqueue(20);
        //queue.enqueuePriority(50);
        queue.enqueue(30);

        System.out.println(queue.peek());   // 10
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.size());    // 1
    }

}