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
public class LinkedList<T> {

    Node<T> head;

    void add(T item) {
        if (head == null) {
            head = new Node();
            head.item = item;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            Node<T> newNode = new Node<>();
            newNode.item = item;
            currentNode.next = newNode;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    private class Node<T> {

        T item;
        Node<T> next;
    }

}
