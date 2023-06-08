package com.abao.algorithm;

public class MaxK {
    public static void main(String[] args) {
        System.out.println(maxK(10));
        System.out.println(maxKWithHalf(10));
    }

    public static int maxK(int k){
        int used = 0;
        for(int i = 1;i<k;i++){
            if(k - used == i){
                return i;
            }
            if ( k -used <i){
                return i - 1;
            }
            used += i;
        }
        return -1;
    }

    public static int maxKWithHalf(int k){
        int left = 0;
        int right = k;
        while (left <= right){
            int mid = left + (right - left)/2;
            int total = mid * (mid + 1)/2;
            if (total == k){
                return mid;
            }
            if (total < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
}
