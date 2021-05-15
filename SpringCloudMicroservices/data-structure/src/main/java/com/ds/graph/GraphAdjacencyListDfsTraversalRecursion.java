package com.ds.graph;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyListDfsTraversalRecursion {

    private int noOfVertices;
    private LinkedList<Integer> graphAdjacencyList[];

    public GraphAdjacencyListDfsTraversalRecursion(int verticesCount) {
        this.noOfVertices = verticesCount;
        graphAdjacencyList = new LinkedList[noOfVertices];
        for (int i = 0; i < verticesCount; i++) {
            graphAdjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int sourceVertice, int destinationVertice) {
        graphAdjacencyList[sourceVertice].add(destinationVertice);
        graphAdjacencyList[destinationVertice].add(sourceVertice);
    }

    public void dfsTraversal(Integer vertice, boolean visited[]) {
        System.out.print(vertice+" -> ");
        visited[vertice] = true;
        Iterator<Integer> itr = graphAdjacencyList[vertice].listIterator();
        while (itr.hasNext()) {
            Integer adjacentVertice = itr.next();
            if (!visited[adjacentVertice])
                dfsTraversal(adjacentVertice, visited);
        }
    }


    public void bfsTraversal(Integer vertice, boolean visited[], Queue<Integer> queue) {

        visited[vertice] = true;
        System.out.print(vertice+" -> ");

        graphAdjacencyList[vertice]
                .stream()
                .filter(v->!visited[v])
                .forEach(adjVertice->queue.add(adjVertice));

        if(!queue.isEmpty()){
            int imediateAdjOfVertice=queue.poll();
            bfsTraversal(imediateAdjOfVertice,visited,queue);
        }

    }

    public static void main(String[] args) {
        GraphAdjacencyListDfsTraversalRecursion graph = new GraphAdjacencyListDfsTraversalRecursion(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);
        graph.addEdge(3, 5);
        graph.addEdge(0, 6);


        System.out.println("\nDFS Traversal : \n");
        graph.dfsTraversal(0, new boolean[7]);
        System.out.println("\nBFS Traversal : \n");
        graph.bfsTraversal(0,new boolean[7],new ArrayDeque<Integer>());
    }

}
