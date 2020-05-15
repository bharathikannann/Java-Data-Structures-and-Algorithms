package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public int sum(){
        return sumRec(root);
    }
    private int sumRec(Node root){
        if(root==null)
            return 0;
        return root.data+sumRec(root.left)+sumRec(root.right);
    }

    public int getDiffEvenOddNodes(){
        return getDiffEvenOddNodesRec(root);
    }
    private int getDiffEvenOddNodesRec(Node root){
        if(root==null)
            return 0;
        return root.data-getDiffEvenOddNodesRec(root.left)-getDiffEvenOddNodesRec(root.right);
    }

    public int noOfNodes(){
        return noofnodes(root);
    }
    private int noofnodes(Node root){
        if(root==null)
            return 0;
        return 1+noofnodes(root.left)+noofnodes(root.right);
    }

    public int noOfLeadNodes(){
        return noofleafnodes(root);
    }
    private int noofleafnodes(Node root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        return noofleafnodes(root.left)+noofleafnodes(root.right);
    }

    public int height(){
        return heightRec(root);
    }
    private int heightRec(Node root){
        if(root==null)
            return -1;
        return max(heightRec(root.left),heightRec(root.right))+1;
    }
    private int max(int a,int b){
        return (a>b)?a:b;
    }
    public void levelOrderTraversal() {
        levelOrderTraversalRec(root);
    }
    private void levelOrderTraversalRec(Node root){
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node=q.remove();
            System.out.print(node.data+" ");
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
        System.out.println();
    }
    public void printAtGivenLevel(int level){
        printAtGivenLevelRec(root,level);
    }
    private void printAtGivenLevelRec(Node root,int level){
        if(root==null)
            return;
        if(level==1) {
            System.out.print(root.data+" ");
            return;
        }
        printAtGivenLevelRec(root.left,level-1);
        printAtGivenLevelRec(root.right,level-1);
    }
    public void reverseLevelOrderTraversal() {
        reverseLevelOrderTraversalRec(root);
    }
    private void reverseLevelOrderTraversalRec(Node root){
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s=new Stack<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node=q.remove();
            s.push(node.data);
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }
    public void levelOrderTraversallinebyline() {
        levelOrderTraversallinebylineRec(root);
    }
    private void levelOrderTraversallinebylineRec(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (true) {
            int count=q.size();
            if(count==0)
                break;
            while (count>0) {
                Node node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                count--;
            }
            System.out.println();
        }
    }
}

