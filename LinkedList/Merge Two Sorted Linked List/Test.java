package com.company;
public class Test {
    public static void main (String[] args) {
        MergeTwoLinkedList mll1 = new MergeTwoLinkedList();
        mll1.insert(2);
        mll1.insert(4);
        MergeTwoLinkedList mll2 = new MergeTwoLinkedList();
        mll2.insert(3);
        mll2.insert(5);
        mll1.merge(mll1,mll2);
        mll1.show();
    }
}
