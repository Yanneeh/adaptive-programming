import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class World {

    private List<Node> nodes = new ArrayList<Node>();

    public void setupNodes(int n){

        // TODO: test if length of nodes is n.

        nodes.clear();

        for(int i = 0; i < n; i++){
            nodes.add(new Node(i));
        }
    }

    public void clearNodes(){

        // TODO: test if length of nodes is 0.

        nodes.clear();
    }

    public void setupSixSidedDice() throws Exception{

        // TODO: test if nodes[3] has a connection to nodes[1].
        // TODO: test if nodes[10] is an endnode.
        // TODO: test exception if nodes is empty.
        // TODO: test exception if nodes length is not big enough.

        if(!nodes.isEmpty()){
            if(nodes.size() > 12){
                nodes.get(0).addNode(nodes.get(1));
                nodes.get(0).addNode(nodes.get(2));

                nodes.get(1).addNode(nodes.get(3));
                nodes.get(1).addNode(nodes.get(4));

                nodes.get(2).addNode(nodes.get(5));
                nodes.get(2).addNode(nodes.get(6));

                nodes.get(3).addNode(nodes.get(1));
                nodes.get(3).addNode(nodes.get(7));

                nodes.get(4).addNode(nodes.get(8));
                nodes.get(4).addNode(nodes.get(9));

                nodes.get(5).addNode(nodes.get(10));
                nodes.get(5).addNode(nodes.get(11));

                nodes.get(6).addNode(nodes.get(2));
                nodes.get(6).addNode(nodes.get(12));

                nodes.get(7).setEndNode();
                nodes.get(8).setEndNode();
                nodes.get(9).setEndNode();
                nodes.get(10).setEndNode();
                nodes.get(11).setEndNode();
                nodes.get(12).setEndNode();
            } else{
                throw new Exception("Not enough nodes added");
            }
        } else{
            throw new Exception("No nodes added");
        }
    }

    public void setupEigthSidedDice() throws Exception{

        // TODO: test if nodes[6] has a connection to nodes[14].
        // TODO: test if nodes[14] is an endnode.
        // TODO: test exception if nodes is empty.
        // TODO: test exception if nodes length is not big enough.

        if(!nodes.isEmpty()){
            if(nodes.size() > 14){
                nodes.get(0).addNode(nodes.get(1));
                nodes.get(0).addNode(nodes.get(2));

                nodes.get(1).addNode(nodes.get(3));
                nodes.get(1).addNode(nodes.get(4));

                nodes.get(2).addNode(nodes.get(5));
                nodes.get(2).addNode(nodes.get(6));

                nodes.get(3).addNode(nodes.get(1));
                nodes.get(3).addNode(nodes.get(7));

                nodes.get(4).addNode(nodes.get(8));
                nodes.get(4).addNode(nodes.get(9));

                nodes.get(5).addNode(nodes.get(10));
                nodes.get(5).addNode(nodes.get(11));

                nodes.get(6).addNode(nodes.get(2));
                nodes.get(6).addNode(nodes.get(12));

                nodes.get(6).addNode(nodes.get(13));
                nodes.get(6).addNode(nodes.get(14));

                nodes.get(7).setEndNode();
                nodes.get(8).setEndNode();
                nodes.get(9).setEndNode();
                nodes.get(10).setEndNode();
                nodes.get(11).setEndNode();
                nodes.get(12).setEndNode();
                nodes.get(13).setEndNode();
                nodes.get(14).setEndNode();
            } else{
                throw new Exception("Not enough nodes added");
            }
        } else{
            throw new Exception("No nodes added");
        }
    }

    public void setupNetwork() throws Exception{

        // TODO: test if nodes[2] has a connection to nodes[3].
        // TODO: test exception if nodes is empty.
        // TODO: test exception if nodes length is not big enough.

        if(!nodes.isEmpty()){
            if(nodes.size() > 3){
                nodes.get(0).addNode(nodes.get(2));
                nodes.get(0).addNode(nodes.get(1));

                nodes.get(1).addNode(nodes.get(1));
                nodes.get(2).addNode(nodes.get(2));

                nodes.get(2).addNode(nodes.get(3));

                nodes.get(3).addNode(nodes.get(3));
                nodes.get(3).addNode(nodes.get(0));
            } else{
                throw new Exception("Not enough nodes added");
            }
        } else{
            throw new Exception("No nodes added");
        }
    }

    public void travelDice(int startPoint) throws Exception{
        
        // TODO: test exception if nodes is empty.
        // TODO: test exception if startpoint doesn't exists.

        if(!nodes.isEmpty()){
            if(nodes.size() > startPoint){
                // set new node to first node;
                Node newNode = nodes.get(startPoint);
                System.out.println("Starting point: " + newNode.toString());
        
                // travel path route.
                while(true){
                    newNode = newNode.travelNodeWithChance();
                    System.out.println("New location: " + newNode.toString());
                    if(newNode.isEndNode()){
                        System.out.println("Endnode reached...");
                        break;
                    }
                }
            } else {
                throw new Exception("Startpoint not possible");
            }
        } else{
            throw new Exception("No nodes added");
        }
    }

    public int[] travelString(int startPoint, String[] path) throws Exception{

        // TODO: test exception if nodes is empty.
        // TODO: test path with a known correct path.
        // TODO: test exception if startpoint doesn't exists.

        if(!nodes.isEmpty()){
            if (nodes.size() > startPoint){
                int[] route = new int[path.length];

                // set new node to first node;
                Node newNode = nodes.get(startPoint);
                System.out.println("Starting point: " + newNode.toString());

                // travel path route.
                for(int i = 0; i < path.length; i++){
                    newNode = newNode.travelNodeWithString(path[i]);
                    System.out.println("New location: " + newNode.toString());
                    route[i] = newNode.getId();
                }

                return route;
            } else{
                throw new Exception("Startpoint not possible");
            }
        } else{
            throw new Exception("No nodes added");
        }
    }
}