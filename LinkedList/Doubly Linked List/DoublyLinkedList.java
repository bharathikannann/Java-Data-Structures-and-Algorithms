package com.company;

public class DoublyLinkedList {
    static class Node{
        int data;
        Node prev;
        Node next;
    }
    Node head;
    public void insertAtFirst(int n){
        Node node=new Node();
        node.data=n;
        node.prev=null;
        node.next=null;
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }
    public void show(){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void reversePrint(){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.prev;
        }
    }
    public void insertAtPosition(int position,int data){
        if(position==0){
            insertAtFirst(data);
        }else{
            Node temp=head;
            Node node=new Node();
            node.data=data;
            node.prev=null;
            node.next=null;
            for(int i=0;i<position-1;i++){
                temp=temp.next;
                if(temp==null) {
                    return;
                }
            }
                node.next = temp.next;
                node.prev = temp;
                temp.next = node;
                if (temp.next != null) {
                    temp.next.prev = node;
                }
            }
    }
    public void deleteFirst(){
        if(head==null || head.next==null){
            head=null;
        }else{
            head.next.prev=null;
            head=head.next;
        }
    }
    public void delete(int data){
        if(head.data==data){
            deleteFirst();
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                break;
            }
            temp=temp.next;
        }
        if(temp==null) {
            System.out.println("Element doesn't exist");
            return;
        }else{
            if(temp.next!=null)
                temp.next.prev=temp.prev;
            temp.prev.next=temp.next;
        }
    }
    public void deletelast(){
        if(head==null || head.next==null)
            head=null;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
    }
    public void deleteAtPosition(int position){
        if(position==0){
            deleteFirst();
        }else{
            Node temp=head;
            for(int i=0;i<position;i++){
                temp=temp.next;
            }
            if(temp==null){
                return;
            }else{
                if(temp.next!=null)
                    temp.next.prev=temp.prev;
                temp.prev.next=temp.next;
            }
        }
    }
    public int size(){
        if(head==null)
            return 0;
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void printAllNodes(){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void roatateClockwiseByK(int k){
        if(head==null||head.next==null)
            return;

        int size=size();
        k=k%size;

        Node temp=head,start=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }
        head=temp;
        temp.prev.next=null;
        temp.prev=null;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        temp.next=start;
        start.prev=temp;
    }
}
