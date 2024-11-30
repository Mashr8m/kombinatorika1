// Алгоритм построения кратчайших путей на сети с единичными длинами

import java.util.LinkedList;
import java.util.Queue;

public class Main{
    private int vertices; // Количество вершин
    private LinkedList<Integer>[] adjacencyList; // Список смежности

    public Main(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Для неориентированного графа
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);
        distance[startVertex] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[vertex] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // Вывод расстояний от начальной вершины
        for (int i = 0; i < vertices; i++) {
            System.out.println("Расстояние от " + startVertex + " до " + i + " равно " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Main graph = new Main(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        graph.bfs(0); // Запуск BFS от вершины 0
    }
}