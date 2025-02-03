
/*
Prob.: Height of Binary Tree
Given a binary tree, find its height.

The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. 
A leaf node is a node that does not have any children.
*/

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node.left==null && node.right==null) return 0;
        
        int leftHeight=-1,rightHeight=-1;
        if(node.left!=null)
            leftHeight=height(node.left);
        if(node.right!=null)
            rightHeight=height(node.right);
            
        return 1+ Math.max(leftHeight,rightHeight);
    }
}
