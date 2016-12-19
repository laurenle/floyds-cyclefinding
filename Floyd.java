import java.util.List;

public class Floyd {
    /* 
     * Because Floyd is a library, you should not be able to
     * instantiate an object of type "Floyd." For this reason,
     * we make the constructor private
     */
    private Floyd() {
    }
    
    /* 
     * Helper method that implements Floyd's algorithm, assuming a linked list
     */
    private static <T> boolean turtleAndHareList(Node<T> turtle, Node<T> hare) {
        List<Node<T>> turtle_edges = turtle.getEdges();
        List<Node<T>> hare_edges = hare.getEdges();
        List<Node<T>> hare_next_edges = hare_edges;
        
        while (turtle_edges.size() != 0 && hare_next_edges.size() != 0) {
            /* If the current node has no edges, we have reached the end */
            if (turtle == hare) {
                return true;
            }
            turtle = turtle_edges.get(0);
            hare = hare_next_edges.get(0);
    
            turtle_edges = turtle.getEdges();
            hare_edges = hare.getEdges();
            if (hare_edges.size() == 0) {
                return false;
            }
            else {
                hare_next_edges = hare_edges.get(0).getEdges();
            }
        }
        return false;
    }
    
    
    /* 
     * Recursive helper method that implements Floyd's algorithm 
     */
    private static <T> boolean turtleAndHare(Node<T> turtle, Node<T> hare) {
        
        if (turtle == hare) {
            /* Turtle has caught up to Hare. A cycle was found */
            return true;
        }
        
        List<Node<T>> turtle_edges = turtle.getEdges();
        List<Node<T>> hare_edges = hare.getEdges();
        
        /* Triple-nested for-loop (ouch) */ 
        for (Node<T> hare_neighbor : hare_edges) {
            List<Node<T>> hare_neighbor_edges = hare_neighbor.getEdges();
            for (Node<T> turtle_next : turtle_edges) {
                for (Node<T> hare_next : hare_neighbor_edges) {
                    if (turtleAndHare(turtle_next, hare_next)) return true;
                }
            }
        }
        return false;
    }
    
    /*
     * Iterate over all the Nodes in a graph, and run turtleAndHare on them.
     * is_list = true when the input Graph is to be used as a linked list
     */
    public static <T> boolean containsCycle(Graph<T> g, boolean is_list) {
        List <Node<T>> nodes = g.getNodes();
        
        /* Call turtleAndHare for each Node in the graph */
        for (Node<T> node : nodes) {
            /* set turtle to the current node */
            List<Node<T>> edges = node.getEdges();
            
            if (edges.size() == 0) {
                /* If the current node has no edges, Floyd's cannot be run. skip it */
                continue;
            }
            
            else {
                /* Check each edge in the node */
                for (Node<T> edge : edges) {
                    Node<T> next_node = edge;
                    if (is_list && turtleAndHareList(node, next_node)) {
                        return true;
                    }
                    else if (turtleAndHare(node, next_node)) {
                        return true;
                    }
                }
            }
        }
        /* turtleAndHare has returned false for all nodes in the graph */
        return false;
    }
}
