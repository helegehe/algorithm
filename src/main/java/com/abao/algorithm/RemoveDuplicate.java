package com.abao.algorithm;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,4,5};
        System.out.println(removeDup(arr));
    }

    public static int removeDup(int[] arr){
        int flag = 0;
        for(int j=1;j<arr.length;j++){
            if (arr[j] != arr[flag]){
                flag ++;
                arr[flag] = arr[j];
            }
        }
        return flag+1;
    }
}
