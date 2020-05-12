package com.company;

import org.w3c.dom.Node;


public class LinkedList {
    static class Node {
        int data;
        Node next;
    }
    Node head;
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
        //System.out.println(node.data);
    }
    public void insertAtFirst(int data){
        Node node=new Node();
        node.data=data;
        node.next=null;
        node.next=head;
        head=node;
    }
    public void insert(int position,int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (position == 0) {
            insertAtFirst(data);
        } else {
            Node n = head;
            for (int i = 0; i < position - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }
    public void delete(int position){
        if(position==0){
            head=head.next;
        }else{
            Node n=head;                        //Node temp;  temp=n.next;  n.next=temp.next  temp=null
            for(int i=0;i<position-1;i++){
                n=n.next;
            }
            n.next=n.next.next;
        }
    }
}
