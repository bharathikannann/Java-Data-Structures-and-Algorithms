package com.company;

import java.util.Queue;
class n{
    public int data=10;
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        QueueLL q=new QueueLL();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        q.display();
        System.out.println("Size of the queue is "+q.size);
    }
}
