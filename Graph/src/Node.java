import java.util.Objects;
/*
 *
 * Autor: Hélio Potelicki
 */
public class Node<V> {
    private V v;
    private boolean isVisited;
    private int level = 0;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Node(V v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "< Node = " + v + " > ";
    }

    @Override
    public boolean equals(Object a) {
        Node<V> outro = (Node<V>) a;
        return this.v == outro.getV();
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
