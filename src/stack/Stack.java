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
        restoreItemsFrom(backUpReverseCopyStack);
        return reverseCopyStack;
    }

    private void restoreItemsFrom(Stack<T> anotherStack) {
        while (!anotherStack.isEmpty()) {
            this.push(anotherStack.pop());
        }
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

    public int indexOf(T item) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(item)) {
                return elements.size() - i;
            }
        }
        return -1;
    }

    public int indexOfWithPnP(T item) {
        Stack<T> tmp = new Stack<>();
        int counter = 1;
        while (!this.isEmpty()) {
            final T top = this.pop();
            tmp.push(top);
            if (top.equals(item)) {
                restoreItemsFrom(tmp);
                return counter;
            } else {
                counter++;
            }
        }
        restoreItemsFrom(tmp);
        return -1;
    }

    public int indexOfWithPnPnR(T item) {
        return indexOfWithPnPnR(item, 1);
    }

    private int indexOfWithPnPnR(T item, int level) {
        System.out.println("Checking " + item
                + " at level " + level);
        display();
        if (this.isEmpty()) {
            return -1;
        }
        int foundIndex = 0;
        final T top = this.pop();
        System.out.println("Popped " + top);
        if (top.equals(item)) {
            foundIndex = level;
        } else {
            foundIndex = indexOfWithPnPnR(item, level + 1);
        }
        // restore the elements
        this.push(top);
        System.out.println("Pushed " + top);
        System.out.println("Found Index is " + foundIndex);
        return foundIndex;
    }

}
