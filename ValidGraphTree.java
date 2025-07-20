package org.example.practice.graph;
 
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 
 public class ValidGraphTree {
 
   public static boolean isValid(int [][] edges, int n) {
     if(n-1!= edges.length) return false;
     Map<Integer, List<Integer>> graph = new HashMap<>();
     int [] visited = new int[n];
     for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());
 
     for(int [] x: edges) {
       graph.get(x[0]).add(x[1]);
       graph.get(x[1]).add(x[0]);
     }
 
     //for(int i=0;i<n;i++) {
       if(hasCycle(0, -1,visited, graph)) return false;
     //}
 
     for(int x : visited) {
       if(x==0) return false;
     }
     return true;
   }
 
   public static boolean hasCycle(int index, int parent,int [] visited, Map<Integer, List<Integer>> graph) {
     visited[index]=1;
 
     for(int neighbour : graph.get(index)) {
       if(visited[neighbour]==0) {
         if(hasCycle(neighbour, index, visited, graph)) return true;
       } else if(neighbour!=parent) {
         return true;
       }
     }
     return false;
   }
 
 
   public static void main(String [] args) {
     int [][] edges = {{0,1},{0,2},{0,3},{3,4}};
     int n = 5;
     System.out.println(ValidGraphTree.isValid(edges, n));
   }
 }
