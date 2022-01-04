package ShortestPathUnitWeight;

import java.util.*;

public class ShortestPathUnitWeight {
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
        shortestPath(1);
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static void shortestPath(int src) {
        int[] distance = new int[ vertices + 1 ];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int it: graph.get(node)) {
                if(distance[node] + 1 < distance[it]) {
                    distance[it] = distance[node] + 1;
                    queue.add(it);
                }
            }
        }

        for(int i: distance) {
            System.out.print(i + " ");
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

