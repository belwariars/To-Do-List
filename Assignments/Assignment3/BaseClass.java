package com.graphassignment;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;





public class BaseClass {

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    public BaseClass() {

    }

    //Constructor
    public BaseClass(int vertices){

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

   // com.graphassignment.BaseClass graph = new com.graphassignment.Graph(v);
    //graph.main();

    void removeEdge(int v,int w){
        //adj[v].add(w);
        adjList[v].remove(w);
    }


    static BaseClass g = new BaseClass();


    public static void main(String[] args) {


        int no_of_ver = 0;
        int first = -1;
        int second = -1;

      /*  g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        // g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(1,3);

        g.removeEdge(2,0);*/

        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();

        ArrayList<Integer> arrayList0 = new ArrayList<Integer>();
        arrayList0.add(1);
        arrayList0.add(2);
        arrayList0.add(3);

        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(3);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(0);
        arrayList2.add(1);


        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();




        hashMap.put(0, arrayList0);
        hashMap.put(1, arrayList1);
        hashMap.put(2, arrayList2);
        hashMap.put(3, arrayList3);


        Iterator it = hashMap.keySet().iterator();
        ArrayList<Integer> tempList = null;

        while (it.hasNext()) {
            int key = Integer.parseInt(it.next().toString());
            tempList = hashMap.get(key);
            if (tempList != null) {
                for (Integer value: tempList) {
                    System.out.println("Key : "+key+ " , Value : "+value);
                }
            }
        }

     /*   Multimap<String, String> myMultimap = ArrayListMultimap.create();


        hmap.put(0, 1);
        hmap.put(0, 2);
        hmap.put(0, 3);
        hmap.put(2, 1);
        hmap.put(1, 3);

        int vertices = 4;
*/

     int v = 4;
        Graph graph = new Graph();
        graph.mainGraph(hashMap, v);

        immediateChild immediatechild = new immediateChild(v);
        immediatechild.mainImmidiateChild(hashMap, v);

        immidiateParent immidiateparent = new immidiateParent(v);
        immidiateparent.mainImmidiateParent(hashMap, v);




        GraphDFS graphDFS = new GraphDFS(v);
        graphDFS.mainGraphDfs(hashMap, v);


    }

}
