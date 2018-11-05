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
public class TestProgram {

    public static void main(String[] args) {
        String name1 = "Samir";
        String name2 = "Ahmad";
        String name3 = "Walid";
        List<String> dsClass = new ArrayList();
//        List<String> dsClass = new LinkedList<>();
        dsClass.add(name1);
        dsClass.add(name2);
        dsClass.add(name3);
        System.out.println("2nd item is " + dsClass.get(1));
        System.out.println("There are " + dsClass.size() + " items");
    }

}
