package com.company;

public class Main {

    public static void main(String[] args) {
	BST bst=new BST();
	bst.insert(5);
	bst.insert(4);
	bst.insert(7);
	bst.insert(2);
	bst.insert(6);
	System.out.println("Inorder");
	bst.inorder();
	System.out.println("\nPreorder");
	bst.preorder();
	System.out.println("\nPostorder");
	bst.postorder();
    }
}
