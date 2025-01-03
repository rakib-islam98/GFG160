/*
Prob.: Count Subarrays with given XOR
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.
*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> hm =new HashMap<>();
        int currXor=0,res=0;
        for(int x:arr)
        {
            currXor^=x;
            if(currXor==k) res++;
            if(hm.containsKey(currXor^k))
                res+=hm.get(currXor^k);
            hm.put(currXor,hm.getOrDefault(currXor,0)+1);
        }
        return res;
    }
}
