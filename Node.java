import java.util.HashSet;

public class Node<T> extends AbstractNode<T, Node<T>> {
    /* 
     * Initializes a Node, given a generically typed value 
     * and a set of edges
     */
    public Node(T value, HashSet<Node<T>> edges) {
        super(value, edges);
    }

    /* 
     * Initializes a Node, given a generically typed value only
     */
    public Node(T value) {
        super(value);   
    }
}