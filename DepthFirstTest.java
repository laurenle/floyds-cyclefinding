import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class DepthFirstTest {

    @Test
    public void testEmptyGraph() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        assertFalse(DepthFirst.containsCycle(nodes));             
    }
    
    @Test
    public void testSinglePointGraph() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        
        nodes.add(n0);
        
        assertFalse(DepthFirst.containsCycle(nodes));              
    }
    
    @Test
    public void testSelfReferentialVertex() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        n0.addEdge(n0);
        
        nodes.add(n0);
                
        assertTrue(DepthFirst.containsCycle(nodes));   
    }
    
    @Test
    public void testNoEdgeGraph() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        TraversableNode<Integer> n1 = new TraversableNode<Integer>(1);
        TraversableNode<Integer> n2 = new TraversableNode<Integer>(2);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
                
        assertFalse(DepthFirst.containsCycle(nodes));   
    }
    
    @Test
    public void testLinkedList() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        TraversableNode<Integer> n1 = new TraversableNode<Integer>(1);
        TraversableNode<Integer> n2 = new TraversableNode<Integer>(2);
   
        n0.addEdge(n1);
        n1.addEdge(n2);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
                
        assertFalse(DepthFirst.containsCycle(nodes));   
    }
    
    @Test
    public void testCyclicalLinkedList() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        TraversableNode<Integer> n1 = new TraversableNode<Integer>(1);
        TraversableNode<Integer> n2 = new TraversableNode<Integer>(2);
   
        n0.addEdge(n1);
        n1.addEdge(n2);
        
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
                
        assertFalse(DepthFirst.containsCycle(nodes));   
    }

    
    @Test
    public void testBranchingGraph() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        TraversableNode<Integer> n1 = new TraversableNode<Integer>(1);
        TraversableNode<Integer> n2 = new TraversableNode<Integer>(2);
        TraversableNode<Integer> n3 = new TraversableNode<Integer>(3);

        n1.addEdge(n0);
        n1.addEdge(n2);
        n1.addEdge(n3);
        n3.addEdge(n2);
        n3.addEdge(n0);

        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        
        assertFalse(DepthFirst.containsCycle(nodes));   
    }
    
    @Test
    public void testCyclicalBranchingGraph() {
        HashSet<TraversableNode<Integer>> nodes = new HashSet<TraversableNode<Integer>>();
        TraversableNode<Integer> n0 = new TraversableNode<Integer>(0);
        TraversableNode<Integer> n1 = new TraversableNode<Integer>(1);
        TraversableNode<Integer> n2 = new TraversableNode<Integer>(2);
        TraversableNode<Integer> n3 = new TraversableNode<Integer>(3);

        n0.addEdge(n1);
        n1.addEdge(n2);
        n1.addEdge(n3);
        n3.addEdge(n2);
        n3.addEdge(n0);

        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        
        assertTrue(DepthFirst.containsCycle(nodes));   
    }
    
    @Test
    public void test() {
        HashSet<TraversableNode<String>> nodes = new HashSet<TraversableNode<String>>();
        TraversableNode<String> lauren = new TraversableNode<String>("Lauren");
        TraversableNode<String> kat = new TraversableNode<String>("Katrina");
        TraversableNode<String> ale = new TraversableNode<String>("Alejandro");
        TraversableNode<String> joe = new TraversableNode<String>("Joe");
        TraversableNode<String> nick = new TraversableNode<String>("Nick");
        
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
                
        assertTrue(DepthFirst.containsCycle(nodes));
    }

}
