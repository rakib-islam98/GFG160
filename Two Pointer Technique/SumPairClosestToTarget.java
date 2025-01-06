/*
Prob.: Sum Pair closest to target
Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
*/

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        
        List<Integer> ans=new ArrayList<Integer>();
        int diff=Integer.MAX_VALUE;
        while(i<j)
        {
            int sum=arr[i]+arr[j];
            //keeping track of pair which sum is not equal to target but closest one
            if(Math.abs(sum-target)<diff)
            {
                diff=Math.abs(sum-target);
                ans=Arrays.asList(arr[i],arr[j]);
            }
            //Checking is there any pair with sum exactly equal to target
            if(sum<target) i++;
            else if(sum>target) j--;
            else
                return ans;
        }
        return ans;
    }
}
