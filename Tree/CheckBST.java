
/*
Prob.: Check for BST
Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isBSTHelper(Node root,int min,int max)
    {
        //base case 
        if(root==null) return true;
        
        //if any node is out of range return false
        if(root.data<min || root.data>max) return false;
        
        //check if left subtree is less than root and right subtree is greater than root
        return isBSTHelper(root.left,min,root.data) 
                && isBSTHelper(root.right,root.data,max);
    }
}
