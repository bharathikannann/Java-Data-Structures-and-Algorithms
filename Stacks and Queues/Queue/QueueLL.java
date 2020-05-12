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
public class QueueLL {
    private Node  front,rear;
    public int size=0;
    public void enqueue(int data){
        Node node=new Node(data);
        if(front==null){
            front=node;
            rear=node;
            size++;
        }else{
            rear.next=node;
            rear=node;
            size++;
        }
    }
    public void dequeue(){
        if(front==null){
            System.out.println("Queue id empty");
        }else {
            Node temp = front;
            front = front.next;
            size--;
            if (front == null) {
                rear = null;
            }
        }
    }
    public void display(){
        Node temp=front;
        if(front==null){
            System.out.println("Queue id empty");
        }else{
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
}
