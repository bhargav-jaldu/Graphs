package CountAllPaths;


import java.util.*;

public class CountAllPaths {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int edges = 6, vertices = 5;

    public static void main(String[] args) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }


        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(4, 3);
        addEdge(5, 4);
        addEdge(2, 5);

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        countNoOfPaths(1, 3, count, list);

        System.out.println("total no of paths = " + list.size());
        printGraph();
    }

    private static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    private static void countNoOfPaths(int source, int destination, int count, ArrayList<Integer> list) {
        if(source == destination) {
            count++;
            list.add(count);
        }

        for(int it: graph.get(source)) {
            countNoOfPaths(it, destination, count, list);
        }
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


