package com.svit.java.algorithm;

import com.svit.java.l7.DetectAndRemoveloop;

public class findlistsize {
    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    static int findSize(Node node){
        if(node==null) return 0;
        Node slow = node;
        Node fast = node;
        int size = 0;
        while(slow != null){
            size += 1;
            slow = slow.next;
            if(fast != null && fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                if (slow == fast){
                    Node cur = node;
                    size=0;
                    while(cur != fast){
                        cur  = cur.next;
                        fast = fast.next;
                    }
                }
            }

        }
        return 0;
    }
    static void printList(Node node) {
        int len = 8;
        int i = 0;
        while (node != null && i < len) {
            System.out.print(node.val + " ");
            node = node.next;
            i +=1;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        printList(node1);
        //System.out.println(detectTheLoop(node1));
        printList(node1);
    }
}
