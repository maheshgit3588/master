package com.ds.graph;


import java.util.Scanner;

public class Graph {

    Integer graphMatrix[][];
    Boolean isDirected;
    Boolean isWeighted;
    Integer numOfNodes;

    public Graph(Integer nodesCount, Boolean isDirected, Boolean isWeighted) {
        this.numOfNodes = nodesCount;
        this.graphMatrix = new Integer[nodesCount][nodesCount];
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

    public void addEdge(int sourceNode, int destinationNode) {
        graphMatrix[sourceNode][destinationNode] = 1;
        if (!isDirected)
            graphMatrix[destinationNode][sourceNode] = 1;
    }

    public void print() {
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                System.out.print(graphMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numOfNodes; i++) {
            System.out.print("Node " + i + " is connected to : ");
            for (int j = 0; j < numOfNodes; j++) {
                if (graphMatrix[i][j] != null && graphMatrix[i][j] == 1)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();
        Graph graph = new Graph(5, false, false);

        //graph.addEdge(1,2);
        //graph.addEdge(1,3);
        //graph.addEdge(2,4);
        //graph.addEdge(3,0);

        System.out.println("Start adding edges ");
        boolean isBreak = false;

        while (!isBreak) {
            System.out.println("Add source node of edge ");
            int sn = scanner.nextInt();
            System.out.println("Add destination node of edge ");
            int dn = scanner.nextInt();
            graph.addEdge(sn, dn);

            System.out.println("Do you want to continue (Y/N or y/n) : ");
            scanner.nextLine();
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("N"))
                isBreak = true;
        }
        graph.print();

        System.out.println("===================");
        graph.printEdges();

    }

}
