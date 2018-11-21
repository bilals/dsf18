/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Bilal
 */
public class LinkedList<T> implements List<T> {

    Node<T> head;

    public void add(T item) {
        // If no items in list => head == null
        if (head == null) {
            // => create a new node and make it the head
            head = new Node();
            head.item = item;
        } else {
            // 1- retrieve last node
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            // 2- create a new node with the new item in it
            Node<T> newNode = new Node<>();
            newNode.item = item;
            // 3- link the last node to this new node
            currentNode.next = newNode;
        }
    }

    public T get(int position) {
        if (position < 0 || position >= size()) // Already n iterations!
        {
            return null;
            // Not Elegant! Solution After Midterm with Exceptions
        } else {
            // if(head == null) is equivalent to position >= size()
            Node<T> currentNode = head;
            int index = 0;
            while (index < position) {
                // && currentNode.next != null
                // is optional since we already
                // tested for the inclusion of position
                currentNode = currentNode.next;
                index++;
            }
            return currentNode.item;
        }
    }

    public int size() {
        // If no items in list => head == null
        if (head == null) {
            // => size is 0
            return 0;
        } else {
            // count the nodes until the last node
            int count = 1;
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                count++;
                currentNode = currentNode.next;
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T remove(int index) {
        // TODO Make sure index is legal

        if (index == 0) {
            final T removedItem = head.item;
            head = head.next;
            return removedItem;
        } else {
            // index >= 1
            Node<T> parentNode = head;
            Node<T> currentNode = head.next;
            int currentIndex = 1;
            while (currentIndex < index) {
                parentNode = currentNode;
                currentNode = currentNode.next;
                currentIndex++;
            }
            parentNode.next = currentNode.next;
            return currentNode.item;
        }
    }

    // Inner Class
    private class Node<T> {

        T item;
        Node<T> next;
    }

    @Override
    public boolean contains(T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int nbOccurrences(T item) {
        if (head == null) {
            return 0;
        } else {
            Node<T> currentNode = head;
            int nbOccurrences = 0;
            while (currentNode != null) {
                if (currentNode.item.equals(item)) {
                    nbOccurrences++;
                }
                currentNode = currentNode.next;
            }
            return nbOccurrences;
        }
    }
}
