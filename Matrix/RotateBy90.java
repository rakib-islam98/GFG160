/*
prob.:Rotate by 90 degree
Given a square matrix mat[][] of size n x n. 
The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 
*/

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        int n=mat.length;
        for(int i=0;i<n;i++)
        {
            reverse(mat[i],0,n-1);
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
    static void reverse(int arr[],int l,int h) {
        while(l<h)
        {
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;h--;
        }
    }
}
