import java.util.Objects;
/*
 * EXERCÍCIOPARCIAL02-BUSCAS
 * Autor: Hélio Potelicki
 */
public class Vertex<V> {
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

    public Vertex(V v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "< Vertex = " + v + " > ";
    }

    @Override
    public boolean equals(Object a) {
        Vertex<V> outro = (Vertex<V>) a;
        return this.v == outro.getV();
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
