import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NodeTest {

    @Test
    public void testGetValue() {
        HashSet<Node<Integer>> empty_set = new HashSet<Node<Integer>>();
        Node<Integer> node = new Node<Integer>(1, empty_set);
        assertEquals(Integer.valueOf(1), node.getValue());        
    }
    
    @Test
    public void testGetEdgesEmpty() {
        HashSet<Node<Integer>> empty_set = new HashSet<Node<Integer>>();
        Node<Integer> node = new Node<Integer>(1, empty_set);
        List<Node<Integer>> edges = node.getEdges();
        assertEquals(0, edges.size());
    }

    @Test
    public void testGetEdgesSingleton() {
        HashSet<Node<Integer>> empty_set = new HashSet<Node<Integer>>();
        
        Node<Integer> node0 = new Node<Integer>(0, empty_set);
               
        HashSet<Node<Integer>> edge_set = new HashSet<Node<Integer>>();

        edge_set.add(node0);
        
        Node<Integer> node1 = new Node<Integer>(2, edge_set);
        List<Node<Integer>> edges = node1.getEdges();
        
        assertEquals(1, edges.size());
        assertTrue(edges.contains(node0));
        assertFalse(edges.contains(node1));
    }
    
    @Test
    public void testGetEdgesMulti() {
        HashSet<Node<Integer>> empty_set = new HashSet<Node<Integer>>();
        
        Node<Integer> node0 = new Node<Integer>(0, empty_set);
        Node<Integer> node1 = new Node<Integer>(1, empty_set);
        Node<Integer> node2 = new Node<Integer>(2, empty_set);
               
        HashSet<Node<Integer>> edge_set = new HashSet<Node<Integer>>();

        edge_set.add(node0);
        edge_set.add(node1);
        edge_set.add(node2);
        
        Node<Integer> node3 = new Node<Integer>(3, edge_set);
        List<Node<Integer>> edges = node3.getEdges();
        
        assertEquals(3, edges.size());
        assertTrue(edges.contains(node0));
        assertTrue(edges.contains(node1));
        assertTrue(edges.contains(node2));
        assertFalse(edges.contains(node3));
    }
    
    @Test
    public void testGetEdgesRectangle() {
        Node<String> vertex_a = new Node<String>("A");
        Node<String> vertex_b = new Node<String>("B");
        Node<String> vertex_c = new Node<String>("C");
        Node<String> vertex_d = new Node<String>("D");
               
        vertex_a.addEdge(vertex_b);
        vertex_a.addEdge(vertex_d);
        
        vertex_b.addEdge(vertex_a);
        vertex_b.addEdge(vertex_c);
        
        vertex_c.addEdge(vertex_b);
        vertex_c.addEdge(vertex_d);

        vertex_d.addEdge(vertex_a);
        vertex_d.addEdge(vertex_c);
        
        List<Node<String>> adjacencies_a = vertex_a.getEdges();
        assertEquals(2, adjacencies_a.size());
        assertTrue(adjacencies_a.contains(vertex_b));
        assertTrue(adjacencies_a.contains(vertex_d));
        
        List<Node<String>> adjacencies_b = vertex_b.getEdges();
        assertEquals(2, adjacencies_b.size());
        assertTrue(adjacencies_b.contains(vertex_a));
        assertTrue(adjacencies_b.contains(vertex_c));
        
        List<Node<String>> adjacencies_c = vertex_c.getEdges();
        assertEquals(2, adjacencies_c.size());
        assertTrue(adjacencies_c.contains(vertex_b));
        assertTrue(adjacencies_c.contains(vertex_d));
        
        List<Node<String>> adjacencies_d = vertex_d.getEdges();
        assertEquals(2, adjacencies_d.size());
        assertTrue(adjacencies_d.contains(vertex_a));
        assertTrue(adjacencies_d.contains(vertex_c));
    }
}
