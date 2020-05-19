package com.company;

import java.util.*;

public class GraphLL {
    LinkedList<Integer>[] adj;
    int vertices=0;
    public GraphLL(int n){
        this.vertices=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void addEdge(int u,int v){
        addEdgefn(adj,u,v);
    }
    private void addEdgefn(LinkedList<Integer>[] adj,int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }
    public void printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.print(i+"|");
            for(int j=0;j<adj[i].size();j++){
                System.out.print(" -> "+ adj[i].get(j));
            }
            System.out.println();
        }
    }
    public boolean isConnected(int u,int v){
        for(int i=0;i<adj[i].size();i++){
            if(adj[u].get(i)==v){
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
        Iterator<Integer> i=adj[n].listIterator();
        while(i.hasNext()){
            int s=i.next();
            if(!visited[s])
            dfsfn(s,visited);
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
            Iterator<Integer> i =adj[data].listIterator();
            while(i.hasNext()){
                int s=i.next();
                while(!visited[s]){
                    q.add(s);
                    visited[s]=true;
                }
            }
        }
    }
}
