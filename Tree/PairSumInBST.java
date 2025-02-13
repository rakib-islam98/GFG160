
/*
Prob.: Pair Sum in BST
Given a Binary Search Tree(BST) and a target. Check whether there's 
a pair of Nodes in the BST with value summing up to the target. 
*/

class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        ArrayList<Integer> inorder=new ArrayList<>();
        inorderTraversal(root,inorder);
        
        int left=0,right=inorder.size()-1;
        while(left<right)
        {
            int sum=inorder.get(left)+inorder.get(right);
            if(sum==target) return true;
            else if(sum>target) right--;
            else left++;
        }
        return false;
    }
    void inorderTraversal(Node root,ArrayList<Integer> inorder)
    {
        if(root==null) return;
        inorderTraversal(root.left,inorder);
        inorder.add(root.data);
        inorderTraversal(root.right,inorder);
    }
}
