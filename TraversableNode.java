import java.util.HashSet;

public class TraversableNode<T> extends AbstractNode<T, TraversableNode<T>> {

    private boolean visited;
    
    public TraversableNode(T value, HashSet<TraversableNode<T>> edges) {
        super(value, edges);
        visited = false;
    }
    
    public TraversableNode(T value) {
        super(value);
    }
    
    public void setToVisited() {
        visited = true;
    }
    
    public void setToUnvisited() {
        visited = false;
    }
    
    public boolean getVisitStatus() {
        return visited;
    }
}
