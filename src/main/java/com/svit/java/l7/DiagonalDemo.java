package com.svit.java.l7;
import java.util.*;

public class DiagonalDemo {
    private List<List<Integer>> diagonalTraversal(int[][] matrix){
        List<List<Integer>>  result =  new ArrayList<>();
        int n = 0;
        int m = 0;
        int N = matrix.length;
        ArrayList<Integer> sublist = new ArrayList<>();
        /**
        for(int i = 0; i < N * N; i++){
            sublist.add(matrix[n][m]);
            //System.out.printf("%d %d\n", n, m);
            if( m == 0 &&  n !=  N - 1){
                m = n + 1;
                n = 0;
                result.add((ArrayList<Integer>) sublist.clone());
                sublist.clear();
            } else if (n==N - 1) {
                n = m + 1;
                m = N - 1;
                result.add((ArrayList<Integer>) sublist.clone());
                sublist.clear();
            }else{
                n += 1;
                m -= 1;
            }
        }**/
        while (n + m < 2 * N - 1){
             //sublist.add(matrix[n][m]);
              /**
             //Zigzag
             if( (n + m) % 2 == 0){
                sublist.add(matrix[n][m]);
             } else {
                sublist.add(0, matrix[n][m]);
             }**/
            if( m == 0 &&  n !=  N - 1){
                m = n + 1;
                n = 0;
                result.add((ArrayList<Integer>) sublist.clone());
                sublist.clear();
            } else if (n==N - 1) {
                n = m + 1;
                m = N - 1;
                result.add((ArrayList<Integer>) sublist.clone());
                sublist.clear();
            }else{
                n += 1;
                m -= 1;
            }
        }
        return result;

    }

    public static void main(String args[]){
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        DiagonalDemo dd = new DiagonalDemo();
        List<List<Integer>> sol = dd.diagonalTraversal(matrix);
        for(int i = 0; i < sol.size(); i++){
            List<Integer> subList = sol.get(i);
            System.out.println(subList);
            //System.out.printf("\n");
        }

    }
}
