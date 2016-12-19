import java.util.HashSet;
import static org.junit.Assert.*;

import org.junit.Test;

public class FloydTest {

    @Test
    public void testEmptyGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Graph<Integer> g = new Graph<Integer>(nodes);
        assertFalse(Floyd.containsCycle(g, false));             
    }
    
    @Test
    public void testSinglePointGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        
        nodes.add(n0);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertFalse(Floyd.containsCycle(g, false));              
    }
    
    @Test
    public void testSelfReferentialVertex() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        n0.addEdge(n0);
        
        nodes.add(n0);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertTrue(Floyd.containsCycle(g, false));   
        assertTrue(Floyd.containsCycle(g, true));    
    }
    
    @Test
    public void testNoEdgeGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertFalse(Floyd.containsCycle(g, false));             
    }
    
    @Test
    public void testLinkedList() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        n0.addEdge(n1);
        n1.addEdge(n2);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertFalse(Floyd.containsCycle(g, false));  
        assertFalse(Floyd.containsCycle(g, true));    

    }
    
    @Test
    public void testCyclicalLinkedList() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        n0.addEdge(n1);
        n1.addEdge(n2);
        n2.addEdge(n0);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertTrue(Floyd.containsCycle(g, false));
        assertTrue(Floyd.containsCycle(g, true));
    }

    
    @Test
    public void testBranchingGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);

        n1.addEdge(n0);
        n1.addEdge(n2);
        n1.addEdge(n3);
        n3.addEdge(n2);
        n3.addEdge(n0);

        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertFalse(Floyd.containsCycle(g, false));
    }
    
    @Test
    public void testCyclicalBranchingGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);

        n0.addEdge(n1);
        n1.addEdge(n2);
        n1.addEdge(n3);
        n3.addEdge(n2);
        n3.addEdge(n0);

        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertTrue(Floyd.containsCycle(g, false));
    }
    
    @Test
    public void testDegreeFourCyclicalBranchingGraph() {
        HashSet<Node<Integer>> nodes = new HashSet<Node<Integer>>();
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);

        n4.addEdge(n0);
        n4.addEdge(n1);
        n4.addEdge(n2);
        n4.addEdge(n3);
        n1.addEdge(n2);
        n2.addEdge(n3);
        n2.addEdge(n4);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        
        Graph<Integer> g = new Graph<Integer>(nodes);
        
        assertTrue(Floyd.containsCycle(g, false));
    }
    
    @Test
    public void testFacebookExample() {
        HashSet<Node<String>> nodes = new HashSet<Node<String>>();
        Node<String> lauren = new Node<String>("Lauren");
        Node<String> kat = new Node<String>("Katrina");
        Node<String> ale = new Node<String>("Alejandro");
        Node<String> joe = new Node<String>("Joe");
        Node<String> nick = new Node<String>("Nick");
        
        lauren.addEdge(joe);
        lauren.addEdge(kat);
        ale.addEdge(lauren);
        joe.addEdge(nick);
        nick.addEdge(ale);
        
        nodes.add(lauren);
        nodes.add(joe);
        nodes.add(nick);
        nodes.add(ale);
        nodes.add(kat);
        
        Graph<String> g = new Graph<String>(nodes);
        
        assertTrue(Floyd.containsCycle(g, false));
    }
}
