package com.abao.algorithm;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumber {
    public static void main(String[] args) {
        int []n = new int[]{4,1,3,5,7};
        int[] rt = totalWithMap(n,11);
        System.out.println(rt[0]);
        System.out.println(rt[1]);
    }

    public static int[]total(int [] n,int total){
        int [] rt = new int[]{-1,-1};
        for(int i =0;i<n.length - 1;i++){
            for(int j = i+1;j<n.length;j++){
                if (total == n[i] + n[j]){
                    rt[0] = i;
                    rt[1] = j;
                    break;
                }
            }
        }
        return rt;
    }

    public static int[] totalWithMap(int[]n,int total){
        Map<Integer,Integer> info = new HashMap<Integer,Integer>();
        int[] rt = new int[]{-1,-1};
        for(int i=0;i<n.length;i++){
            if(info.containsKey(total-n[i])){
                rt[0] = i;
                rt[1] = info.get(total-n[i]);
                break;
            }
            info.put(n[i],i);
        }
        return rt;
    }
}
