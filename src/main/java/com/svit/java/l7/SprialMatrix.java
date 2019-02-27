package com.svit.java.l7;
import java.util.*;

public class SprialMatrix {
    public List<List<Integer>> spiralOrder(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null){
            return result;
        }
        int bottom = matrix.length-1;
        int top = 0;
        int left = matrix[0].length-1;
        int right = 0;
        while(true){
            List<Integer> sublist = new ArrayList<>();
            for(int i = right; i <= left; i++) sublist.add(matrix[top][i]);
            result.add(sublist);
            //if(top==bottom) break;
            top = top + 1;
            //System.out.printf("%d, %d, %d, %d\n", left, right);
            for(int i = top; i <= bottom; i++) sublist.add(matrix[i][left]);
            //if(left == right) break;
            left= left - 1;
            //System.out.printf("%d, %d\n", left, right);
            for(int i = left; i >= right; i--) sublist.add(matrix[bottom][i]);
            if(top==bottom) break;
            bottom -=1;

            for(int i = bottom; i >= top; i--) sublist.add(matrix[i][right]);
            if(left == right) break;
            right += 1;
        }

        return result;

    }
    public static void main(String args[]){
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        SprialMatrix dd = new SprialMatrix();
        List<List<Integer>> sol = dd.spiralOrder(matrix);
        for(int i = 0; i < sol.size(); i++){
            List<Integer> subList = sol.get(i);
            System.out.println(subList);
            //System.out.printf("\n");
        }

    }
}
