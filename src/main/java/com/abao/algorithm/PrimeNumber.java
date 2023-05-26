package com.abao.algorithm;

public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println(eFilter(100));
//        System.out.println(getPrime(100));
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

    public static int eFilter(int n){
        int total = 0;
        boolean[]filters = new boolean[n]; // false代表是素数
        for(int i =2;i<n;i++){
            if (!filters[i]){
                total++;
                for(int j=i*i;j<n;j+=i){
                    filters[j] = true;
                }
            }
        }
        return total;
    }
}
