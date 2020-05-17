import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class TestNode {
    @Test
    public void testGetId(){
        Node node = new Node(1);

        assertEquals(1, node.getId());
    }

    @Test
    public void testEndNode(){
        Node node = new Node(1);

        node.setEndNode();

        assertTrue(node.isEndNode());

        node = new Node(1);

        assertFalse(node.isEndNode());
    }

    @Test
    public void testAddNode(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.addNode(node2);
        
        assertEquals(1, node1.getNodeAmount());
    }

    @Test
    public void testTravelNodeWithChance(){
        Node node1 = new Node(1);

        assertEquals(node1.getId(), node1.travelNodeWithChance().getId());

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.addNode(node2);
        node1.addNode(node3);

        node1.setEndNode();

        assertEquals(node1.getId(), node1.travelNodeWithChance().getId());
    }

    @Test
    public void testTravelNodeWithString(){
        Node node1 = new Node(1);

        assertEquals(node1.getId(), node1.travelNodeWithString("A").getId());
        assertEquals(node1.getId(), node1.travelNodeWithString("B").getId());
        assertEquals(node1.getId(), node1.travelNodeWithString("C").getId());

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.addNode(node2);
        node1.addNode(node3);
        
        assertEquals(node2.getId(), node1.travelNodeWithString("A").getId());
        assertEquals(node3.getId(), node1.travelNodeWithString("B").getId());
    }
}