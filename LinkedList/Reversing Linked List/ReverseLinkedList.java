package com.company;

public class ReverseLinkedList {
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
    public void reverse(){
        Node prev=null;
        Node current=head;
        Node after;
        while(current!=null){
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
        }
        head=prev;
    }

    public void recursionReversePrint(){
        rrp(head);
    }
    void rrp(Node node){
        if(node==null){
            return;
        }
        rrp(node.next);
        System.out.println(node.data);
    }
    public void recursionReverseLinkedList(){
        rrl(head);
    }
    void rrl(Node p){
        if(p.next==null){
            head=p;
            return;
        }
        rrl(p.next);
        Node q=p.next;
        q.next=p;
        p.next=null;
    }
}
