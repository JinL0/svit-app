package com.svit.java.algorithm;

public class leetcode200 {
    private int row;
    private int column;
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        for(int i = 0; i < row; i++){
            for (int j = 0; i < column; j++){
                if(grid[i][j] == '1'){
                    dfstraversal(grid, i, j);
                    count+=1;
                }
            }
        }

        return 0;
    }
    private void dfstraversal(char[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j]=='1'){
            grid[i][j]= '0';
            dfstraversal(grid, i-1, j);
            dfstraversal(grid, i, j-1);
            dfstraversal(grid, i+1, j);
            dfstraversal(grid, i, j+1);
        } else {
            return;
        }
    }

}
