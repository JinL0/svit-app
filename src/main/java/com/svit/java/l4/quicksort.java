package com.svit.java.l4;
//Demo LinkedList
import java.util.*;

class quicksort{
    Random rand = new Random();
    public void quicksort(int[] a){
        if(a == null){
            return;
        }
        quicksorthelper(a, 0, a.length - 1);

    }

    public void quicksorthelper(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = findpivot(a, left, right);
        quicksorthelper(a, left, pivot - 1);
        quicksorthelper(a, pivot + 1, right);

    }

    public int findpivot(int[] a, int left, int right){
        int n = rand.nextInt((right- left) + 1) + left;
        swap(a, n, right);
        int pivot = a[right];
        int i = left;
        for(int k = right; k < left; k++){
            if(a[k] <= pivot){
                i++;
                swap(a, i, k);
            }
        }
        swap(a, i + 1, left);
        return i + 1;

    }
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(){
        int[] a = new int[]{1, 4, 5, 53, 16, 6, 51,7};

    }
}