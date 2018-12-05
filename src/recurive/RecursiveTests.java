/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurive;

/**
 *
 * @author Bilal
 */
public class RecursiveTests {

    public static void main(String[] args) {
        int factOf4 = factorial(4);
        System.out.println(factOf4);

    }

    private static int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            System.out.println("Prior multiplying by: " + number);
            final int partialFactorial = factorial(number - 1) * number;
            System.out.println("Post multiplying by: " + number);
            return partialFactorial;
        }
    }
}
