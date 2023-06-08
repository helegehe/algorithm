package com.abao.algorithm;

import java.util.HashSet;
import java.util.Set;

// 环形链表
public class CycleLink {
    static class Node{
        private int val;
        private Node next;
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {

        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        System.out.println(isSycleWithTwoPoint(node1));
        node5.setNext(node3);
        System.out.println(isSycleWithTwoPoint(node1));

    }

    public static boolean isSycle(Node head){
        Set<Node> nodeSet = new HashSet<>();
        while (head != null){
            if(!nodeSet.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean isSycleWithTwoPoint(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
