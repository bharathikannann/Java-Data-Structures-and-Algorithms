package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList lists=new LinkedList();
        lists.insert(5);
        lists.insert(6);
        lists.insert(7);
        lists.insertAtFirst(4);
        lists.insert(4,8);
        lists.delete(0);
        lists.deleteAtLast();
        lists.rotateClockwise(2);
        lists.rotateAntiClockwise(2);
        lists.reverse();
        lists.show();
        System.out.println("size of the linked list "+lists.size());
        System.out.println("Is Node Exists "+lists.isNodeExists(4));
        lists.recursionReversePrint();
        lists.recursionReverseLinkedList();
        lists.show();
    }
}
