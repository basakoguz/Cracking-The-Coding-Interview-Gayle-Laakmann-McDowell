import java.util.*;

public class Graph {
    HashMap<Integer, NodeBFS> nodeMap = new HashMap<Integer, NodeBFS>();

    public Graph() {}

    public static class NodeBFS {
        int data;
        LinkedList <NodeBFS> adjacent = new LinkedList<NodeBFS>();

        private NodeBFS (int data) {
            this.data = data;
        }
    }
    public void addNode() {
        Scanner s = new Scanner(System.in);
        if(nodeMap.size()==0){
            System.out.println();
            System.out.print("Please enter value of the new node: ");
            int firstNodeData = s.nextInt();
            NodeBFS firstNode = new NodeBFS(firstNodeData);
            nodeMap.put(firstNode.data, firstNode);
        } else {
            System.out.println();
            System.out.print("Please enter value of the new node: ");
            int data = s.nextInt();
            System.out.print("Please enter predecessor value of the new node: ");
            int predecessor = s.nextInt();
            addNode(data, predecessor);
        }
    }

    private void addNode(int data, int predecessor) {
        if(nodeMap.containsKey(data)) {
            getNode(predecessor).adjacent.add(getNode(data));
            System.out.println();
            System.out.println("Node " + data + " already exists. Connecting it to the additional predecessor " + predecessor + "...");
        }else if(!nodeMap.containsKey(data)) {
            NodeBFS newNode = new NodeBFS(data);
            NodeBFS predecessorNode = getNode(predecessor);
            predecessorNode.adjacent.add(newNode);
            nodeMap.put(newNode.data, newNode);
        }

    }

    public NodeBFS getNode(int data) {
        return nodeMap.get(data);
    }

    public boolean hasPathBFS(int source, int destination) {
        NodeBFS sourceNode = getNode(source);
        NodeBFS destinationNode = getNode(destination);
        return hasPathBFS(sourceNode, destinationNode);
    }

    public boolean hasPathBFS(NodeBFS source, NodeBFS destination) {
        HashSet <Integer> visited = new HashSet<Integer>();
        LinkedList <NodeBFS> visitNext = new LinkedList<NodeBFS>();
        visitNext.add(source);
        while(!visitNext.isEmpty()) {
            NodeBFS node = visitNext.remove();
            if(node == destination) {
                return true;
            }
            if(visited.contains(node.data)) {
                continue;
            }
            visited.add(node.data);
            for(NodeBFS adjacentNode : node.adjacent) {
                visitNext.add(adjacentNode);
            }
        }
        return false;
    }

    public void printGraph() {
        if(nodeMap.size()==0) {
            System.out.println();
            System.out.println("Graph is empty!");
            System.out.println();
        } else {
            HashSet <Integer> visited = new HashSet<Integer>();
            LinkedList <NodeBFS> visitNext = new LinkedList<NodeBFS>();
            visitNext.add(nodeMap.get(1));
            while(!visitNext.isEmpty()) {
                NodeBFS node = visitNext.remove();
                if(visited.contains(node.data)) {
                    continue;
                }
                visited.add(node.data);
                System.out.print("Node with the value " + node.data + " has adjacents: ");
                for(NodeBFS adjacentNode : node.adjacent) {
                    System.out.print(adjacentNode.data + " ");
                    visitNext.add(adjacentNode);
                }
                System.out.println();
            }
        }
    }

    public static void main (String[] args) {
        Graph myGraph = new Graph();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        myGraph.addNode();
        System.out.println(myGraph.hasPathBFS(5, 9));
    }

}
