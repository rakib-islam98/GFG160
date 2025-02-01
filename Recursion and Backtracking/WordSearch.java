

/*
Prob.: Word Search
You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. 
Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells,
either horizontally or vertically. The same cell cannot be used more than once.
*/

class Solution {
    
    static public boolean findWord(char mat[][],String word,int row,int col,int i,int j,int idx)
    {
        //Base Case
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i>=row || j>=col || mat[i][j]!=word.charAt(idx)) return false; 
        //Recursive Calling
        char temp=mat[i][j];
        mat[i][j]='#';
        if(findWord(mat,word,row,col,i+1,j,idx+1) || findWord(mat,word,row,col,i-1,j,idx+1)
          || findWord(mat,word,row,col,i,j+1,idx+1) || findWord(mat,word,row,col,i,j-1,idx+1))
           return true;
        mat[i][j]=temp;
        
        return false;
    }
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int row=mat.length;
        int col=mat[0].length;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==word.charAt(0))
                {
                    if(findWord(mat,word,row,col,i,j,0)) return true;
                }
            }
        }
        return false;
    }
}
