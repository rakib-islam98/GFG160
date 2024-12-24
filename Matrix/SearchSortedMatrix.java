/*
prob.:Search in a sorted Matrix
Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, 
and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.
*/

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n=mat.length,m=mat[0].length;
        int l=0,h=(n*m)-1;
        
        while(l<=h) {
            int mid=l+(h-l)/2;
            int row=mid/m;
            int col=mid%m;
            
            if(x==mat[row][col]) return true;
            else if(x<mat[row][col]) h=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
