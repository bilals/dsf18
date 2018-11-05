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
class ArrayList<SpecificType> implements List<SpecificType> {

    private SpecificType[] items = (SpecificType[]) new Object[0];

    public void add(SpecificType newItem) {
        // 1- create an array that is one item bigger than the current array
        final SpecificType[] oldItems = items;
        final SpecificType[] newItems = (SpecificType[]) new Object[oldItems.length + 1];

        // 2- copy previous elements in their right order
        for (int i = 0; i < oldItems.length; i++) {
            newItems[i] = oldItems[i];
        }

        // 3- add the new item given in parameter at the end of the new array
        newItems[newItems.length - 1] = newItem; // or oldItems.length

        // 4- replace the old array by the new one
        items = newItems;
    }

    public SpecificType get(int index) {
        return items[index];
    }

    public int size() {
        return this.items.length;
    }

    // checks whether the list is empty
    boolean isEmpty() {
        final boolean sizeIsZero = size() == 0;
        return sizeIsZero;
        // if(size() == 0)
        //   return true;
        // else
        // return false;
    }

}
