
/*
Prob.: K Sum Paths
Given a binary tree and an integer k, determine the number of downward-only paths 
where the sum of the node values in the path equals k. A path can start and end at 
any node within the tree but must always move downward (from parent to child).
*/


//Wrapper class
class Counter
{
    int val=0;
}
class Solution {
    int currSum=0;
    
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        Counter cnt=new Counter();
        sumKHelper(root,k,hm,cnt);
        return cnt.val;
    }
    public void sumKHelper(Node root,int k,HashMap<Integer,Integer> hm,Counter cnt)
    {
        if(root==null) return;
        
        currSum+=root.data;
        if(currSum==k) cnt.val++;
        if(hm.containsKey(currSum-k)) cnt.val+=hm.get(currSum-k);
        
        hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        
        sumKHelper(root.left,k,hm,cnt);
        sumKHelper(root.right,k,hm,cnt);
        
        hm.put(currSum,hm.get(currSum)-1);
        currSum-=root.data;
    }
}
