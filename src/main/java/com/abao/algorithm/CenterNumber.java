package com.abao.algorithm;

import java.util.Arrays;

public class CenterNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,2,4};
        System.out.println(centerNumber(arr));
    }

    public static int centerNumber(int[] arr){
        int totalRight = Arrays.stream(arr).sum();
        int totalLeft = 0;
        for(int i = 0;i<arr.length;i++){
            totalLeft += arr[i];
            if (totalLeft == totalRight){
                return i;
            }
            totalRight -= arr[i];
        }
        return -1;
    }
}
