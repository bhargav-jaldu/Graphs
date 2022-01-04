package BipartiteBfs;

import java.util.*;

public class BipartiteBfs {
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    static int edges = 7, vertices = 8;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 7);
        addEdge(3,4);
        addEdge(4,5);
        addEdge(5,8);
        addEdge(5,6);
        addEdge(6,7);

        boolean res = bipartiteBfs();
        System.out.println(res);
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static boolean bipartiteBfs() {
        int[] visited = new int[vertices + 1];
        for(int i = 0;i <= vertices;i++) {
            visited[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int it: graph.get(node)) {
                if(visited[it] == -1) {
                    visited[it] = 1 - visited[node];
                    queue.add(it);
                } else if(visited[it] == visited[node]) {
                    return false;
                }
            }
        }

        return true;
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
