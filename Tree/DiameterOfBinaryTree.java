
/*
Prob.: Diameter of a Binary Tree
Given a binary tree, the diameter (also known as the width) is defined as the number of edges 
on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. 
Your task is to find the diameter of the tree.
*/

class Solution {
    //initial dia and height -1 if root=null
    int diameter=-1;
    int height(Node node)
    {
        if(node==null) return -1;
        
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        
        diameter=Math.max(diameter,2+leftHeight+rightHeight);
        
        return 1 + Math.max(leftHeight,rightHeight);
    }
    int diameter(Node root) {
        // Your code here
        height(root);
        return diameter;
    }
}
