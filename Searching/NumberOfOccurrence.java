/*
Prob.-
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[].
*/

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first=firstOccurrence(arr,target);
        if(first==-1) return 0;
        int last=lastOccurrence(arr,target);
        return last-first+1;
    }
    
    int firstOccurrence(int[] arr, int target) {
        int l=0,h=arr.length-1;
        int first=-1;
        while(l<=h) {
            int mid=l+(h-l)/2;
            if(arr[mid]==target) {
                first=mid;
                //search for earlier occurrence before mid
                h=mid-1;
            }
            else if(target<arr[mid]) h=mid-1;
            else l=mid+1;
        }
        return first;
    }
    
    int lastOccurrence(int[] arr, int target) {
        int l=0,h=arr.length-1;
        int last=-1;
        while(l<=h) {
            int mid=l+(h-l)/2;
            if(arr[mid]==target) {
                last=mid;
                //search for last occurrence after mid
                l=mid+1;
            }
            else if(target<arr[mid]) h=mid-1;
            else l=mid+1;
        }
        return last;
    }
}
