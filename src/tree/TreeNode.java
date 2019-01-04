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
public class TreeNode<T> {

    private final T item;
    final List<TreeNode<T>> children;

    public TreeNode(T item) {
        this.item = item;
        children = new ArrayList<>();
    }

    void addChildNode(TreeNode<T> childNode) {
        children.add(childNode);
    }

    T getItem() {
        return item;
    }

    void display(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println("|-" + item);
        for (int i = 0; i < children.size(); i++) {
            children.get(i).display(level + 1);
        }
    }

    int getNbNodes() {
        int nbChildrenNodes = 0;
        for (int i = 0; i < children.size(); i++) {
            nbChildrenNodes += children.get(i).getNbNodes();
        }
        return 1 + nbChildrenNodes;
    }

    public boolean containsInSelfOrAnySuccessor(T item) {
        if (this.item.equals(item)) {
            return true;
        } else {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).containsInSelfOrAnySuccessor(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<TreeNode<T>> getPathTo(T item) {
        if (this.item.equals(item)) {
            final ArrayList<TreeNode<T>> path = new ArrayList<>();
            path.add(this);
            return path;
        } else {
            for (int i = 0; i < children.size(); i++) {
                final List<TreeNode<T>> path = children.get(i).getPathTo(item);
                if (path.size() != 0) {
                    path.add(this);
                    return path;
                }
            }
            return new ArrayList<>();
        }
    }

}
