package com.abao.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Province {
    public static void main(String[] args) {
        int[][]city1= new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][]city2= new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int[][]city3= new int[][]{{1,1,0,0,0,0,0,0,0,0},{1,1,1,1,0,0,0,0,0,0},{0,2,1,0,0,0,0,0,0,0},{0,1,0,0,1,0,0,0,0,0},{0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,0,0},{0,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,1,0,1,1,0},{0,0,0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0,0,1}};
//        System.out.println(wf(city1));
//        System.out.println(wf(city2));
        System.out.println(wf(city3));
    }

    public static int cityNum(int[][]city){
        int numCity = city.length;
        boolean [] visited  = new boolean[numCity];
        int province = 0;
        // 从第一个城市开始遍历
        for(int i = 0;i<numCity;i++){
            // 第一个没有遍历过的城市肯定属于一个省份
            if (!visited[i]){
                province ++;
                df(city,i,numCity,visited); // 这里用深度优先遍历算法把和第i个城市连接的城市找出来，剩下的机visited[]值为false
            }
        }
        return province;
    }

    // 深度优先
    private static void df(int[][] city, int i,int numCity, boolean[] visited) {
        for(int j = 0;j<numCity;j++){
            if(city[i][j] == 1 && !visited[j]){
                visited[j] = true;
                df(city,j,numCity,visited);
            }
        }
    }

    // 广度优先
    private static int wf(int[][] city) {
        int numCity = city.length;
        boolean [] visited  = new boolean[numCity];
        int province = 0;
        // 从第一个城市开始遍历
        for(int i = 0;i<numCity;i++){
            Queue<Integer> queue = new LinkedList<>();
            if(!visited[i]){
                queue.add(i);
                province ++ ;
            }
            // 次轮循环能够根据广度优先算法，把和第i个城市相连的所有城市全部找出来
            while (!queue.isEmpty()){
                int k = queue.poll(); // 从队头弹出一个城市，继续判断和此城市直接相连的城市
                for(int j = k;j<numCity;j++){   // 依次判断和第k个城市直接相连的城市，并且入队列 。因为前面已经判断过k-1和j是否相连了，所以这里直接从k开始
                    if(city[k][j] == 1 && !visited[j]){
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        return province;
    }

}
