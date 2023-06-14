package com.abao.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearch {
    public static void main(String[] args) {
        Node node7 = new Node(7,null,null);
        Node node6 = new Node(6,null,null);
        Node node5 = new Node(5,null,null);
        Node node4 = new Node(4,null,node5);
        Node node3 = new Node(3,node6,node7);
        Node node2 = new Node(2,node4,null);
        Node node1 = new Node(1,node2,node3);
        pre(node1);
        System.out.println("finish");
    }


    public static void pre(Node root){
        if (root == null){
            return ;
        }
        System.out.println(root.val);
        if (root.left != null){
            pre(root.left);
        }
        if(root.right != null){
            pre(root.right);
        }

    }

    public static void mid(Node root){
        if (root == null){
            return ;
        }
        if (root.left != null){
            mid(root.left);
        }
        if(root.right != null){
            mid(root.right);
        }
        System.out.println(root.val);

    }

    public static void after(Node root){
        if (root == null){
            return ;
        }
        if (root.left != null){
            after(root.left);
        }
        if(root.right != null){
            after(root.right);
        }
        System.out.println(root.val);

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
