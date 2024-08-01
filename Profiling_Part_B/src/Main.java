import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private final ArrayList<ArrayList<Integer>> adjList;
    private final HashMap<Integer, Boolean> visitedNodes;
    private final HashMap<Integer, HashSet<Integer>> edgeMap;

    public Main(int numVertices) {
        adjList = new ArrayList<>();
        visitedNodes = new HashMap<>();
        edgeMap = new HashMap<>();
        for (int i = 0; i < numVertices; ++i) {
            adjList.add(new ArrayList<>());
            visitedNodes.put(i, false);
            edgeMap.put(i, new HashSet<>());
        }
    }

    public void addEdge(int startVertex, int endVertex) {
        adjList.get(startVertex).add(endVertex);
        edgeMap.get(startVertex).add(endVertex);
    }

    public boolean pathExists(int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == end) {
                return true;
            }
            if (Boolean.FALSE.equals(visitedNodes.get(current))) {
                visitedNodes.put(current, true);
                for (int i = 0; i < adjList.get(current).size(); i++) {
                    int neighbor = adjList.get(current).get(i);
                    if (Boolean.FALSE.equals(visitedNodes.get(neighbor))) {
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
        Main graph = new Main(numVertices);
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

    private static void loadGraphFromFile(Main graph, String graphFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(graphFile))) {
            br.readLine();
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
