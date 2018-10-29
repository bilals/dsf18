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
class List {

    private Object[] items = new Object[0];

    void add(Object newItem) {
        // 1- create an array that is one item bigger than the current array
        final Object[] oldItems = items;
        final Object[] newItems = new Object[oldItems.length + 1];

        // 2- copy previous elements in their right order
        for (int i = 0; i < oldItems.length; i++) {
            newItems[i] = oldItems[i];
        }

        // 3- add the new item given in parameter at the end of the new array
        newItems[newItems.length - 1] = newItem; // or oldItems.length

        // 4- replace the old array by the new one
        items = newItems;
    }

}
