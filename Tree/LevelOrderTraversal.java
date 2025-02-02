
/*
Prob.: Level order traversal
Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.
*/

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            ArrayList<Integer> currLevel=new ArrayList<>();
            int len=queue.size();
            for(int i=0;i<len;i++)
            {
                Node temp=queue.remove();
                currLevel.add(temp.data);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
