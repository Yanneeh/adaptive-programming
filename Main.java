public class Main {
    public static void main(String[] args) throws Exception {
        World world = new World();

        world.setupNodes(4);
        world.setupNetwork();

        String[] path = {"A", "B", "A", "A"};
        world.travelString(0, path);

        world.clearNodes();

        world.setupNodes(13);

        world.setupSixSidedDice();

        world.travelDice(0);

        world.clearNodes();

        world.setupNodes(15);

        world.setupEigthSidedDice();

        world.travelDice(0);
    }
}