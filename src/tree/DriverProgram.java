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
public class DriverProgram {

    public static void main(String[] args) {
        final TreeNode<String> katenjiNode = new TreeNode<>("Katenji");
        final TreeNode<String> nourNode = new TreeNode<>("Nour");
        final TreeNode<String> mustafaNode = new TreeNode<>("Mustafa");
        katenjiNode.addChildNode(new TreeNode<>("Hassan"));
        katenjiNode.addChildNode(nourNode);
        katenjiNode.addChildNode(mustafaNode);
        nourNode.addChildNode(new TreeNode<>("Bilal"));
        nourNode.addChildNode(new TreeNode<>("Zouheir"));
        mustafaNode.addChildNode(new TreeNode<>("Banna"));
        mustafaNode.addChildNode(new TreeNode<>("Rifai"));
        mustafaNode.addChildNode(new TreeNode<>("Omar"));
        mustafaNode.addChildNode(new TreeNode<>("Mohamad"));
        final Tree<String> companyHirerachy = new Tree<>(katenjiNode);
        companyHirerachy.display();
        int employyesNb = companyHirerachy.size();
        System.out.println("The number of employees is: " + employyesNb);
        String employeeToFind = "Bilal";
        boolean employeeIsFound = companyHirerachy.contains(employeeToFind);
        System.out.println("The company "
                + (employeeIsFound ? "has an" : "has no")
                + " employee called " + employeeToFind);
        employeeToFind = "Ayya Shi";
        employeeIsFound = companyHirerachy.contains(employeeToFind);
        System.out.println("The company "
                + (employeeIsFound ? "has an" : "has no")
                + " employee called " + employeeToFind);

        System.out.println("The company has an hirerachy of depth " + companyHirerachy.depth());
        companyHirerachy.displayByLevel();
    }

}
