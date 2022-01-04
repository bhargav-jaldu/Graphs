package BFSTraversal;

import java.util.*;

public class BFSTraversal {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int edges = 6, vertices = 7;

    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 5);
        addEdge(5, 7);
        addEdge(7, 2);
        addEdge(4, 6);


//        System.out.println(graph);
        printGraph();
        bfs();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static void bfs() {
        boolean[] visited = new boolean[vertices + 1];

        for(int i = 1;i < visited.length;i++) {
            if(!visited[i]) {
                bfsTraversal(i, visited);
            }
        }
    }

    private static void bfsTraversal(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.remove();
            System.out.print(node + " ");

            for(int it: graph.get(node)) {
                if(!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
    }

    private static void printGraph() {
        for(int i = 0;i < graph.size();i++) {
            System.out.print(i + " => ");
            for(int j = 0;j < graph.get(i).size();j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

