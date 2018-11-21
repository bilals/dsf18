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
interface List<T> {

    public boolean contains(T item);

    public void add(T item);

    public T get(int index);

    public int size();

    public boolean isEmpty();

    public T remove(int index);

}
