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
public class BinaryTreeNode<T> extends TreeNode<T> {

    // We can do as follows:
    // children.get(0) == left
    // children.get(1) == right
    // yet, it is not important...
    public BinaryTreeNode(T item) {
        super(item);
    }

    @Override
    void addChildNode(TreeNode<T> childNode) {
        if (children.size() == 2) {
            throw new RuntimeException("A binary node cannot have more than 2 child nodes");
        }
        super.addChildNode(childNode);
    }

}
