package com.graphassignment;

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class immediateChild {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    immediateChild(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj[v].add(w);
    }

    void removeEdge(int v,int w) {
        //adj[v].add(w);
        adj[v].remove(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        boolean flag = true;
        boolean flag2 = true;

        while (queue.size() != 0 && flag) {
            // Dequeue a vertex from queue and print it
           s = queue.poll();
           /* if(flag = false)
            {
                System.out.print(s+" ");
            } */

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    System.out.println(n);
                }
            }

            //Iterator i = lList.iterator();
            //flag2 = false;
            flag = false;
        }
    }

    // Driver method to
    public void mainImmidiateChild(Map<Integer, ArrayList<Integer>> hashMap, int ver) {
        immediateChild g = new immediateChild(ver);

        Iterator it = hashMap.keySet().iterator();
        ArrayList<Integer> tempList = null;

        while (it.hasNext()) {
            int key1 = Integer.parseInt(it.next().toString());
            tempList = hashMap.get(key1);
            if (tempList != null) {
                for (Integer value: tempList) {
                    //System.out.println("Key : "+key+ " , Value : "+value);
                    g.addEdge(key1, value);
                }
            }
        }

        System.out.println("Following are immidiate children "+ "(starting from vertex 2)");

        g.BFS(2);
    }
}