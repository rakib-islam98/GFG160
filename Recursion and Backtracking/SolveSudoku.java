
/*
Prob.: Solve the Sudoku
Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, 
mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.
*/


class Solution {
    // Function to find a solved Sudoku.
    static boolean solveSudokuHelper(int mat[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(mat[i][j]==0)
                {
                    for(int num=1;num<=9;num++)
                    {
                        if(isSafe(mat,i,j,num))
                        {
                            mat[i][j]=num;
                            if(solveSudokuHelper(mat)) return true;
                            //backtrack
                            mat[i][j]=0;
                        }
                    }
                    //if no number is safe
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isSafe(int mat[][],int i,int j,int num)
    {
        //check row & col
        for(int x=0;x<9;x++)
        {
            if(mat[i][x]==num || mat[x][j]==num) return false;
        }
        //check each 3*3 grid
        int sr=i-i%3;
        int sc=j-j%3;
        for(int row=0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                if(mat[sr+row][sc+col]==num) 
                    return false;
            }
        }
        return true;
    }
    
    static void solveSudoku(int[][] mat) {
        // code here
        solveSudokuHelper(mat);
    }
}
