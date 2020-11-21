import java.util.Scanner;
/*
 * EXERCÍCIOPARCIAL02-BUSCAS
 * Autor: Hélio Potelicki
 */
public class Main {
    private static String[] args;

    public static void main(String[] args) {
        Main.args = args;
        Graph<String> graph = new Graph<>();
        buildGraph(graph);
         int steps = 0;

        steps += graph.BFS("A", "J");
        System.out.printf("\nCaminho BFS: %s \n\n", steps);

        graph.clearVisitedNodes();
        steps = 0;

        steps += graph.DFS("A");
        System.out.printf("\nCaminho DFS: %s \n", steps);
    }

    public static void buildGraph(Graph<String> g) {
        Scanner myReader = new Scanner(System.in);
        myReader.nextLine();
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(" ");
            if (!g.hasVertex(data[0])){
                g.addVertex(data[0]);
            }
            if (!g.hasVertex(data[1])){
                g.addVertex(data[1]);
            }
            g.addEdge(data[0], data[1]);
            g.addEdge(data[1], data[0]);
        }
        myReader.close();
    }
}
