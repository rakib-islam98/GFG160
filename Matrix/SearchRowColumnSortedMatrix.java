/*
Prob.:Search in a Row-Column sorted matrix
Given a 2D integer matrix mat[][] of size n x m, 
where every row and column is sorted in increasing order and a number x, 
the task is to find whether element x is present in the matrix.
*/

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n=mat.length;
        int m=mat[0].length;
        // Start from the top-right corner
        int row = 0, col = m - 1;
        
        while (row < n && col >= 0) {
            
            if (mat[row][col] == x) {
                return true; // Found the element
            } 
            else if (mat[row][col] > x) {
                col--; // Move left
            } 
            else {
                row++; // Move down
            }
        }
        return false; // Element not found
    }
}
