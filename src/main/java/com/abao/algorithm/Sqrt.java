package com.abao.algorithm;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrtBisection(25));
        System.out.println(sqrtBisection(12));
    }

    public static int sqrtN(int n){
        int sqrt = 1;
        for(int i=1;i<=n ;i++){
            if (i*i>n){
                return sqrt;
            }
            sqrt = i;
        }
        return sqrt;
    }

    public static int sqrtBisection(int n){
        int sqrt = 1;
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (mid * mid <= n){
                sqrt = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return sqrt;
    }
}
