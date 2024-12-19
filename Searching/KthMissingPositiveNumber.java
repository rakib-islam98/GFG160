/*
Prob.: Kth Missing Positive Number in a Sorted Array
Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[]
*/

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        //Brute Force-O(n)
        // if(arr[0]>k) return k;
        // for(int i=0;i<arr.length;i++)
        // {
        //     if(arr[i]<=k) k++;
        //     else break;
        // }
        // return k;
        //Optimal using binary search-O(log n)
        int l=0,h=arr.length-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid]-(mid+1) < k) l=mid+1;
            else h=mid-1;
        }
        return l+k; //or h+1+k;
    }
}
