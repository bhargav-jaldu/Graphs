import java.util.*;

class BinaryIndexedTree {
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    public static void main(String args[]) {
        int edges = 7;
        int vertices = 5;
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2);
        addEdge(2,3);
        addEdge(2, 4);
        addEdge(1, 3);
        addEdge(3,4);
        addEdge(3, 5);
        addEdge(1, 5);
        printGraph();
    }

    public static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public static void printGraph() {
        for(int i = 0;i < graph.size();i++) {
            System.out.print(i + " => ");
            for(int j = 0;j < graph.get(i).size();j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
