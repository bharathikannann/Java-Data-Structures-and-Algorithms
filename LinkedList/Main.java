package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList lists=new LinkedList();
        lists.insert(5);
        lists.insert(6);
        lists.insert(7);
        lists.insertAtFirst(4);
        lists.insert(4,8);
        lists.delete(4);
        lists.delete(3);
        lists.show();
        System.out.println("----------------------------");
        Linkedlist2 list=new Linkedlist2();
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insertAtFirst(4);
        list.insert(4,8);
        list.delete(4);
        list.delete(3);
        list.show();
    }
}
