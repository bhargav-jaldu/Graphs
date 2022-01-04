package DfsRecursive;
import java.util.*;

public class DfsRecursive {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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
//        addEdge(4, 6);

        int[] visited = new int[vertices + 1];
        dfs(1, graph, visited);
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static void dfs(int start, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        visited[start] = 1;
        System.out.print(start + " ");
        for(int it: graph.get(start)) {
            if(visited[it] == 0) {
                dfs(it, graph, visited);
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

