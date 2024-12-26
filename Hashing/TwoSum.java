/*
Prob.: Two Sum - Pair with Given Sum
Given an array arr[] of positive integers and another integer target. 
Determine if there exists two distinct indices such that the sum of there elements is equals to target.
*/

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            int rem=target-arr[i];
            if(hm.containsKey(rem)) return true;
            else hm.put(arr[i],i);
        }
        return false;
    }
}
