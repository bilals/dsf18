/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTrees;

/**
 *
 * @author Bilal
 */
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    void display() {
        root.display(0);
    }

    public boolean contains(T item) {
//        if (root == null) {
//            return false;
//        } else {
//            return root.containsInSelfOrAnySuccessor(item);
//        }
        return doesContaint(root, item);
    }

    private boolean doesContaint(BinaryNode<T> node, T item) {
        if (node == null) {
            return false;
        }
        if (node.item.equals(item)) {
            return true;
        }
        return doesContaint(node.left, item)
                || doesContaint(node.right, item);
    }

    private static class BinaryNode<T> {

        private T item;
        private BinaryNode<T> left;
        private BinaryNode<T> right;

        public BinaryNode(T item) {
            this.item = item;
        }

        void display(int level) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println("|-" + item);
            if (left != null) {
                left.display(level + 1);
            }
            if (right != null) {
                right.display(level + 1);
            }
        }

        public boolean containsInSelfOrAnySuccessor(T item) {
            if (this.item.equals(item)) {
                return true;
            }
            if (left != null) {
                if (left.containsInSelfOrAnySuccessor(item)) {
                    return true;
                }
            }
            if (right != null) {
                if (right.containsInSelfOrAnySuccessor(item)) {
                    return true;
                }
            }
            // current node does not contain the item
            // AND
            // left is null or does not contain item
            // AND
            // right is null or does not contain item
            return false;
        }
    }

    public static void main(String[] args) {
        BinaryNode<String> root = new BinaryNode<>("Marital Status");
        BinaryNode<String> married = new BinaryNode<>("Married");
        BinaryNode<String> single = new BinaryNode<>("Single");
        BinaryNode<String> moreThan3Children = new BinaryNode<>("More than 3 chilren");
        root.left = single;
        root.right = married;
        married.right = moreThan3Children;
        BinaryTree<String> taxDecisionTree = new BinaryTree<>(root);
        taxDecisionTree.display();
        System.out.println("The tree "
                + (taxDecisionTree.contains("Shi") ? " has " : " does'nt have ")
                + "a node called Shi");
    }

}
