/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Bilal
 */
public class Tree<T> {

    private final TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    int size() {
        return 0;
    }

    void display() {
        root.display(0);
    }

}
