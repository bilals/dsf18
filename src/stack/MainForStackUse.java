/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author Bilal
 */
public class MainForStackUse {

    public static void main(String[] args) {
        //checkArithmeticExpression();
        Stack<String> cds = new Stack<>();
        cds.push("Windows");
        final String wael_Kfoury_CD = "Wael Kfoury";
        cds.push(wael_Kfoury_CD);
        cds.push("Office");
        //cds.indexOfWithPnPnR("Not Found");
        cds.indexOfWithPnPnR(wael_Kfoury_CD);
    }

    private static void checkArithmeticExpression() {
        Scanner inFromKeyboard = new Scanner(System.in);
        System.out.println("Enter an arithmetic expression:");
        final String givenString = inFromKeyboard.nextLine();
        Stack<String> verificationStack = new Stack<>();
        for (int i = 0; i < givenString.length(); i++) {
            final char charAtI = givenString.charAt(i);
            if (charAtI == '(') {
                verificationStack.push("(");
            }
            if (charAtI == ')') {
                try {
                    verificationStack.pop();
                } catch (IllegalStackPopException e) {
                    System.out.println("There are extra ')'");
                }
            }
        }
        if (!verificationStack.isEmpty()) {
            System.out.println("There are extra '('");
        } else {
            System.out.println("Your expression is correctly parenthesized");
        }
    }

}
