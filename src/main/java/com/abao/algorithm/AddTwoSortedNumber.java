package com.abao.algorithm;

import java.util.HashMap;
import java.util.Map;

public class AddTwoSortedNumber {
    public static void main(String[] args) {
        int []n = new int[]{1,3,4,5,7};
        int[] rt = halfWithTwoPoint(n,11);
        System.out.println(rt[0]);
        System.out.println(rt[1]);
    }

    public static int[]half(int [] n,int total){
        int [] rt = new int[]{-1,-1};
        int left = 0;
        int right = n.length -1;
        while (left < right){
            int mid = left + (right -left)/2;
            if(n[left] + n[right] == total){
                rt[0] = left;
                rt[1] = right;
                break;
            }
            if(n[left] + n[right] < total){
                left = mid ;
            }else{
                right = mid ;
            }
        }
        return rt;
    }


    public static int[]halfWithTwoPoint(int [] n,int total){
        int [] rt = new int[]{-1,-1};
        int left = 0;
        int right = n.length -1;
        while (left < right){
            if(n[left] + n[right] == total){
                rt[0] = left;
                rt[1] = right;
                break;
            }
            if(n[left] + n[right] < total){
                left ++ ;
            }else{
                right -- ;
            }
        }
        return rt;
    }
}
