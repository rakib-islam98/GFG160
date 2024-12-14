/*
Prob.: Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
*/

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int low=0,high=arr.length-1;
        while(low<=high) 
        {
            int mid=low+(high-low)/2;
            //Our strategy will be find the sorted half and do binary search
            if(arr[mid]==key) return mid;
            //Find the sorted half 
            //If left half is sorted
            if(arr[low]<=arr[mid])
            {
                //if key is in the left sorted half
                if(key>=arr[low] && key<arr[mid]) high=mid-1;
                //else go to the right unsorted half
                else low=mid+1;
            }
            //Else if right half is sorted
            else
            {
                //If key is in right sorted half
                if(key>arr[mid] && key<=arr[high]) low=mid+1;
                //else go to the left unsorted half
                else high=mid-1;
            }
        }
        return -1;
    }
}
