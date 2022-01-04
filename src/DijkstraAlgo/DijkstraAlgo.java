package DijkstraAlgo;

import java.util.*;

class Node {
    int vertex, weight;
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class DijkstraAlgo {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int edges = 6, vertices = 5;

    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2, 2);
        addEdge(1, 4, 1);
        addEdge(2, 3, 4);
        addEdge(2, 5, 5);
        addEdge(5, 3, 1);
        addEdge(4, 3, 3);

//        System.out.println(graph);
        printGraph();
        System.out.println("Shortest paths: ");
        dijkstra(1);
    }

    private static void addEdge(int source, int destination, int weight) {
        graph.get(source).add(new Node(destination, weight));
        graph.get(destination).add(new Node(source, weight));
    }

    private static void dijkstra(int src) {

//        we have to use priorityQueue in dijkstra's algo, so that it will take time of O(E + VlogV)

        int[] distance = new int[vertices + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0));

        while(!queue.isEmpty()) {
            int vertex = queue.peek().vertex;
            int weight = queue.peek().weight;
            queue.remove();

            for(Node it: graph.get(vertex)) {
                if(distance[vertex] + it.weight < distance[it.vertex]) {
                    distance[it.vertex] = distance[vertex] + it.weight;
                    queue.add(new Node(it.vertex, it.weight));
                }
            }
        }

        for(int i: distance) {
            System.out.print(i + " ");
        }
    }

    private static void printGraph() {
        System.out.println("19bce7460");
        for(int i = 0;i < graph.size();i++) {
            System.out.print(i + " => ");
            for(int j = 0;j < graph.get(i).size();j++) {
                System.out.print(graph.get(i).get(j).vertex + " [ " + graph.get(i).get(j).weight + " ] ");
            }
            System.out.println();
        }
    }
}


