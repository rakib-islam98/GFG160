/*
Prob.: Spirally traversing a matrix
You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.
*/

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        int n=mat.length,m=mat[0].length;
        int cnt=n*m;
        int left=0,top=0,right=m-1,bottom=n-1;
        
        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
                ans.add(mat[top][i]);
            top++;
            
            for(int i=top;i<=bottom;i++)
                ans.add(mat[i][right]);
            right--;
            
            //We need condition whike backward traversing
            if(top<=bottom)
                for(int i=right;i>=left;i--)
                    ans.add(mat[bottom][i]);
            bottom--;
            
            if(left<=right)
                for(int i=bottom;i>=top;i--)
                    ans.add(mat[i][left]);
            left++;
        }
        return ans;
    }
}
