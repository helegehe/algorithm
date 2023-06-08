package com.abao.algorithm;

public class Icecream {
    public static void main(String[] args) {
        int[] arr = new int[]{5,5,20,20};
        System.out.println(charge(arr));
        System.out.println("finish");
    }

    public static boolean charge(int [] arr){
        boolean charge = true;
        int five = 0;
        int ten = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 5){
                five ++ ;
            }
            if (arr[i] == 10 ){
                if(five  > 0){
                    five -- ;
                    ten ++ ;
                }else{
                    return false;
                }
            }
            if(arr[i] == 20){
                if (ten > 0 && five >0){
                    ten -- ;
                    five --;
                }else if (five > 2){
                    five = five - 2;
                }else{
                    return false;
                }
            }
        }
        return charge;
    }
}
