public class Main {
    public static void main(String[] args) throws Exception {
        World world = new World();

        String[] path = {"A", "A", "B", "A"};
        world.travelString(0, path);
    }
}