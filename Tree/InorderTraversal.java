
/*
Prob.: Inorder Traversal
Given a Binary Tree, your task is to return its In-Order Traversal.

An inorder traversal first visits the left child (including its entire subtree),
then visits the node, and finally visits the right child (including its entire subtree).
*/


class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> ans=new ArrayList<>();
        inOrderHelper(root,ans);
        return ans;
    }
    void inOrderHelper(Node root,ArrayList<Integer> ans)
    {
        if(root==null) return;
        inOrderHelper(root.left,ans);
        ans.add(root.data);
        inOrderHelper(root.right,ans);
    }
}
