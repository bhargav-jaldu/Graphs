package PrimsAlgo;

import java.util.*;

class Node {
    int vertex, weight;
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class PrimsAlgo {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int vertices = 4;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1, 2);
        addEdge(0, 3, 6);
        addEdge(1, 2, 3);
        addEdge(1, 4, 5);
        addEdge(2, 4, 7);
        addEdge(1, 3, 8);

        prims();
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination, int weight) {
        graph.get(source).add(new Node(destination, weight));
        graph.get(destination).add(new Node(source, weight));
    }

    private static void prims() {
//        need to take three arrays
        int[] key = new int[vertices + 1]; // to keep track of smaller weights
        boolean[] mst = new boolean[vertices + 1]; // to keep track of min weight edge and mark it as completed (true)
        int[] parent = new int[vertices + 1]; // to keep tract of parent node

        for (int i = 0; i <= vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        key[0] = 0;

        for (int i = 0; i <= vertices; i++) {
//            get min value from key array
            int minValue = Integer.MAX_VALUE, u = 0;

            for (int j = 0; j < key.length; j++) {
                if(!mst[j] && key[j] < minValue) {
                    minValue = key[j];
                    u = j;
                }
            }

            mst[u] = true;

//            now i have to check adj nodes for this min value
            for(Node it: graph.get(u)) {
                if(!mst[it.vertex] && it.weight < key[it.vertex]) {
                    key[it.vertex] = it.weight;
                    parent[it.vertex] = u;
                }
            }
        }

        for(int i = 1;i < parent.length;i++) {
            System.out.println(i + " is the parent of " + parent[i]);
        }
    }

    private static void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " => ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j).vertex + " [ " + graph.get(i).get(j).weight + " ] ");
            }
            System.out.println();
        }
    }
}
