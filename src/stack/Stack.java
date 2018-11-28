/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import list.ArrayList;
import list.List;

/**
 *
 * @author Bilal
 */
public class Stack<T> {

    List<T> elements = new ArrayList<>();

    public Stack() {
    }

    int size() {
        return elements.size();
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    T pop() {
        if (isEmpty()) {
            throw new IllegalStackPopException();
        }
        return elements.remove(elements.size() - 1);
    }

    T peek() {
        if (isEmpty()) {
            throw new IllegalStackPeekException();
        }
        return elements.get(elements.size() - 1);
    }

    void push(T element) {
        elements.add(element);
    }

}
