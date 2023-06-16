package com.abao.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Province {
    public static void main(String[] args) {
        int[][]city1= new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][]city2= new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int[][]city3= new int[][]{{1,1,0,0,0,0,0,0,0,0},{1,1,1,1,0,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0},{0,1,0,0,1,0,0,0,0,0},{0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,0,0},{0,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,1,0,1,1,0},{0,0,0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0,0,1}};
//        System.out.println(joinSearch(city1));
//        System.out.println(joinSearch(city2));
        System.out.println(joinSearch(city3));
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

    // 并查集
    public static int joinSearch(int [][]city){
        int province = 0;
        int[] parents = new int[city.length];
        int[] levels = new int[city.length];
        boolean[] visited = new boolean[city.length];
        for(int i = 0;i<city.length ; i++){
            parents[i] = i;
            levels[i] = 1;
        }
        for(int i = 0;i<city.length;i++){
            for(int j = i + 1;j<city.length ;j++){
                if (!visited[j] && city[i][j] == 1){
                    visited[j] = true;
                    join(i,j,levels,parents);
                }
            }
        }
        for(int i = 0;i<city.length;i++){
            if (parents[i] == i){
                province ++ ;
            }
        }
        return province;
    }

    // 合并指的是将leval小的root指向level大的root
    private static void join(int i,int j,int[] levels,int[]parents){
        // 查  root，顺便缩短路径
        int rootJ = search(j,parents);
        int rootI = search(i,parents);
        // 并  root，将相连城市并到同一个root下
        if(levels[rootI] < levels[rootJ]){
            parents[i] = rootJ;
        }else{
            parents[j] = rootI;
        }
        if (levels[rootI] == levels[rootJ]){
            levels[j] ++;
        }
    }
    // 根据i和j的level，将level比较小的树的root改成大的root
    private static int search(int i,int[] parents ) {
        if(i == parents[i]){
            return i;
        }
        // 这里将路径进行缩短，直接将叶子节点指向根节点，减少递归
        parents[i] =  search(parents[i],parents);
        return parents[i];
    }
}
