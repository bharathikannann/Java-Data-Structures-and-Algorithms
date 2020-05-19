package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<ArrayList<Integer>> adj;
    int vertices=0;
    public Graph(int n){
        this.vertices=n;
        adj=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int u,int v){
        addEdgefn(adj,u,v);
    }
    private void addEdgefn(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void printGraph(){
        for(int i=0;i<adj.size();i++){
            System.out.print(i+"|");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(" -> "+ adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    public boolean isConnected(int u,int v){
        for(int i=0;i<adj.get(u).size();i++){
            if(adj.get(u).get(i)==v){
                return true;
            }
        }
        return false;
    }
    public void dfs(){
        boolean[] visited=new boolean[vertices];
        System.out.println("DFS ");
        for(int i=0;i<vertices;i++){
            if(!visited[i])
                dfsfn(i,visited);
        }
        System.out.println();
    }
    private void dfsfn(int n,boolean[] visited){
        visited[n]=true;
        System.out.print(n+" ");
        for(int i=0;i<adj.get(n).size();i++){
            int j=adj.get(n).get(i);
            if(!visited[j])
                dfsfn(j,visited);
        }
    }
    public void bfs(){
        System.out.println("BFS ");
        boolean[] visited=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                bfsfn(i,visited);
            }
        }
        System.out.println();
    }
    private void bfsfn(int n,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        visited[n]=true;
        q.add(n);
        while(!q.isEmpty()){
           int data = q.poll();
            System.out.print(data+" ");
            for(int i=0;i<adj.get(n).size();i++){
                int s=adj.get(n).get(i);
                if(!visited[s]) {
                    visited[s]=true;
                    q.add(s);
                }
            }
        }
    }
}
