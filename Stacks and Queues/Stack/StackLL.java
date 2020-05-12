package com.company;
class Node{
    int data;
    Node next;
    Node(){
    }
    Node(int data){
        this.data=data;
    }
}
public class StackLL {
    private Node head;
    public void push(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head=node;
        }
    }
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.println("Stack is empty");
        }else{
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    public void pop() throws Exception{
        if(head==null){
            System.out.println("Stack is Empty");
            throw new Exception("Stack is empty");
        }else{
            Node temp=head;
            head=head.next;
            System.out.println(temp.data);
        }
    }
    public void size(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println(count);
    }
    public void peek() throws Exception{
        if(head==null){
            System.out.println("Stack is Empty");
        }else {
            System.out.println(head.data);
        }
    }
}
