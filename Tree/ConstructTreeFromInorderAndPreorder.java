
/*
Prob.: Construct Tree from Inorder & Preorder
Given two arrays representing the inorder and preorder traversals of a binary tree,
construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.
*/

class Solution {
    static int preInd;
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        preInd=0;
        return buildTreeHelper(hm,preorder,0,preorder.length-1);
    }
    public static Node buildTreeHelper(HashMap<Integer,Integer> hm,int preorder[],
                                        int left,int right)
    {
        //Base Case
        if(left>right) return null;
        //Recursive
        int data=preorder[preInd++];
        Node root=new Node(data);
        
        int inInd=hm.get(data);
        root.left=buildTreeHelper(hm,preorder,left,inInd-1);
        root.right=buildTreeHelper(hm,preorder,inInd+1,right);
        
        return root;
    }
}
