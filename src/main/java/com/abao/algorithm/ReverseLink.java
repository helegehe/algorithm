package com.abao.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReverseLink {
    public static void main(String[] args) {
        System.out.println("algorithm");
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
//        Node newHead = reverseWithArray(node1);
//        Node newHead = reverse(node1);
        Node newHead = recursion(node1);
        System.out.println("finish");
    }
    public static Node reverseWithArray(Node head ){
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(null);
        while(head != null){
            nodes.add(head);
            head = head.next;
        }
        for(int i = 1;i<nodes.size() ;i++){
            nodes.get(i).next = nodes.get(i-1);
        }
        return nodes.get(nodes.size()-1);
    }

    public static Node reverse(Node head){
        Node pre = null;
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static Node recursion(Node head){

        if (head == null && head.next == null){
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    static class Node{
        private int val;
        private Node next;
        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
}
