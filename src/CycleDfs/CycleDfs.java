package CycleDfs;

import java.util.*;

class Node {
    int first, second;
    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CycleDfs {
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    static int edges = 5, vertices = 8;
    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(2,5);
        addEdge(5,6);
        addEdge(5,8);
        addEdge(6,7);
        addEdge(7,8);

        boolean res = detectCycle();
        System.out.println(res);
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    private static boolean detectCycle() {
        boolean[] visited = new boolean[8 + 1];
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(2, -1));

        while(!stack.isEmpty()) {
            int node = stack.peek().first;
            int parent = stack.peek().second;
            stack.pop();

            if(!visited[node]) {
                visited[node] = true;

                for(int it: graph.get(node)) {
                    if(!visited[it]) {
                        stack.push(new Node(it, node));
                    } else if(it != parent) {
                        return true;
                    }
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
