package com.company;
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
    public void deleteAtLast(){
        if(head==null || head.next==null){
            return;
        }else{
            Node n=head;
            while(n.next.next!=null){
                n=n.next;
            }
            n.next=null;
        }
    }
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
    public boolean isNodeExists(int val){
        if(head==null){
            return false;
        }else {
            Node n = head;
            while (n!=null) {
                if(n.data==val){
                    return true;
                }
                n=n.next;
            }
        }
        return false;
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
