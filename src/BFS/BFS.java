package BFS;

import java.util.*;

public class BFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int edges = 7;
    static int vertices = 7;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(1, 2);
        addEdge(2,3);
        addEdge(2, 7);
        addEdge(3,5);
        addEdge(5, 7);
        addEdge(4, 6);

        bfs();
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static void bfs() {
        boolean[] visited = new boolean[vertices + 1];

        for(int i = 1;i <= vertices;i++) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");

                    for(int it: graph.get(node)) {
                        if(!visited[it]) {
                            visited[it] = true;
                            queue.offer(it);
                        }
                    }
                }
            }
        }
    }

    private static void printGraph() {
        for(int i = 0;i < graph.size();i++) {
            System.out.print(i + " => ");
            for(int j = 0;j < graph.get(i).size();j++) {
                System.out.print(graph.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
