package com.abao.algorithm;

public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println(getPrime(100));
    }

    public static int getPrime(int n){
        int total = 0;
        for (int k = 2;k<n;k++){ // n
            total += isPrime(k)?1:0;
        }
        return total;
    }
    public static boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){ // num
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
