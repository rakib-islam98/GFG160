
/*
Prob.: Maximum of minimum for every window size
Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, 
where the window size ranges from 1 to arr.size().

More formally, for each window size k, determine the smallest element in all windows of size k, 
and then find the largest value among these minimums where 1<=k<=arr.size().
*/


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n=arr.length;
        int[] nextSmaller=new int[n];
        int prevSmaller[]=new int[n];
        int window[]=new int[n+1];
        
        computeNextSmaller(arr,n,nextSmaller);
        computePrevSmaller(arr,n,prevSmaller);
        
        for(int i=0;i<n;i++)
        {
            int windowSize=nextSmaller[i]-prevSmaller[i]-1;
            window[windowSize]=Math.max(window[windowSize],arr[i]);
        }
        
        for(int i=n-1;i>=1;i--)
        {
            window[i]=Math.max(window[i],window[i+1]);
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            result.add(window[i]);
        }
        
        return result;
    }
    
    private void computeNextSmaller(int[] arr,int n,int[] nextSmaller)
    {
        Stack<Integer> stack=new Stack<>();
        Arrays.fill(nextSmaller,n);
        
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()]> arr[i])
                nextSmaller[stack.pop()]=i;
            stack.push(i);
        }
    }
    
    private void computePrevSmaller(int[] arr,int n,int[] prevSmaller)
    {
        Stack<Integer> stack=new Stack<>();
        Arrays.fill(prevSmaller,-1);
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()]> arr[i])
                prevSmaller[stack.pop()]=i;
            stack.push(i);
        }
    }
}
