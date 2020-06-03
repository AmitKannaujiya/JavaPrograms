package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourceScheduleLeetCode {
    public static void main(String[] args) {
        CourceScheduleLeetCode obj = new CourceScheduleLeetCode();
        int [][] nodes = new int[][]{{1,0}};
        System.out.println(obj.canFinish(2, nodes));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        graph.buildGraph(prerequisites);

        return isCircle(graph);
    }

    private  boolean isCircle(Graph graph) {
        Set<Integer> white = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        Set<Integer> gray = new HashSet<>();
        for(Map.Entry<Integer,Graph.Node> entry : graph.table.entrySet())  {
            white.add(entry.getKey());
        } 
        while (white.size() > 0) {
            int nodeId = white.iterator().next();
            if(isCircle(graph, nodeId, white, gray, black)) {
                return true;
            }
        }   

        return false;
    }

    private boolean isCircle(Graph graph, int nodeId, Set<Integer> white, Set<Integer> gray, Set<Integer> black) {
        moveNode(nodeId, white, gray);

        Graph.Node node = graph.getNode(nodeId);
        for(Graph.Node children : node.adjList) {
            if(black.contains(children.id)) {
                continue;
            }
            if(gray.contains(children.id)) {
                return true;
            }
            if(isCircle(graph, children.id, white, gray, black)) {
                return true;
            }
        }
        moveNode(nodeId, gray, black);
        return false;
    }

    private void moveNode(int nodeId, Set<Integer> source, Set<Integer> dest) {
        source.remove(nodeId);
        dest.add(nodeId);
    }
}



class Graph {
    HashMap<Integer, Node> table = new HashMap<>();
    int size = 0;
    class Node {
        int id;
        List<Node> adjList = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }
    }

    public void incrementSize() {
        this.size++;
    }

    public int size() {
        return this.size;
    }
    public Node getNode(int id) {
        if(table.containsKey(id)) {
            return table.get(id);
        }
        return null;
    }

    public void addEdge(Node u, Node v) {
        u.adjList.add(v);
    }
    public void addNode(Node node) {
        if(!this.table.containsKey(node.id)) {
            this.incrementSize();
        } 
        this.table.put(node.id, node);
    }

    public void buildGraph(int[][] nodes) {
        for(int i =0; i < nodes.length; i++) {
            int sourceId = nodes[i][0];
            int destinationId = nodes[i][1];
            Node source = this.getNode(sourceId);
            if(source == null) {
                source = new Node(sourceId);
                this.addNode(source);

            }
            Node dest = this.getNode(destinationId);
            if(dest ==  null) {
                dest = new Node(destinationId);
                this.addNode(dest);
            }
            this.addEdge(source, dest);
        }
    }

}