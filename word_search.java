/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
*/
import java.util.*;
class word_search{
    static int[] diff=new int[]{0,1,0,-1,0};
    static boolean dfs(char[][] grid,int R,int C,int row,int col,int idx,String word){
        if(idx==word.length()-1) return true;
        grid[row][col]='.';
        for(int i=0;i<4;i++){
            int ar=row+diff[i],ac=col+diff[i+1];
            if(ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac]==word.charAt(idx+1)){
                boolean fnd=dfs(grid,R,C,ar,ac,idx+1,word);
                if(fnd) return true;
            }
        }
        return false;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        char[][] grid=new char[R][C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                grid[row][col]=sc.next().charAt(0);
            }
        }
        // sc.next();
        String word=sc.next();
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==word.charAt(0)){
                   boolean res=dfs(grid,R,C,row,col,0,word);
                   System.out.println(res);
                   return;
                }
            }
        }
    }
}