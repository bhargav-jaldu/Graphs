package TopologicalSortDfs;

// only for Directed Acyclic Graphs (DAG)

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class TopologicalSortDfs {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    static int edges = 6, vertices = 6;
    public static void main(String[] args) {

        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        topoSort();
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    private static void topoSort() {
        int[] visited = new int[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < vertices;i++) {
            if(visited[i] == 0) {
                findTopoSort(i, graph, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void findTopoSort(int i, ArrayList<ArrayList<Integer>> graph, int[] visited, Stack<Integer> stack) {
        visited[i] = 1;

        for(int it: graph.get(i)) {
            if(visited[it] == 0) {
                findTopoSort(it, graph, visited, stack);
            }
        }

        stack.push(i);
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
