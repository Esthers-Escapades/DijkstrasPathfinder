package project_folder;
import java.util.*;
public class testing {
    
 // Add edge
    public static void main(String[] args) {
        // Example graph represented by an adjacency list
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", Map.of("B", 3, "C", 5));
        graph.put("B", Map.of("A", 3, "C", 1));
        graph.put("C", Map.of("A", 5, "B", 1));

        String source = "A";
        Map<String, Integer> distances = dijkstra(graph, source);

        // Print the distances
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("Distance from " + source + " to " + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String source) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<String, Integer> distances = new HashMap<>();

        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentVertex = currentNode.vertex;
            int currentDistance = currentNode.distance;

            if (!distances.containsKey(currentVertex)) {
                distances.put(currentVertex, currentDistance);

                Map<String, Integer> neighbors = graph.getOrDefault(currentVertex, Collections.emptyMap());
                for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                    String neighborVertex = neighborEntry.getKey();
                    int edgeWeight = neighborEntry.getValue();
                    int newDistance = currentDistance + edgeWeight;

                    priorityQueue.add(new Node(neighborVertex, newDistance));
                }
            }
        }

        return distances;
    }

    static class Node {
        String vertex;
        int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
