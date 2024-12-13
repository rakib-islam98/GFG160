/*
Prob.: A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 
*/

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        // int j=arr.length-2;                                                                                                      ;
        // while(j>=0)
        // {
        //     if(arr[j]<=arr[j+1])
        //     {
        //         j--;
        //     }
        //     else break;
        // }
        // return arr[j+1];
        int l=0,h=arr.length-1;
        
        while(l<h)
        {
            if(arr[l]<arr[h]) return arr[l];
            int mid=l+(h-l)/2;
            if(arr[mid]>arr[h]) l=mid+1;
            else h=mid;
        }
        return arr[l];
    }
}
