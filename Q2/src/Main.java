/*
 * TRABALHO PRÁTICO 02 – CAMINHAMENTO EM GRAFOS.
 * Questão 2.
 * Autores: Hélio Potelicki && Pedro Henrique Roweder.
 */

import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.io.File;

public class Main {
  public static void main(String[] args) {
    File entryFile = new File("C:\\temp\\entrada.in");
    List<List<Graph>> graphs = getFileGraphs(entryFile);

    for (int i = 0; i < graphs.size(); i++) {
      System.out.printf("Case #%s:\n", (i + 1));

      List<Graph> nestedGraph = nestedVerticesEdges(graphs.get(i));
      for (Graph graph : nestedGraph) {
        System.out.println(graph.print());
      }
      System.out.printf("%s connected components\n\n", nestedGraph.size());
    }
  }

  public static List<List<Graph>> getFileGraphs(File entry) {
    int verticesAmnt = 0;
    int edgesAmnt = 0;
    List<Character> alphabetCHARS = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    List<List<Graph>> graphs = new ArrayList<>();

    try {
      BufferedReader file = new BufferedReader(new FileReader(entry));
      file.readLine();

      while (true) {
        String amountVerticeEdge = file.readLine();
        if (amountVerticeEdge == null) {
          break;
        }

        String[] verticesEdges = amountVerticeEdge.split(" ");
        List<Character> verticesAVL = new ArrayList<>(
            alphabetCHARS.subList(0, Integer.parseInt(verticesEdges[verticesAmnt])));

        List<Graph> graphTest = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(verticesEdges[edgesAmnt + 1]); i++) {
          String edge = file.readLine();
          String[] vertices = edge.split(" ");

          includeCreateGraph(verticesAVL, graphTest, vertices);
        }

        verticesAVL.forEach(j -> {
          Graph newGraph = new Graph();
          newGraph.getNodes().add(j);
          graphTest.add(newGraph);
        });

        graphs.add(graphTest);
      }

      file.close();

    } catch (FileNotFoundException e) {
      System.out.println("File \"entrada.in\" not found in \"C:\\temp\\\"");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return graphs;
  }

  private static List<Graph> nestedVerticesEdges(List<Graph> graphTest) {
    List<Graph> nested = new ArrayList<>();

    graphTest.forEach(thisGraph -> {
      boolean isGraph = false;

      for (Graph graphToReturn : nested) {
        for (Character vertice : graphToReturn.getNodes()) {
          if (thisGraph.containsNode(vertice)) {
            graphToReturn.getNodes().addAll(thisGraph.getNodes());
            isGraph = true;
            break;
          }
        }
      }

      if (!isGraph) {
        nested.add(thisGraph);
      }
    });

    nested.forEach(graphReturned -> {
      graphReturned.setNodes(graphReturned.getNodes().stream().distinct().collect(Collectors.toList()));
      graphReturned.getNodes().sort(Character::compareTo);
    });
    return nested;
  }

  private static void includeCreateGraph(List<Character> verticesAVL, List<Graph> graphTest, String[] vertices) {
    Character firVertice = vertices[0].charAt(0);
    Character secVertice = vertices[1].charAt(0);

    boolean isGraph = false;
    for (Graph graph : graphTest) {
      if (!graph.containsNode(firVertice) && graph.containsNode(secVertice)) {
        isGraph = addRemove(verticesAVL, graph, firVertice);
        break;
      } else if (graph.containsNode(firVertice) && !graph.containsNode(secVertice)) {
        isGraph = addRemove(verticesAVL, graph, secVertice);
        break;
      } else if (graph.containsNode(firVertice) && graph.containsNode(secVertice)) {
        isGraph = true;
        break;
      }
    }

    if (!isGraph) {
      Graph newGraph = new Graph();
      newGraph.getNodes().addAll(Arrays.asList(firVertice, secVertice));
      graphTest.add(newGraph);
      verticesAVL.removeAll(newGraph.getNodes());
    }
  }

  static boolean addRemove(List<Character> verticesAVL, Graph graph, Character v) {
    graph.getNodes().add(v);
    verticesAVL.remove(v);
    return true;
  }
}
