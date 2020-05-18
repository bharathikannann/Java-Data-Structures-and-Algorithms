package com.company;

import com.sun.jdi.IntegerValue;

import java.util.*;

class BT {
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
        System.out.println();
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
        System.out.println();
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
    public void leftViewOfTree(){
        leftViewOfTreeRec(root);
    }
    private void leftViewOfTreeRec(Node root){
        if(root==null)
            return;
        System.out.println(root.data);
        leftViewOfTreeRec(root.left);
    }
    public void rightViewOfTree(){
        rightViewOfTreeRec(root);
    }
    private void rightViewOfTreeRec(Node root){
        if(root==null)
            return;
        System.out.println(root.data);
        rightViewOfTreeRec(root.right);
    }
    public void inorderUsingStack(){
        inorderUsingStackRec(root);
    }
    private void inorderUsingStackRec(Node root){
        if(root==null)
            return;
        Stack<Node> s=new Stack<Node>();
        while(root!=null){
            s.push(root);
            root=root.left;
        }
        while(s.size()>0){
            Node temp1=s.pop();
            System.out.print(temp1.data+" ");
            if(temp1.right!=null){
                Node temp2=temp1.right;
                while(temp2!=null) {
                    s.push(temp2);
                    temp2 = temp2.left;
                }
            }
        }
    }
    public void mirrorTree(){
        mirrorTreeRec(root);
    }
    private void mirrorTreeRec(Node root){
        if(root==null) return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTreeRec(root.left);
        mirrorTreeRec(root.right);
    }
    public void delete(){
        root=deleteRec(root);
    }
    private Node deleteRec(Node root){
        if(root==null)
            return null;
        root.left=deleteRec(root.left);
        root.right=deleteRec(root.right);
        System.out.println("Deleting "+root.data);
        root=null;
        return root;
    }
    public boolean checkIdentical(Node t1,Node t2){
        if(t1==null&&t2==null)
            return true;
        if(t1==null||t2==null)
            return false;
        return t1.data==t2.data&&checkIdentical(t1.left,t2.left)&&checkIdentical(t1.right,t2.right);
    }

    public int getLevelOfNode(int val){
        return getLevelOfNodeRec(root,val,1);
    }
    private int getLevelOfNodeRec(Node root,int val,int level){
        if(root==null)
            return 0;
        if(root.data==val)
            return level;
        int l=level;
        l=getLevelOfNodeRec(root.left,val,level+1);
        if(l!=0)
            return l;
        l=getLevelOfNodeRec(root.right,val,level+1);
        return l;
    }
    public void boundryNodes() {
        if (root != null) {
            System.out.println(root.data);
            printLeft(root.left);
            printRight(root.right);
            printLeaves(root);
        }
    }
    private void printLeaves(Node root){
            if(root!=null){
                printLeaves(root.left);
                if(root.left==null && root.right==null)
                    System.out.println(root.data);
                printLeaves(root.right);
            }
        }
    private void printLeft(Node root){
            if(root!=null){
                if(root.left!=null){
                    System.out.println(root.data);
                    printLeft(root.left);
                }else if(root.right!=null){
                    System.out.println(root.data);
                    printLeft(root.right);
                }
            }
        }
    private void printRight(Node root){
        if(root!=null){
            if(root.right!=null){
                System.out.println(root.data);
                printRight(root.right);
            }else if(root.left!=null){
                System.out.println(root.data);
                printRight(root.left);
            }
        }
    }
    public void printVerticalOrder(){
        if(root==null)
            return;
        int hd=0;
        TreeMap<Integer, ArrayList<Integer>> map=new TreeMap<Integer,ArrayList<Integer>>();
        getVerticalOrder(root,hd,map);
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            for(Integer i : entry.getValue()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    private void getVerticalOrder(Node root,int hd,TreeMap<Integer,ArrayList<Integer>> map){
        if(root==null)
            return;
        if(map.get(hd)==null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.data);
            map.put(hd,list);
        }else{
        ArrayList<Integer> list=map.get(hd);
        list.add(root.data);
        map.put(hd,list);
        }
        getVerticalOrder(root.left,hd-1,map);
        getVerticalOrder(root.right,hd+1,map);
    }
    public void verticalSum(){
        if(root==null)
            return;
        int hd=0;
        TreeMap<Integer, ArrayList<Integer>> map=new TreeMap<Integer,ArrayList<Integer>>();
        getVerticalOrderSum(root,hd,map);
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            int sum=0;
            for(Integer i : entry.getValue()){
                sum+=i;
            }
            System.out.println(sum);
        }
    }
    private void getVerticalOrderSum(Node root,int hd,TreeMap<Integer,ArrayList<Integer>> map){
        if(root==null)
            return;
        if(map.get(hd)==null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.data);
            map.put(hd,list);
        }else{
            ArrayList<Integer> list=map.get(hd);
            list.add(root.data);
            map.put(hd,list);
        }
        getVerticalOrder(root.left,hd-1,map);
        getVerticalOrder(root.right,hd+1,map);
    }
    public void levelWiseSum() {
        levelWiseSumRec(root);
    }
    private void levelWiseSumRec(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (true) {
            int count=q.size();
            if(count==0)
                break;
            int sum=0;
            while (count>0) {
                Node node = q.remove();
                sum+=node.data;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                count--;
            }
            System.out.println(sum);
        }
    }
    public boolean recursiveSearch(int data){
        return recursiveSearchRec(root,data);
    }
    private boolean recursiveSearchRec(Node root,int data){
        if(root==null)
            return false;
        if(root.data==data)
            return true;
        return recursiveSearchRec(root.left,data)||recursiveSearchRec(root.right,data);
    }
    public boolean iterativeSearch(int data){
        return iterativeSearchfn(root,data);
    }
    private boolean iterativeSearchfn(Node root,int data){
        if(root==null)
            return false;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp.data==data)
                return true;
            else{
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return false;
    }
    public void spiralOrder() {
        spiralOrderfn(root);
    }
    private void spiralOrderfn(Node root){
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty()){
            while(!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s2.push(temp.right);
                if (temp.right != null)
                    s2.push(temp.left);
            }
            System.out.println();
                while(!s2.isEmpty()){
                    Node temp=s2.pop();
                    System.out.print(temp.data+" ");
                    if(temp.left!=null)
                        s1.push(temp.left);
                    if(temp.right!=null)
                        s1.push(temp.right);
                }
            System.out.println();
            }
    }
}


