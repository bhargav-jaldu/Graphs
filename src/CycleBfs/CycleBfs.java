package CycleBfs;

import java.util.*;

class Node {
    int first, second;
    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CycleBfs {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int edges = 5, vertices = 5;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1,2);
        addEdge(1,4);
        addEdge(2,3);
        addEdge(3,4);
        addEdge(3,5);

        boolean result = detectCycle();
        System.out.println(result);
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static boolean detectCycle() {
        boolean[] visited = new boolean[vertices + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(3, -1));
        visited[3] = true;

        while(!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for(int it: graph.get(node)) {
                if(!visited[it]) {
                    visited[it] = false;
                    queue.offer(new Node(it, node));
                } else if(it != parent) {
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
