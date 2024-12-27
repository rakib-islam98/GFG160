/*
Prob.: Count pairs with given sum
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.
*/

class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        int cnt=0;
        for(int i=0;i<arr.length;i++)
        {
            int rem=target-arr[i];
            if(hm.containsKey(rem)) cnt+=hm.get(rem);
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        return cnt;
    }
}
