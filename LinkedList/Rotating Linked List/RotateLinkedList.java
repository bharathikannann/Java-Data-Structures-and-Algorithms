package com.company;

public class RotateLinkedList {
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
    public void rotateClockwise(int k) {
        if (head.next == null || head == null || k < 0) {
            return;
        }
        int size = size();
        k=k%size;
        if(k==0){
            return;
        }
        Node start=head;
        Node n=head;
        for(int i=0;i<size-k-1;i++){
            n=n.next;
        }
        head=n.next;
        Node temp=n.next;
        n.next=null;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        temp.next=start;
    }
    public void rotateAntiClockwise(int k){
        if(head==null||head.next==null||k<0){
            return;
        }
        int size=size();
        k=k%size();
        if(k==0){
            return;
        }
        Node start=head;
        Node temp=head;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        Node n=temp.next;
        head=n;
        temp.next=null;
        for(int i=0;i<size-k-1;i++){
            n=n.next;
        }
        n.next=start;
    }
}
