package com.abao.algorithm;

import java.util.Arrays;

public class MaxMultiply {
    public static void main(String[] args) {
        int []n = new int[]{2,-1,3,4,5};
        int []n1 = new int[]{2,1,3,4,5};
        int []n2 = new int[]{-2,-1,-3,-4,-5};
        System.out.println(maxMultitpy1(n));
        System.out.println(maxMultitpy1(n1));
        System.out.println(maxMultitpy1(n2));
    }

    public static int maxMultiply(int[] n){
        int rt = Integer.MIN_VALUE;
        Arrays.sort(n);
        rt = Math.max(n[n.length-1]*n[n.length-2]*n[n.length-3],n[n.length-1]*n[0]*n[1]);
        return rt;
    }

    public static int maxMultitpy1(int[]n){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0;i<n.length;i++){
            if(n[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = n[i];
            }else if(n[i] > max2){
                max3 = max2;
                max2 = n[i];
            }else if(n[i] > max3){
                max3 = n[i];
            }
            if (n[i]<min1){
                min2 = min1;
                min1 = n[i];
            }else if(n[i]<min2){
                min2 = n[i];
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }
}
