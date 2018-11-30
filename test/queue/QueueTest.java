/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bilal
 */
public class QueueTest {

    public QueueTest() {
    }

    @Test
    public void testEmptyQueue() {
        final Queue emptyQueue = new Queue();
        assertTrue("A newly created queue should be of size 0", emptyQueue.size() == 0);
        assertTrue("A newly created queue should be empty", emptyQueue.isEmpty() == true);
    }

    @Test(expected = IllegalQueueOperationException.class)
    public void testEmptyQueueDequeue() {
        final Queue<Object> emptyQueue = new Queue();
        emptyQueue.dequeue();
    }

    @Test(expected = IllegalQueueOperationException.class)
    public void testEmptyQueuePeek() {
        final Queue<Object> emptyQueue = new Queue();
        emptyQueue.peek();
    }

    @Test
    public void testQueueEnqueueDequeue() {
        final Queue<Object> queue = new Queue();
        final String firstElt = "Elt 1";
        final String secondElt = "Elt 2";
        final String thirdElt = "Elt 3";
        queue.enqueue(firstElt);
        assertTrue("A queue with 1 elt should have size 1", queue.size() == 1);
        queue.enqueue(secondElt);
        queue.enqueue(thirdElt);
        assertTrue("A queue with 3 elts should have size 3", queue.size() == 3);
        Object top = queue.dequeue();
        assertTrue("dequeue returns the top elt of the queue", top.equals(firstElt));
        assertTrue("After calling dequeue on a queue, size decreases", queue.size() == 2);
        queue.dequeue();
        assertTrue("After calling dequeue on a queue with 2 elts, size becomes 1", queue.size() == 1);
        final Object bottom = queue.dequeue();
        assertTrue("In a queue, the last-in is the last-out", bottom.equals(thirdElt));
        assertTrue("After calling dequeue on a queue with 1 elt, size becomes 0", queue.size() == 0);
    }

    @Test
    public void testQueueEnqueuePeek() {
        final Queue<Object> queue = new Queue();
        final String firstElt = "Ayya shi";
        queue.enqueue(firstElt);
        Object top = queue.peek();
        assertTrue("peek returns the top elt of the queue", top.equals(firstElt));
        assertTrue("After calling peek on a queue size remains intact", queue.size() == 1);
    }
}
