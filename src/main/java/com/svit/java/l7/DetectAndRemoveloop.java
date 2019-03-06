package com.svit.java.l7;

public class DetectAndRemoveloop {
    //static Node head;
    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    static boolean detectTheLoop(Node node){
        if(node ==null || node.next == null){
            return false;
        }
        Node slow = node.next;
        Node fast = node.next.next;
        while(fast != null && fast.next.next != null) {
            if(slow==fast){
                removeLoop(slow, node);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }

    static void removeLoop(Node slow, Node head){
        Node cur = head;
        while(slow.next != cur.next){
            cur = cur.next;
            slow = slow.next;
        }
        cur = cur.next;
        slow.next=null;
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
        Node node5 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        printList(node1);
        System.out.println(detectTheLoop(node1));
        printList(node1);
    }
}
