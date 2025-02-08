

/*
Prob.: Tree Boundary Traversal
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. 
You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, 
traversed in reverse order. You must prefer the right child over the left child when traversing. 
Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
*/


class Solution {
    boolean isLeaf(Node node)
    {
        return (node.left==null && node.right==null);
    }
    
    void addLeftBoundary(ArrayList<Integer> res,Node node)
    {
        if(node==null) return;
        if(!isLeaf(node)) res.add(node.data);
        
        if(node.left!=null) addLeftBoundary(res,node.left);
        else if(node.right!=null) addLeftBoundary(res,node.right);
    }
    
    void addLeaves(ArrayList<Integer> res,Node node)
    {
        if(node==null) return;
        if(isLeaf(node))
        {
            res.add(node.data);
            return;
        }
        addLeaves(res,node.left);
        addLeaves(res,node.right);
    }
    
    void addRightBoundary(ArrayList<Integer> res,Node node)
    {
        if(node==null) return;
        
        if(node.right!=null) addRightBoundary(res,node.right);
        else if(node.left!=null) addRightBoundary(res,node.left);
        
        if(!isLeaf(node)) res.add(node.data);
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        
        if(!isLeaf(node)) res.add(node.data);
        
        addLeftBoundary(res,node.left);
        addLeaves(res,node);
        addRightBoundary(res,node.right);
        
        return res;
    }
}
