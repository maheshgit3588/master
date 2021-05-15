package com.ds.graph;

import com.ds.tree.bst.BinarySearchTree;

import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyListDfsTraversalStack {

    private Integer noOfVertices;
    private LinkedList<Integer> graph[];
    private Stack<Integer> stack;

    GraphAdjacencyListDfsTraversalStack(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        initGraph();
        stack = new Stack<Integer>();
    }

    private void initGraph() {
        graph = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        graph[source].add(destination);
        graph[destination].add(source);
    }

    public void dfsStack(int vertice, boolean visited[]) {
        System.out.print(vertice + " -> ");
        visited[vertice] = true;

        graph[vertice].forEach(v -> stack.push(v));

        while (!stack.empty()) {
            int adjNode = stack.pop();
            if (!visited[adjNode])
                dfsStack(adjNode, visited);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();

        bs.inorder();
        GraphAdjacencyListDfsTraversalStack graph = new GraphAdjacencyListDfsTraversalStack(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);

        graph.dfsStack(1, new boolean[5]);
    }
}
