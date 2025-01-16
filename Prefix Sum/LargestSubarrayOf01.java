
/*
Prob.: Largest subarray of 0's and 1's
Given an array arr of 0s and 1s. Find and 
return the length of the longest subarray with equal number of 0s and 1s.
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
