package RepresentationLinkedList;

import java.util.*;

public class RepresentationLinkedList {

    private static LinkedList<Integer> adj[];

    RepresentationLinkedList(int v) {
        adj = new LinkedList[v];

        for(int i = 0;i < v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void bfs(int s, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        RepresentationLinkedList g = new RepresentationLinkedList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // cyclic loop
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Bfs traversal: ");
        g.bfs(2, 5);
    }
}
