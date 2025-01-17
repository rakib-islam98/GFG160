
/*
Prob.: Product array puzzle
Given an array, arr[] construct a product array, res[] where each element in res[i]
is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.
*/

//It also can be solved using prefix product and suffix product
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length;
        int totalProduct=1;
        int noOfZeroes=0,index=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                noOfZeroes++;
                index=i;
            }
            else totalProduct*=arr[i];
        }
        int ans[]=new int[n];
        if(noOfZeroes==0)
        {
            for(int i=0;i<n;i++)
            {
                ans[i]=totalProduct/arr[i];
            }
        }
        if(noOfZeroes==1)
        {
            ans[index]=totalProduct;
        }
        return ans;
    }
}
