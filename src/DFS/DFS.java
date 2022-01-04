package DFS;

import java.util.*;

public class DFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int edges = 7;
    static int vertices = 7;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2);
        addEdge(2,4);
        addEdge(2,7);
        addEdge(4,6);
        addEdge(6,7);
        addEdge(3, 5);

        dfs();
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static void dfs() {
        boolean[] visited = new boolean[vertices + 1];

        for(int i = 1;i <= vertices;i++) {
            if(!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while(!stack.isEmpty()) {
                    int node = stack.pop();

                    if(!visited[node]) {
                        visited[node] = true;
                        System.out.print(node + " ");

                        for(int it: graph.get(node)) {
                            if(!visited[it]) {
                                stack.push(it);
                            }
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
