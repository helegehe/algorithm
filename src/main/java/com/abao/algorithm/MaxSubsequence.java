package com.abao.algorithm;

public class MaxSubsequence {
    public static void main(String[] args) {
        int []arr = new int[]{3,1,5,1,4,3};
        System.out.println(maxSub(arr));
        System.out.println("finish");
    }

    public static int maxSub(int[] arr){
        int max = 0;
        int start = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] < arr[i-1] ){
                max = Math.max(i - start  ,max);
                start = i;
            }
            if ( i == arr.length -1 && arr[i] > arr[i-1]){
                max = Math.max(i - start + 1  ,max) ;
            }
        }
        return max;
    }
}
