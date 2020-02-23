package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//import for Scanner and other utility classes


/**
 * Created by amit on 21/11/18.
 */
public class HackerrankCapilaryJavaChalenge16 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            WeightedGraph weightedGraph =new WeightedGraph(n);
            for (int i=0; i< m ; i++) {
                String line2 = br.readLine();
                String[] strs2 = line2.trim().split("\\s+");
                int source = Integer.parseInt(strs2[0]) - 1;
                int destination = Integer.parseInt(strs2[1]) - 1;
                int weight = Integer.parseInt(strs2[2]);
                weightedGraph.addEdge(source, destination, weight);
            }
            int cost = weightedGraph.getPathSum2();
            if(cost == -1) {
                System.out.println("Need More Dealers");
            } else {
                System.out.println(cost);
            }

        }
    }

}

class WeightedGraph {
    int vertices;
    int minPathSum = Integer.MAX_VALUE;
    class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    LinkedList<Edge>[] linkedLists;
    WeightedGraph(int vertices) {
        this.vertices = vertices;
        linkedLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        linkedLists[source].add(new Edge(source, destination, weight));
        linkedLists[destination].add(new Edge(destination, source, weight));
    }

    public int getPathSum2() {
        int cost = Integer.MAX_VALUE;
        for (int i=0; i<vertices; i++) {
            int currentCost = 0;
            HashSet<Integer> set = new HashSet<>();
            dfs(i, set);
            if(set.size() < vertices-1) {
                return -1;
            }
            cost = Math.min(currentCost, cost);
        }
        return cost;
    }
    public int getCost(int source, int destination) {
        int cost = 0;

        hasDfs(source, destination,cost, new HashSet<Integer>());
        return cost;
    }

    private void hasDfs(int source, int destination, int cost, HashSet<Integer> set)
    {
        if(source == destination) {
            return;
        }
        if(set.contains(source)) {
            return;
        }
        set.add(source);
        for (Edge edge : linkedLists[source]) {
            cost += edge.weight;
            hasDfsPath(edge.destination, destination, set, cost);
        }
    }


    public void dfs(int source, HashSet<Integer> set) {
        if(set.contains(source)) {
            return;
        }
        set.add(source);
        for (Edge edge : linkedLists[source]) {
//            cost += edge.weight;
            dfs(edge.destination, set);
        }
    }

    public int getMinPathSum() {
        int cost = Integer.MIN_VALUE;
        for (int i=0; i<vertices; i++) {
            int currentCost = 0;
            if(!hasDfsPath(i, currentCost)) {
                return -1;
            }
            cost = Math.min(currentCost, cost);
        }
        return cost;
    }

    public boolean hasDfsPath(int source, int cost) {


        for (int i=0; i<vertices; i++) {
            HashSet<Integer> set = new HashSet<>();
            if(i != source) {
                if(!hasDfsPath(source, i, set, cost)) {
                    return false;
                }
            } else {
                set.add(i);
            }

        }
        return true;
    }

    public boolean hasDfsPath(int source, int destination, HashSet<Integer> set, int cost) {
        if(source == destination) {
            return true;
        }
        if(set.contains(source)) {
            return false;
        }
        set.add(source);
        for (Edge edge : linkedLists[source]) {
            cost += edge.weight;
            if(!hasDfsPath(edge.destination, destination, set, cost)) {
                return false;
            }
        }
        return true;
    }




}
