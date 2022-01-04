package CycleDetectBfs;

import java.util.*;

class Node {
    int vertex, parent;
    Node(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}

public class CycleDetectBfs {
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
        System.out.println(cycleDetectBfs());
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static boolean cycleDetectBfs() {
        int[] visited = new int[vertices + 1];

        for(int i = 0;i < visited.length;i++) {
            if(visited[i] == 0) {
                if(cycleDetect(i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean cycleDetect(int start, int[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, -1));
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int vertex = queue.peek().vertex;
            int parent = queue.peek().parent;
            queue.remove();

            for(int it: graph.get(vertex)) {
                if(visited[it] == 0) {
                    visited[it] = 1;
                    queue.add(new Node(it, vertex));
                } else if(visited[it] == 1 && parent != it) {
                    return true;
                }
            }
        }

        return false;
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


