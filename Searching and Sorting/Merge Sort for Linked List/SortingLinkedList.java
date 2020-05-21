package com.company;

public class SortingLinkedList {
    static class Node {
        int data;
        Node next;
    }
    Node head;
    public int size(){
        int count=0;
        if(head==null){
            count=0;
        }else{
            Node n=head;
            while(n!=null){
                count++;
                n=n.next;
            }
        }
        return count;
    }
    public void insert(int data){
        Node node=new Node();
        node.data=data;
        node.next=null;
        if(head==null){
            head=node;
        }else{
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }
    public void show(){
        Node node=head;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
    public void sort(){
        head=mergeSort(head);
    }
    private Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(slow);
        return merge(left,right);
    }
    private Node merge(Node a,Node b){
        Node result=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<=b.data){
            result=a;
            result.next=merge(a.next,b);
        }else{
            result=b;
            result.next=merge(a,b.next);
        }
        return result;
    }
}
