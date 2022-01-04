package AdjacencyList;
// array of linked lists;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
    LinkedList<Integer> adjList[];
    int vertices, edges;

    AdjacencyList(int nodes) {
        this.vertices = nodes;
        this.edges = 0;
        this.adjList = new LinkedList[nodes];
        for(int i = 0;i < nodes;i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
        edges++;
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for(int v: adjList[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for(int v: adjList[u]) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        System.out.println(vertices + " vertices, " + edges + " edges");
        for(int i = 0;i < vertices;i++) {
            sb.append(i + " : ");
            for(int j: adjList[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);

        System.out.println("Bfs: ");
        graph.bfs(0);
        System.out.println();
        System.out.println("Dfs: ");
        graph.dfs(0);
        System.out.println();
        graph.printGraph();
    }
}
