package MotherVertex;

import java.util.*;

class MotherVertex {
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    static int edges = 7, vertices = 4;
    public static void main(String args[]) {
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 0);
        addEdge(0, 3);
        addEdge(0, 2);
        addEdge(3, 4);
        addEdge(2, 1);

        motherVertex();
        System.out.println();
        printGraph();
    }

    public static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    private static void motherVertex() {

        for(int i = 0;i <= vertices;i++) {
            int[] visited = new int[vertices + 1];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i;j <= i;j++) {
                if(visited[i] == 0) {
                    findMotherVertex(i, visited, list);

                    if(list.size() == vertices + 1) {
                        System.out.println(i + " is a mother vertex");
                    } else {
                        System.out.println(i + " nope");
                    }
                }
            }
        }
    }

    private static void findMotherVertex(int start, int[] visited, ArrayList<Integer> list) {
        visited[start] = 1;
        list.add(start);

        for(int it: graph.get(start)) {
            if(visited[it] == 0) {
                findMotherVertex(it, visited, list);
            }
        }
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

