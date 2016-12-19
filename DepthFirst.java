import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DepthFirst {
    /* 
     * Because DepthFirst is a library, you should not be able to
     * instantiate an object of type "Floyd." For this reason,
     * we make the constructor private
     */
    private DepthFirst() {
    }

    public static <T> boolean depthFirstSearch(TraversableNode<T> node) {
        if (node.getVisitStatus() == true) {
            return true;
        }
        node.setToVisited();
        List<TraversableNode<T>> edges = node.getEdges();
        for (TraversableNode<T> edge : edges) {
            if (depthFirstSearch(edge) == true) {
                return true;
            }
            edge.setToUnvisited();
        }
        node.setToUnvisited();
        return false;
    }
    
    public static <T> boolean containsCycle(HashSet<TraversableNode<T>> graph) {
        ArrayList<TraversableNode<T>> nodes = new ArrayList<TraversableNode<T>>(graph);
        for (TraversableNode<T> node : nodes) {
            if (depthFirstSearch(node) == true) {
                return true;
            }
        }
        return false;
    }

}