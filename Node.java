import java.lang.Math;
import java.util.*;
import java.lang.Exception;

public class Node {

	private int id;
	private List<Node> nodes = new ArrayList<Node>();
	private boolean endNode = false;

	public Node(int id){
		this.id = id;
	}

	public String toString(){
		return Integer.toString(this.id);
	}

	public int getId(){
		return this.id;
	}

	public int getNodeAmount(){
		return this.nodes.size();
	}

	public void setEndNode(){
		this.endNode = true;
	}

	public boolean isEndNode(){
		return this.endNode;
	}

	public void addNode(Node n){
		this.nodes.add(n);
	}

	public Node travelNodeWithChance(){
		
		if(!this.nodes.isEmpty()){
			if (!this.endNode){
				int n = (int) Math.floor(Math.random() * this.nodes.size());
	
				return this.nodes.get(n);
			} else {
				return this;
			}	
		} else {
			return this;
		}
    }
    
    public Node travelNodeWithString(String s){
		
		if(this.nodes.size() > 2){
			if (s == "A"){
				if (this.nodes.get(0) != null){
					return this.nodes.get(0);
				} else {
					return this;
				}
			} else if (s == "B"){
				if (this.nodes.get(1) != null){
					return this.nodes.get(0);
				} else {
					return this;
				}
			} else {
				return this;
			}
		} else {
			return this;
		}
	}
}