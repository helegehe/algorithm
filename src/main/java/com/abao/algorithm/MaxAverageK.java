package com.abao.algorithm;

public class MaxAverageK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,3,8,4};
        System.out.println(maxAverageK(arr,2));
    }

    public static int maxAverageK(int [] arr,int k){
        int left = 0;
        int right = k - 1;
        int maxAve = Integer.MIN_VALUE;
        while (right < arr.length){
            int total = 0;
            for(int i = left;i<=right;i++){
                total += arr[i];
            }
            if (maxAve < total/k){
                maxAve = total/k;
            }
            left ++ ;
            right ++ ;
        }
        return maxAve;
    }

}
