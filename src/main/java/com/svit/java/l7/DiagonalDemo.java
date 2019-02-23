package com.svit.java.l7;

public class DiagonalDemo {
    private int[] diagonalTraversal(int[][] matrix){
        int[] result = new int[matrix.length * matrix.length];
        int n = 0;
        int m = 0;
        int N = matrix.length;

        for(int i = 0; i < result.length; i++){
            result[i] = matrix[n][m];
            //System.out.printf("%d %d", n, m);
            if(N - n > 0 && N - m > 0) {
                result[N * N - i - 1] = matrix[N - n - 1][N - m - 1];
            }
            if( m + 1 == N) break;
            else if (n == 0) {
                n = m + 1;
                m = 0;
            }else{
                n -= 1;
                m += 1;
            }
        }
        return result;

    }

    public static void main(String args[]){
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        DiagonalDemo dd = new DiagonalDemo();
        int[] sol = dd.diagonalTraversal(matrix);
        for(int i = 0; i < sol.length; i++){
            System.out.println(sol[i]);
        }

    }
}
