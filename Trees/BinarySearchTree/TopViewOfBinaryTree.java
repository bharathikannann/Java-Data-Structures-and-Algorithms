package com.company;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
class Node{
    int data;
    Node left,right;
    Node(){
    }
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class TopViewOfBinaryTree {
    Node root=null;
    public void topView(Node root) {
        class QueueObj {
            Node node;
            int hd;
            QueueObj (Node root, int hd) {
                this.node=root;
                this.hd=hd;
            }
        }
        Queue<QueueObj> queue=new LinkedList<>();
        Map<Integer,Node> topViewMap = new TreeMap<Integer,Node>();
        if(root==null){
            return;
        }else{
            queue.add(new QueueObj(root,0));
        }

        while(!queue.isEmpty()){
            QueueObj tempnode=queue.poll();
            if(!topViewMap.containsKey(tempnode.hd))
                topViewMap.put(tempnode.hd,tempnode.node);
            if(tempnode.node.left!=null)
                queue.add(new QueueObj(tempnode.node.left,tempnode.hd-1));
            if(tempnode.node.right!=null)
                queue.add(new QueueObj(tempnode.node.right,tempnode.hd+1));
        }
        for(Map.Entry<Integer,Node> entry: topViewMap.entrySet()){
            System.out.println(entry.getValue().data);
        }
    }


    public static void main (String[] args) {
        TopViewOfBinaryTree bt = new TopViewOfBinaryTree();
        bt.root=new Node(5);
        bt.root.left=new Node(3);
        bt.root.right=new Node(7);
        bt.root.left.left=new Node(1);
        bt.root.left.right=new Node(4);
        bt.root.right.left=new Node(6);
        bt.root.right.right=new Node(10);
        bt.topView(bt.root);
    }
}

