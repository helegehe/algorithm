package com.abao.algorithm;

public class MergeArray {
    public static void main(String[] args) {
        int[]arr1= new int[]{1,3,5,0,0};
        int[]arr2= new int[]{2,4};
        arr1 = merge(arr1,3,arr2,2);
        System.out.println(arr1);
    }

    public static int[] merge(int[] arr1,int m,int []arr2,int k){
        int p1 = m  - 1;
        int p2 = k - 1 ;
        int current = m + k -1;
        while (p1 >= 0 && p2 >=0){
            if (arr1[p1] > arr2[p2]){
                arr1[current] = arr1[p1];
                p1 --;
            }else{
                arr1[current] = arr2[p2];
                p2 --;
            }
            current -- ;
        }
        while (p2 >= 0){
            arr1[current] = arr2[p2];
            p2 --;
            current -- ;
        }
        return arr1;
    }
}
