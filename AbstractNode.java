import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractNode<T, K> {

    /* 
     * These are set to private, since the value and edges are
     * only accessed and modified through helper methods
     */
    protected T value;
    protected HashSet<K> edges;
    
    /* 
     * Initializes a Node, given a generically typed value 
     * and a set of edges
     */
    public AbstractNode(T value, HashSet<K> edges) {
        this.value = value;
        this.edges = edges;
    }

    /* 
     * Initializes a Node, given a generically typed value only
     */
    public AbstractNode(T value) {
        this.value = value;
        HashSet<K> empty_edges = new HashSet<K>();
        this.edges = empty_edges;       
    }
    
    /* 
     * Return the value of a node.
     */
    public T getValue() {
        return value;
    }

    /*
     * Return a list containing all the node's edges.
     */
    public List<K> getEdges() {
        List<K> edges_list = new ArrayList<K>(edges);
        return edges_list;
    }

    /*
     * Add a new adjacency to the node
     */
    public void addEdge(K node) {
        edges.add(node);
    }
}
