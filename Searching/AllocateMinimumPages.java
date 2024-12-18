/*
Prob.:Allocate Minimum Pages
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book.
You also have an integer k representing the number of students.
The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student.
In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
*/

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(k>n) return -1;
        
        //find max and total in array,
        //We do binary search as low=max and high=total
        int high=0,low=arr[0];
        for(int x:arr)
        {
            if(x>low) low=x;
            high+=x;
        }
        //O(log(sum-max+1))
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(countStudent(arr,mid)>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    //O(n)
    public static int countStudent(int[] arr,int maxPages) {
        int studentCnt=1,currPages=0;
        for(int pages:arr)
        {
            if(currPages+pages<=maxPages) currPages+=pages;
            else
            {
                studentCnt++;
                currPages=pages;
            }
        }
        return studentCnt;
    }
}
