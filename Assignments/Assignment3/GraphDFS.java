package com.graphassignment;

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class GraphDFS {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    public GraphDFS() {

    }

    // Constructor
    public GraphDFS(int v) {
        V = v+1;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
    }

    void removeEdge(int v,int w) {
        //adj[v].add(w);
        adj[v].remove(w);
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[], Set<Integer> childrenset) {
        // Mark the current node as visited and print it
        visited[v] = true;
        if (childrenset != null) {
            childrenset.add(v);
        }  else
        {
            // throw something
        }

        //System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = null;

        try {
             i = adj[v].listIterator();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("check array size");
        }

        if (childrenset != null) {
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited, childrenset);
            }
        }


    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v, Set<Integer> childrenset){
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V+1];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited, childrenset);
    }

    public void mainGraphDfs(Map<Integer, ArrayList<Integer>> hashMap, int ver) {
        GraphDFS g = new GraphDFS(ver);

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

        System.out.println("All Children "+ "(starting from vertex 2)");

        Set<Integer> childrenset = new HashSet<Integer>();

        g.DFS(2, childrenset);

        childrenset.remove(2);

        Iterator<Integer> it2 = childrenset.iterator();
        while(it2.hasNext() && !it2.equals(2)){

            System.out.println(it2.next());

        }
    }
}
// This code is contributed by Aakash Hasija