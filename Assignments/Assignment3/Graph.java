package com.graphassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Scanner;


// A directed graph using
// adjacency list representation
public class Graph{

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // No. of vertices in graph
    private int v;

    // adjacency list 
    private ArrayList<Integer>[] adjList;

    public Graph() {

    }


    //Constructor
    public Graph(int vertices){

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

  /*  void removeEdge(int v,int w) {
        //adj[v].add(w);
        adjList[v].remove(w);
    } */

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



    // Driver program
    public void mainGraph(Map<Integer, ArrayList<Integer>> hashMap, int ver) {

        Graph g = new Graph(ver);

     //   com.graphassignment.BaseClass g1 = super.returnobj();
        //super(4);

        // Create a sample graph
        int no_of_ver = 0;
        int first = -1;
        int second = -1;

        Scanner sc=new Scanner(System.in);

        // no_of_ver = sc.nextInt();

        //V = 4;

       /* first = Integer.parseInt(sc.next());
        second = Integer.parseInt(sc.next()); */

     /*  g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        // g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(1,3);

        g.removeEdge(2,0); */

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

       // com.graphassignment.BaseClass baseGraph = new com.graphassignment.BaseClass();

        // arbitrary destination
        //int d = 3;

        System.out.println("Enter nodeID");
        int node = sc.nextInt();
        Integer nodeval = Integer.valueOf(node);


        System.out.println("Following are all different paths from "+root+" to "+node);

        Set<Integer> ancestorset = new HashSet<Integer>();

        g.printAllPaths(root, node, ancestorset);

        System.out.println("All parents:");

        Integer iInteger;

        ancestorset.remove(node);


        Iterator<Integer> it2 = ancestorset.iterator();
        while(it2.hasNext() && !it2.equals(nodeval)){

            System.out.println(it2.next());

        }




    }
}