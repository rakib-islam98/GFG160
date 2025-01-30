
/*
Prob.: N-Queen Problem
The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other.
Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements,
where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, 
the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].

*/


class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> soln=new ArrayList<>();
        
        boolean checkRow[]=new boolean[n+1];
        boolean checkDiag1[]=new boolean[2*n+1];
        boolean checkDiag2[]=new boolean[2*n+1];
        
        nQueenSolver(1,n,checkRow,checkDiag1,checkDiag2,ans,soln);
        return ans;
    }
    public void nQueenSolver(int col,int n,boolean checkRow[],boolean checkDiag1[],
                boolean checkDiag2[],ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> soln)
    {
        //if at any moment if soln. complete add it to ans
        if(col>n)
        {
            ans.add(new ArrayList<>(soln));
            return;
        }
        //for each column check safety of queen
        for(int row=1;row<=n;row++)
        {
            if(!checkRow[row] && !checkDiag1[row+col] && !checkDiag2[row-col+n])
            {
                //add the safe row for each col
                checkRow[row]=checkDiag1[row+col]=checkDiag2[row-col+n]=true;
                soln.add(row);
                //check for 2nd col
                nQueenSolver(col+1,n,checkRow,checkDiag1,checkDiag2,ans,soln);
                //backtrack
                soln.remove(soln.size()-1);
                checkRow[row]=checkDiag1[row+col]=checkDiag2[row-col+n]=false;
            }
        }
    }
}
