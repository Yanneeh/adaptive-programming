import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestWorld {
    @Test
    public void testSetupNodes(){
        World world = new World();

        world.setupNodes(13);

        assertEquals(13, world.getNodeAmount());
    }

    @Test
    public void testClearNodes(){
        World world = new World();

        world.setupNodes(13);

        world.clearNodes();

        assertEquals(0, world.getNodeAmount());
    }
}