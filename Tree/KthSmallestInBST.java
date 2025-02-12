

/*
Prob.: k-th Smallest in BST
Given a BST and an integer k, the task is to find the kth smallest element in the BST. 
If there is no kth smallest element present then return -1.
*/


class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        Node curr=root;
        int cnt=0;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                cnt++;
                if(cnt==k) return curr.data;
                curr=curr.right;
            }
            else
            {
                Node prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                else if(prev.right==curr)
                {
                    prev.right=null;
                    cnt++;
                    if(cnt==k) return curr.data;
                    curr=curr.right;
                }
            }
        }
        return -1;
        // ArrayList<Integer> inorderList=new ArrayList<>();
        // inorderTraversal(root,inorderList);
        
        // if(k>inorderList.size()) return -1;
        // return inorderList.get(k-1);
    }
    // public void inorderTraversal(Node root,ArrayList<Integer> inorderList)
    // {
    //     if(root==null) return;
    //     inorderTraversal(root.left,inorderList);
    //     inorderList.add(root.data);
    //     inorderTraversal(root.right,inorderList);
    // }
}
