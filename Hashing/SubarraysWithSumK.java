/*
Prob.: Subarrays with sum K
Given an unsorted array of integers, 
find the number of continuous subarrays having sum exactly equal to a given number k.


*/
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int currSum=0,ans=0;
        for(int i=0;i<arr.length;i++)
        {
            currSum+=arr[i];
            if(currSum==k) ans++;
            
            if(hm.containsKey(currSum-k))
                ans+=hm.get(currSum-k);
                
            hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        }
        return ans;
    }
}
