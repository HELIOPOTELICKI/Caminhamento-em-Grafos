/*
 * TRABALHO PRÁTICO 02 – CAMINHAMENTO EM GRAFOS.
 * Questão 2.
 * Autores: Hélio Potelicki && Pedro Henrique Roweder.
 */

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private List<Character> nodes;

  public Graph() {
    this.nodes = new ArrayList<>();
  }

  public List<Character> getNodes() {
    return nodes;
  }

  public void setNodes(List<Character> nodes) {
    this.nodes = nodes;
  }

  public boolean containsNode(Character node) {
    return this.nodes.stream().anyMatch(v -> v.equals(node));
  }

  public String print() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Character node : nodes) {
      System.out.printf("%s, ", node);
    }
    return stringBuilder.toString();
  }
}