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
    private final List<TreeNode<T>> children;

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

}
