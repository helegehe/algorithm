package com.abao.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinLevel {
    public static void main(String[] args) {
        Node node6 = new Node(6,null,null);
        Node node5 = new Node(5,null,node6);
        Node node4 = new Node(4,null,null);
        Node node3 = new Node(3,null,null);
        Node node2 = new Node(2,node4,node5);
        Node node1 = new Node(1,node2,node3);
        System.out.println(widFirst(node1));
        System.out.println("finish");
    }

    public static int depFirst(Node root){
        int rt = Integer.MAX_VALUE;
        if (root.right == null && root.left == null){
            return 1;
        }
        if (root.left != null){
            rt = Math.min(rt,depFirst(root.left)) + 1;
        }
        if (root.right != null){
            rt = Math.min(rt,depFirst(root.right)) + 1;
        }
        return rt;
    }

    public static int widFirst(Node root){
        if (root == null){
            return 0;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        root.depth = 1;
        nodes.offer(root);
        while (!nodes.isEmpty()){
            Node now = nodes.poll();
            if (now.left == null && now.right == null){
                return now.depth;
            }
            if (now.left != null){
                now.left.depth = now.depth + 1;
                nodes.offer(now.left);
            }
            if (now.right != null){
                now.right.depth = now.depth + 1;
                nodes.offer(now.right);
            }
        }
        return 0;
    }
    static class Node{
        private int val;
        private Node left;
        private Node right;
        private int depth;
        Node(int val,Node left,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public void setDepth(int depth) {
            this.depth = depth;
        }
        public int getDepth() {
            return depth;
        }
    }
}
