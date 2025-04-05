

/*
Prob.: Find the number of islands
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.
 
Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}
*/


class Solution {
    void dfs(char[][] grid,int r,int c)
    {
        int row=grid.length;
        int col=grid[0].length;
        if(r<0||c<0||r>=row||c>=col||grid[r][c]!='L')
        {
            return;
        }
        int[] rNbr={-1,-1,-1,0,0,1,1,1};
        int[] cNbr={-1,0,1,-1,1,-1,0,1};
        
        grid[r][c] = 'w';
        
        for(int k=0;k<8;k++){
            int newR=r+rNbr[k];
            int newC=c+cNbr[k];
            
            dfs(grid,newR,newC);
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        int count=0;
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c]=='L')
                {
                    dfs(grid,r,c);
                    
                    count++;
                }
            }
        }
        return count;
    }
}
