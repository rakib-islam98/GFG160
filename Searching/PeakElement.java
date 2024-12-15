class Solution {

    public int peakElement(int[] arr) {
        // code here
        int n=arr.length;
        //If only one element
        if(n==1) return 0;
        
        //if a number is smaller than its right adjacent,then it is sure
        //that there exist a peak on the right side,why??
        //bcz if all the elements on the right side is in increasing order then
        //the last element is peak. eg: 1,2,3,4,5,-inf(5 is peak)
        //if in unsorted order then where order breaks 
        //i.e., arr[i]<arr[i+1] breaks, that is peak eg: 1,2,5,3,4,9(5 is peak)
        //same is true for left part 
        
        //First check the 1st and last, is it peak?
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;
        
        int l=0,h=n-2;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            //Check if mid is peak
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
            //if mid is not peak,check whether the peak may exist in right or left
            else if(arr[mid]<arr[mid+1]) l=mid+1;
            else h=mid-1;
        }
        return 0;
    }
}
