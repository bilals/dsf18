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
class ArrayList<T> implements List<T> {

    private T[] items = (T[]) new Object[0];

    public void add(T newItem) {
        // 1- create an array that is one item bigger than the current array
        final T[] oldItems = items;
        final T[] newItems = (T[]) new Object[oldItems.length + 1];

        // 2- copy previous elements in their right order
        for (int i = 0; i < oldItems.length; i++) {
            newItems[i] = oldItems[i];
        }

        // 3- add the new item given in parameter at the end of the new array
        newItems[newItems.length - 1] = newItem; // or oldItems.length

        // 4- replace the old array by the new one
        items = newItems;
    }

    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public int size() {
        return this.items.length;
    }

    // checks whether the list is empty
    public boolean isEmpty() {
        final boolean sizeIsZero = size() == 0;
        return sizeIsZero;
        // if(size() == 0)
        //   return true;
        // else
        // return false;
    }

    @Override
    public T remove(int index) {
        if (index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // 1- create a new array that is 1 item smaller
        T[] newItems = (T[]) new Object[items.length - 1];

        for (int i = 0; i < items.length; i++) {
            if (i < index) {
                // 2- copy all the item up until index-1 from old to same position in new
                newItems[i] = items[i];
            }
            if (i > index) {
                // 3- copy all items from inex+1 up to size-1 from old to one position ahead in the new
                newItems[i - 1] = items[i];
            }
        }
        T removedItem = items[index];
        // 4- replace the old array by the new one
        items = newItems;
        // 5- return the removed item
        return removedItem;
    }

    @Override
    public boolean contains(T item) {
//        boolean found = false;
        for (T existingItem : items) {
            // read it as: for each exisitingItem of type SpecificType in items
            if (existingItem.equals(item)) {
                return true;
//                found = true;
//                break;
            }
        }
        // return found;
        return false;
    }

    public ArrayList<T> merge(ArrayList<T> anotherList) {
        final ArrayList<T> resultList = new ArrayList<>();
        for (T item : items) {
            resultList.add(item);
        }
        for (T item : anotherList.items) {
            resultList.add(item);
        }
        return resultList;
        // O(n^2) n=max(n1, n2)
    }

    public ArrayList<T> enhancedMerge(ArrayList<T> anotherList) {
        final ArrayList<T> resultList = new ArrayList<>();
        final int totalLength = this.items.length + anotherList.items.length;
        resultList.items = (T[]) new Object[totalLength];
        for (int i = 0; i < items.length; i++) {
            resultList.items[i] = items[i];
        }
        int shift = this.items.length;
        for (int i = 0; i < anotherList.items.length; i++) {
            resultList.items[i + shift] = anotherList.items[i];
        }
        return resultList;
        // O(n) n=max(n1, n2)
    }

    public ArrayList<T> intersect(ArrayList<T> anotherList) {
        final ArrayList<T> resultList = new ArrayList<>();
        for (T item : items) {
            if (anotherList.contains(item)) {
                // && ! resultList.contains(item)
                // to not add the same intersection item twice
                resultList.add(item);
                break; // adds each item only once (not really)
            }
        }
        return resultList;
    }

}
