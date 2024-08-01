import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OptimizedMain {

    private final ArrayList<ArrayList<Integer>> adjList;
    private final HashSet<Integer> visitedNodes;

    public OptimizedMain(int numVertices) {
        adjList = new ArrayList<>();
        visitedNodes = new HashSet<>();
        for (int i = 0; i < numVertices; ++i) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int startVertex, int endVertex) {
        adjList.get(startVertex).add(endVertex);
    }

    public boolean pathExists(int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == end) {
                return true;
            }
            if (!visitedNodes.contains(current)) {
                visitedNodes.add(current);
                for (int neighbor : adjList.get(current)) {
                    if (!visitedNodes.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String graphFile = "graph.txt";
        int numVertices = getVertexCountFromFile(graphFile);
        OptimizedMain graph = new OptimizedMain(numVertices);
        loadGraphFromFile(graph, graphFile);
        int startVertex = 0;
        int endVertex = numVertices - 1;

        System.out.println(graph.pathExists(startVertex, endVertex));
    }

    private static int getVertexCountFromFile(String graphFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(graphFile))) {
            return Integer.parseInt(br.readLine().trim());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private static void loadGraphFromFile(OptimizedMain graph, String graphFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(graphFile))) {
            br.readLine(); // skip the first line with vertex count
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int startVertex = Integer.parseInt(parts[0]);
                int endVertex = Integer.parseInt(parts[1]);
                graph.addEdge(startVertex, endVertex);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
