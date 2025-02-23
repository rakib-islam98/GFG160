
/*
Prob.: Next Greater Element
Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. 
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. 
For example, next greater of the last element is always -1.
*/


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(-1);
        
        Stack<Integer> stack=new Stack<>();
        //Traverse backward
        for(int i=n-1;i>=0;i--)
        {
            //pop all the elemnts which is smaller then current in the stack
            while(!stack.isEmpty() && stack.peek()<=arr[i]) {stack.pop();}
            
            //If the satck still not empty then this is the next larger of current 
            if(!stack.isEmpty()) ans.set(i,stack.peek());
            
            //add current elemnt to the stack
            stack.push(arr[i]);
        }
        // for(int i=0;i<n;i++)
        // {
        //     ans.add(-1);
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(arr[j]>arr[i])
        //         {
        //             ans.set(i,arr[j]);
        //             break;
        //         }
        //     }
        // }
        return ans;
    }
}
