import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GraphGenerator {

    public static void main(String[] args) {
        int numVertices = 10000000;
        String outputFilename = "graph.txt";
        generateGraph(numVertices, outputFilename);
    }

    public static void generateGraph(int numVertices, String outputFilename) {
        Random rand = new Random();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilename))) {
            bufferedWriter.write(numVertices + "\n");
            for (int vertex = 0; vertex < numVertices; vertex++) {
                int numEdges = rand.nextInt(10);
                for (int edge = 0; edge < numEdges; edge++) {
                    int destinationVertex = rand.nextInt(numVertices);
                    bufferedWriter.write(vertex + " " + destinationVertex + "\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
