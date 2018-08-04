package com.graphassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import java.util.Scanner;


// A directed graph using
// adjacency list representation
public class immidiateParent {

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    public immidiateParent()
    {

    }

    //Constructor
    public immidiateParent(int vertices){

        //initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();

        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[v];

        for(int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
        adjList[u].add(v);
    }


    void removeEdge(int v,int w) {
        //adj[v].add(w);
        try {
            adjList[v].remove(w);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("check array size");
        }

    }



    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d, Set<Integer> ancestorset) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList, ancestorset);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList, Set<Integer> ancestorset) {

        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d)) {
            System.out.println("Immediate Parent is "+ localPathList.get(localPathList.size()-2));
            System.out.println(localPathList);
            ancestorset.addAll(localPathList);


        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList, ancestorset);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }


    void deleteDependency(int parent, int node, int child) {
        addEdge(parent, child);
        removeEdge(parent, node);
        removeEdge(node, child);
    }

    void deleteNode(int node, Set<Integer> ancestorset, int v) {
        GraphDFS childSet = new GraphDFS(4);
        Set<Integer> childrenset = null;
        childSet.DFS(v, childrenset);

        //Removing all parent's connection
        Iterator<Integer> it = ancestorset.iterator();
        while(it.hasNext()){

            removeEdge(v, it.next());

        }

        //Removing all child's connection

        if (childrenset != null) {
            Iterator<Integer> it2 = childrenset.iterator();
            while(it2.hasNext()){

                removeEdge(v, it2.next());

            }
        }


    }


        void addNodeCheckCycle(int parent, int node, int child, immidiateParent g) {
            Set<Integer> pathSet = new HashSet<Integer>();
            g.printAllPaths(child, parent, pathSet);

            if(pathSet.isEmpty()) {
                g.addEdge(parent, node);
                g.addEdge(node, child);

            }
            else {
                System.out.println("Cycle Exists");
            }
        }

    // Driver program
    public void mainImmidiateParent(Map<Integer, ArrayList<Integer>> hashMap, int ver) {
        // Create a sample graph
        int no_of_ver = 0;
        int first = -1;
        int second = -1;

        Scanner sc=new Scanner(System.in);

        // no_of_ver = sc.nextInt();

        //V = 4;
        immidiateParent g = new immidiateParent(ver);

       /* first = Integer.parseInt(sc.next());
        second = Integer.parseInt(sc.next()); */

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

        // arbitrary source
        int root = 0;

        // arbitrary destination
        //int d = 3;

        System.out.println("Enter nodeID");
        int node = sc.nextInt();
        Integer nodeval = Integer.valueOf(node);


        System.out.println("Following are all different paths from "+root+" to "+node);

        Set<Integer> ancestorset = new HashSet<Integer>();

        g.printAllPaths(root, node, ancestorset);

        System.out.println("All parents 1:");

        Integer iInteger;

        ancestorset.remove(node);


        Iterator<Integer> it2 = ancestorset.iterator();
        while(it2.hasNext() && !it2.equals(nodeval)){

            System.out.println(it2.next());

        }



        //com.graphassignment.immidiateParent delsingledepen = new com.graphassignment.immidiateParent();

        g.deleteDependency(0, 2, 1);

        g.deleteNode(1, ancestorset, v);


        g.addNodeCheckCycle(0, 2, 1, g);
    }
}