/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bilal
 */
public class ListTest {

    public ListTest() {
    }

    @Test
    public void testEmptyArrayList() {
        List<String> list = new ArrayList();
        assertTrue("A newly created list must be empty", list.isEmpty());
        assertTrue("A newly created list must have size equal to 0", list.size() == 0);
    }

    @Test
    public void testNormalArrayListBehavior() {
        String name1 = "Samir";
        String name2 = "Ahmad";
        String name3 = "Walid";
        List<String> list = new ArrayList();
        list.add(name1);
        assertTrue("A list with 1 item should have size equal 1", list.size() == 1);
        list.add(name2);
        list.add(name3);
        assertTrue("A list must contain any of its items", list.contains(name2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayListNegativeIndex() {
        String name1 = "Samir";
        String name2 = "Ahmad";
        String name3 = "Walid";
        List<String> list = new ArrayList();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayListIndexBeyondSize() {
        String name1 = "Samir";
        String name2 = "Ahmad";
        String name3 = "Walid";
        List<String> list = new ArrayList();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.get(3);
    }

    @Test
    public void testLinkedList() {
        // TODO
//        List<String> dsClass = new LinkedList<>();
    }
}
