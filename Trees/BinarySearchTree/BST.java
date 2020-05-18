package com.company;

class BST {
    class Node{
        int data;
        Node left;
        Node right;
        Node(){
        }
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    Node root;

    void insert(int data){
        root=insertRec(root,data);
    }
    private Node insertRec(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }else{
            if(data<root.data){
                root.left=insertRec(root.left,data);
            }else if(data>root.data){
                root.right=insertRec(root.right,data);
            }
        }
        return root;
    }

    void inorder(){
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.print(root.data+" ");
            inorderRec(root.right);
        }
    }

    void preorder(){
        preorderRec(root);
    }
    private void preorderRec(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder(){
        postorderRec(root);
    }
    private void postorderRec(Node root){
        if(root!=null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }

}
