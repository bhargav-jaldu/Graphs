package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int first, second;
    Node (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Graph {

    int vertices;
    int edges;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    Graph() {
        this.vertices = 5;
        this.edges = 0;
        for(int i = 0;i <= vertices;i++) {
            list.add(new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        list.get(source).add(destination);
        list.get(destination).add(source);
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[vertices + 1];
        visited[start] = true;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for(int v: list.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    private void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[vertices + 1];

        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for(int v: list.get(u)) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    private boolean checkCycle(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, -1));
        boolean[] visited = new boolean[vertices + 1];
        visited[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for(int v: list.get(node)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(new Node(node, parent));
                } else if(parent != v) {
                    return true;
                }
            }
        }

        return false;
    }

    private void dfsRecursive(int start, boolean[] visited, ArrayList<Integer> storeDfs) {
        storeDfs.add(start);
        visited[start] = true;
        for(int v: list.get(start)) {
            if(!visited[v]) {
                dfsRecursive(v, visited, storeDfs);
            }
        }
    }

    private boolean dfsRecursiveCheckForCycle(int start, int parent, boolean[] visited) {
        visited[start] = true;
        for(int v: list.get(start)) {
            if(!visited[v]) {
                if(dfsRecursiveCheckForCycle(v, start, visited)) {
                    return true;
                }
            } else if(v != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);

        graph.bfs(1);
        System.out.println();
        graph.dfs(1);
        System.out.println();
//        cycle
        boolean isCycle = graph.checkCycle(1);
        System.out.println(isCycle);

//        dfs recursive
        boolean[] visited = new boolean[5 + 1];
        ArrayList<Integer> storeDfs = new ArrayList<>();
        graph.dfsRecursive(1, visited, storeDfs);

        System.out.println("Recursive dfs: ");
        for(int i = 0;i < storeDfs.size();i++) {
            System.out.print(storeDfs.get(i) + " ");
        }

        System.out.println();
//        dfs recursive check for cycle
        boolean[] recursiveVisited = new boolean[5 + 1];
        System.out.println(graph.dfsRecursiveCheckForCycle(1, -1, recursiveVisited));
        System.out.println(list);
    }
}
