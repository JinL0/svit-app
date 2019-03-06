package com.svit.java.algorithm;
import java.lang.Math;

public class FindNth12 {
    private static String findNthelement(int n){
        StringBuilder sb = new StringBuilder();
        if(n==0) {
            sb.insert(0, "1");
            return sb.toString();
        }
        return herlper(n, sb);
    }

    private static String herlper(int n, StringBuilder sb){
        if(n<=0){
            return sb.toString();
        }
        int level = findLevel(n);
        //System.out.printf("level: %d\n", level);
        int posi;
        if(level < 1){
            posi = n;
        } else {
            posi = n - (int) (Math.pow(2.0, (double) level));
        }
        //int posi = n - (1 << level);
        System.out.printf("posi: %d\n", posi);
        if(posi % 2 ==0){
            sb.insert(0, "1");
        }
        if(posi % 2 ==1){
            sb.insert(0, "2");
        }
        if(level <= 1){
            n = posi/2;
        } else {
            n = (int) (Math.pow(2.0, (double) level - 1)) + posi/2;
        }
        //System.out.println(n);
        return herlper(n, sb);
    }

    private static int findLevel(int n){
        for(int i = 0; i < n; i++){
           int upper = (int) (Math.pow(2.0, (double) i+2)) - 2;
           //System.out.println(upper);
           if(n < upper){
               return i;
           }
        }
        return n;
    }


    public static void main(String[] args) {
        System.out.println(findNthelement(100));
    }


}
