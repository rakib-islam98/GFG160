
/*
Prob.: Indexes of Subarray Sum
Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray 
(a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost 
and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].
*/

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int sum=0;
        int left=0,right=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum>=target)
            {
                right=i;
                while(sum>target && left<right)
                {
                    sum-=arr[left];
                    left++;
                }
                if(sum==target)
                {
                    ans.add(left+1);
                    ans.add(right+1);
                    return ans;
                }
            }
        }
        ans.add(-1);
        return ans;
    }
}
