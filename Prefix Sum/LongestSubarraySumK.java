
/*
Prob.: Longest Subarray with Sum K
Given an array arr[] containing integers and an integer k, your task is to find the length 
of the longest subarray where the sum of its elements is equal to the given value k.
If there is no subarray with sum equal to k, return 0.
*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxLength=0,sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==k) maxLength=i+1;
            if(hm.containsKey(sum-k)) 
                maxLength=Math.max(maxLength,i-hm.get(sum-k));
            hm.putIfAbsent(sum,i);
        }
        return maxLength;
    }
}
