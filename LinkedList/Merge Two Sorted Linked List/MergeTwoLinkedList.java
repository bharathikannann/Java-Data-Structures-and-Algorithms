package com.company;

public class MergeTwoLinkedList {
    class Node {
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
    public void merge(MergeTwoLinkedList m1,MergeTwoLinkedList m2){
        m1.head=mergeSortedLinkedList(m1.head,m2.head);
    }
    public Node mergeSortedLinkedList(Node a,Node b){
        Node dummyHead=new Node();
        Node tail=dummyHead;
        while(true){
            if(a==null) {
                tail.next = b;
                break;
            }
            if(b==null) {
                tail.next = a;
                break;
            }
            if(a.data<b.data){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        return dummyHead.next;
    }
}
