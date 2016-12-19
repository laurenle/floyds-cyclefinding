import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Graph<T> {
	
    /* 
     * These are set to private, since the value and edges are
     * only be modified once when the Node is initialized
     */
	private HashSet<Node<T>> nodes;
	
	/*
	 * Given a set of nodes, initialize a graph
	 */
	public Graph(HashSet<Node<T>> nodes) {
		this.nodes = nodes;
	}
	
	/* 
	 * Return the graph's nodes in list form
	 */
	public List<Node<T>> getNodes() {
        /* Convert nodes to an ArrayList so they are easier to iterate over */
        List<Node<T>> nodes_list = new ArrayList<Node<T>>(nodes);
        return nodes_list;	    
	}
}
