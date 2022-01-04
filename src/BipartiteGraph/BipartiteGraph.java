package BipartiteGraph;

import java.util.ArrayList;

public class BipartiteGraph {
    int vertices, edges;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    BipartiteGraph() {
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

    private void printGraph(int start) {
        for(int i = 0;i < list.size();i++) {
            System.out.print(i + " : ");
            for(int j = 0;j < list.get(i).size();j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph();

        graph.addEdge(1, 2);
        graph.addEdge(2,3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 1);

        graph.printGraph(1);
    }
}