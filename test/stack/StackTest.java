/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bilal
 */
public class StackTest {

    public StackTest() {
    }

    @Test
    public void testEmptyStack() {
        final Stack emptyStack = new Stack();
        assertTrue("A newly created stack should be of size 0", emptyStack.size() == 0);
        assertTrue("A newly created stack should be empty", emptyStack.isEmpty() == true);
    }

    @Test(expected = IllegalStackPopException.class)
    public void testEmptyStackPop() {
        final Stack<Object> emptyStack = new Stack();
        Object top = emptyStack.pop();
    }

    @Test(expected = IllegalStackPeekException.class)
    public void testEmptyStackPeek() {
        final Stack<Object> emptyStack = new Stack();
        Object top = emptyStack.peek();
    }

    @Test
    public void testStackPop() {
        final Stack<Object> stack = new Stack();
        final String firstElt = "Ayya shi";
        stack.push(firstElt);
        assertTrue("A stack with 1 elt should have size 1", stack.size() == 1);
        Object top = stack.pop();
        assertTrue("pop returns the top elt of the stack", top.equals(firstElt));
        assertTrue("After calling pop on a stack with 1 elt, size becomes 0", stack.size() == 0);
    }

    @Test
    public void testStackPeek() {
        final Stack<Object> stack = new Stack();
        final String firstElt = "Ayya shi";
        stack.push(firstElt);
        Object top = stack.peek();
        assertTrue("peek returns the top elt of the stack", top.equals(firstElt));
        assertTrue("After calling peek on a stack size remains intact", stack.size() == 1);
    }

    @Test
    public void testStackReverseCopy() {
        final Stack<Object> stack = new Stack();
        Stack<Object> stackReverseCopy = stack.reverseCopy();
        assertTrue("A reverse copy of an empty stack must be empty too", stackReverseCopy.isEmpty());
        assertTrue("A reverse copy of an empty stack must have a different reference", stack != stackReverseCopy);

        stack.push("1");
        stack.push("2");
        stack.push("3");

        stackReverseCopy = stack.reverseCopy();
        assertTrue("A reverse copy of a stack has the same size", stackReverseCopy.size() == 3);
        assertTrue("A reverse copy of a stack has the elements in the reverse orde",
                stackReverseCopy.pop().equals("1"));
        assertTrue("A reverse copy of a stack has the elements in the reverse orde",
                stackReverseCopy.pop().equals("2"));
        assertTrue("A reverse copy of a stack has the elements in the reverse orde",
                stackReverseCopy.pop().equals("3"));
    }

    @Test
    public void testStackCopy() {
        final Stack<Object> stack = new Stack();
        Stack<Object> stackCopy = stack.copy();
        assertTrue("A copy of an empty stack must be empty too", stackCopy.isEmpty());
        assertTrue("A copy of an empty stack must have a different reference", stack != stackCopy);

        stack.push("1");
        stack.push("2");
        stack.push("3");

        // stack.display();
        stackCopy = stack.copy();
        assertTrue("A copy of a stack has the same size", stackCopy.size() == 3);
        assertTrue("A copy of a stack has the elements in the same orde",
                stackCopy.pop().equals("3"));
        assertTrue("A copy of a stack has the elements in the same orde",
                stackCopy.pop().equals("2"));
        assertTrue("A copy of a stack has the elements in the same orde",
                stackCopy.pop().equals("1"));
    }
}
