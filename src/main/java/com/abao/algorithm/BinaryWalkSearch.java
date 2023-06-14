package com.abao.algorithm;

import java.util.Stack;

public class BinaryWalkSearch {
    public static void main(String[] args) {
        Node node7 = new Node(7,null,null);
        Node node6 = new Node(6,null,null);
        Node node5 = new Node(5,null,null);
        Node node4 = new Node(4,null,node5);
        Node node3 = new Node(3,node6,node7);
        Node node2 = new Node(2,node4,null);
        Node node1 = new Node(1,node2,node3);
        after(node1);
        System.out.println("finish");
    }


    public static void pre(Node root){
        if (root == null){
            return ;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.empty()){
            root = nodes.pop();
            System.out.println(root.val);
            if (root.right != null){
                nodes.add(root.right);
            }
            if (root.left != null){
                nodes.add(root.left);
            }
        }

    }

    public static void mid(Node root){
        if (root == null){
            return ;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.empty()){
            while (root != null && root.left != null ){
                nodes.add(root.left);
                root = root.left;
            }
            root = nodes.pop();
            System.out.println(root.val);
            root = root.right;
            if(root != null){
                nodes.add(root);
            }
        }


    }

    public static void after(Node root){
        if (root == null){
            return ;
        }
        Stack<Node> nodes = new Stack<>();
        Node pre = root;

        while (!nodes.empty() || root != null){
            // 找到最左子节点
            while (root != null ){
                nodes.add(root);
                root = root.left;
            }
            //  弹出栈顶元素
            root = nodes.pop();
            if (root.right != null && root.right != pre ){
                nodes.add(root);
                root = root.right;
            }else{
                // 栈顶元素不存在右节点，则访问，并且记录本次访问的节点
                System.out.println(root.val);
                pre = root;
                root = null;
            }
        }

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
