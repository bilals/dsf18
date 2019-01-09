/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import list.ArrayList;
import list.List;

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
        if (root == null) {
            return 0;
        } else {
            //return getNbNodes(root);
            return root.getNbNodes();
        }
    }

    public boolean contains(T item) {
        if (root == null) {
            return false;
        } else {
            return root.containsInSelfOrAnySuccessor(item);
        }
    }

    public List<TreeNode<T>> getPathTo(T item) {
        if (root == null) {
            final ArrayList<TreeNode<T>> path = new ArrayList<>();
            return path;
        } else {
            return root.getPathTo(item);
        }
    }

    void display() {
        root.display(0);
    }

//    private int getNbNodes(TreeNode<T> node) {
//        int nbChildNodes = 0;
//        for (int i = 0; i < node.children.size(); i++) {
//            nbChildNodes += getNbNodes(node.children.get(i));
//        }
//        return 1 + nbChildNodes;
//    }
    int depth() {
        if (root == null) {
            return 0;
        } else {
            return root.getSubTreeDepth();
        }
    }

    void displayByLevel() {
        if (root != null) {
            root.displayByLevel();
        }
    }
}
