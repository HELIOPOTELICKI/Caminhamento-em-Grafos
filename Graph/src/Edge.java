/*
 * EXERCÍCIOPARCIAL02-BUSCAS
 * Autor: Hélio Potelicki
 */
public class Edge<V> {
    private V from, to;

    public Edge(V from, V to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("from and to vertex is required");
        }
        this.from = from;
        this.to = to;
    }

    public V getFrom() {
        return from;
    }

    public void setFrom(V from) {
        this.from = from;
    }

    public V getTo() {
        return to;
    }

    public void setTo(V to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "<" + from + ", " + to + ">";
    }
}
