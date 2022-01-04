package TransitiveClosure;
// let's apply dfs
import java.util.ArrayList;

public class TransitiveClosure {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertices = 4;
    public static void main(String[] args) {
        for(int i = 0;i < vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 0);

        findTransitiveCloser();
        System.out.println();
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    private static void findTransitiveCloser() {
        int[][] closer = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            int[] visited = new int[vertices];
            for (int j = i; j <= i; j++) {
                if(visited[j] == 0) {
                    transitiveCloser(i, visited, closer);

                    for (int value : visited) {
                        System.out.print(value + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void transitiveCloser(int start, int[] visited, int[][] closer) {
        visited[start] = 1;

        for(int it: graph.get(start)) {
            if(visited[it] == 0) {
                transitiveCloser(it, visited, closer);
            }
        }
    }

    private static void printGraph() {
        for(int i = 0;i < graph.size();i++) {
            System.out.print(i + " => ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
