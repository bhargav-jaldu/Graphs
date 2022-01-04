package AdjacencyMatrix;

public class AdjacencyMatrix {
    private final int[][] adjMatrix;
    private static int vertices;
    private static int edges;
    AdjacencyMatrix(int nodes) {
        vertices = nodes;
        edges = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int source, int destination) {
        this.adjMatrix[source][destination] = 1;
        this.adjMatrix[destination][source] = 1;
        edges++;
    }

    public void printGraph() {
        System.out.println(vertices + " vertices, " + edges + " edges ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < vertices;i++) {
            sb.append(i + ": ");
            for(int j : adjMatrix[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        graph.printGraph();
    }
}
