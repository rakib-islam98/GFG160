/*
Prob.: Count distinct elements in every window
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
*/

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<k;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        ans.add(hm.size());
        for(int i=k;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            hm.put(arr[i-k],hm.get(arr[i-k])-1);
            if(hm.get(arr[i-k])==0)
                hm.remove(arr[i-k]);
            ans.add(hm.size());
        }
        return ans;
    }
}
