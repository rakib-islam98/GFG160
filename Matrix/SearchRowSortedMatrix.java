/*
Search in a row-wise sorted matrix
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].
*/

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for(int[] row:mat) {
            if(bSearch(row,x)) 
                return true;
        }    
        return false;
    }
    
    public boolean bSearch(int[] row,int x) {
        int l=0;
        int h=row.length-1;
        
        while(l<=h) {
            
            int mid=l+(h-l)/2;
            
            if(x==row[mid]) return true;
            else if(x>row[mid]) l=mid+1;
            else h=mid-1;
        }
        return false;
    }
}
