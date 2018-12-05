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

    final List<T> elements = new ArrayList<>();

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

    Stack<T> reverseCopy() {
        Stack<T> reverseCopyStack = new Stack<>();
        Stack<T> backUpReverseCopyStack = new Stack<>();
        while (!this.isEmpty()) {
            final T top = this.pop();
            reverseCopyStack.push(top);
            backUpReverseCopyStack.push(top);
        }
        while (!backUpReverseCopyStack.isEmpty()) {
            this.push(backUpReverseCopyStack.pop());
        }
        return reverseCopyStack;
    }

    public Stack<T> copy() {
        return this.reverseCopy().reverseCopy();
    }

    public void display() {
        display(this);
    }

    private void display(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        final T top = stack.pop();
        System.out.println(top);
        display(stack);
        stack.push(top);
    }

}
