/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import list.ArrayList;
import list.List;

/**
 *
 * @author Bilal
 */
public class Queue<T> {

    List<T> items = new ArrayList();

    int size() {
        return items.size();
    }

    boolean isEmpty() {
        return items.isEmpty();
    }

    void enqueue(T element) {
        items.add(element);
    }

    T dequeue() {
        if (isEmpty()) {
            throw new IllegalQueueOperationException();
        }
        return items.remove(0);
    }

    T peek() {
        if (isEmpty()) {
            throw new IllegalQueueOperationException();
        }
        return items.get(0);
    }
}
