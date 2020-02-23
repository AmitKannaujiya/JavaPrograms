package graph;

import java.util.*;

public class Graph1 {
    HashMap<Integer, Node> lookupTable = new HashMap<>();
    class Node {
        int id;
        LinkedList<Node> adj = new LinkedList<>();
        Node(int id) {
            this.id = id;
        }
    }

    public Node getNode(int id) {
        if(lookupTable.containsKey(id)) {
            return lookupTable.get(id);
        }
        return null;
    }

    public void addEdge(int src, int des) {
        Node u = getNode(src);
        Node v = getNode(des);
        u.adj.add(v);
    }

    public void addNode(Node node) {
        lookupTable.put(node.id, node);
    }

    public List<Integer> dfs(int source, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        Node src = getNode(source);
        Node dst = getNode(dest);
        if(src == null) {
            throw new NullPointerException("No Source Exists");
        }
        if(dst == null) {
            throw new NullPointerException("No Destination Exists");
        }
        List<Integer> list = new ArrayList<>();
        dfs(src, dst, visited, list);
        return list;
    }
     private void dfs(Node src, Node dest, HashSet<Integer> set, List<Integer> list) {
        if(src == dest) {
            return;
        }
        set.add(src.id);
        list.add(src.id);
        for (Node node : src.adj) {
            if(!set.contains(node.id)) {
                dfs(node, dest, set, list);
            }
        }
     }



}
