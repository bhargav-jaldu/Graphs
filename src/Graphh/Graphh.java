package Graphh;

import java.util.*;

class Node {
    int first, second;
    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Graphh {
    int vertices, edges;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Graphh() {
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

    private void printGraph() {
        for(int i = 0;i < list.size();i++) {
            System.out.print(i + " : ");
            for(int j = 0;j < list.get(i).size();j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private void bfs(int start) {
        System.out.println("BFS traversal: ");
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
        System.out.println();
    }

    private void dfs(int start) {
        System.out.println("DFS traversal: ");
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[vertices + 1];
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                System.out.print(u + " ");
                visited[u] = true;
                for(int v: list.get(u)) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println();
    }

    private void dfsRecursive(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int v: list.get(start)) {
            if(!visited[v]) {
                dfsRecursive(v, visited);
            }
        }
    }

    private boolean bfsCycle(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, -1));
        boolean[] visited = new boolean[vertices + 1];
        visited[start] = true;
        while(!queue.isEmpty()) {
            int u = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for(int v: list.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(new Node(v, u));
                } else if(v != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean cycleDfs(int start, int parent, boolean[] visited) {
        visited[start] = true;
        for(int v: list.get(start)) {
            if(!visited[v]) {
                if(cycleDfs(v, start, visited)) {
                    return true;
                }
            } else if(v != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graphh graph = new Graphh();

        graph.addEdge(1, 2);
        graph.addEdge(2,3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 1);

        graph.printGraph();

        graph.bfs(1);
        graph.dfs(1);
        System.out.println("DFS Recursive traversal: ");
        boolean[] dfsRecursiveVisited = new boolean[graph.vertices + 1];
        graph.dfsRecursive(1, dfsRecursiveVisited);
        System.out.println();

        boolean result = graph.bfsCycle(1);
        System.out.println("Is cycle (copyright by bfs)😂: " + result);
        graph.bfsCycle(1);

        boolean[] cycleDfsVisited = new boolean[graph.vertices + 1];
        boolean cycleDfsResult = graph.cycleDfs(1, -1, cycleDfsVisited);
        System.out.println("Is cycle (copyright by dfs)😂: " + cycleDfsResult);
    }
}
