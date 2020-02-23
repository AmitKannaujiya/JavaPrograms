package graph;

import java.util.List;

public class GraphTraversalHackerRank {
    public static void main(String[] args) {
        Graph1 graph1 = new Graph1();
        Graph1.Node src = graph1.new Node(1);

        Graph1.Node srcChild2 = graph1.new Node(2);
        Graph1.Node srcChild3 = graph1.new Node(3);
        Graph1.Node srcChild4 = graph1.new Node(4);
        Graph1.Node srcChild5 = graph1.new Node(5);


        graph1.addNode(src);
        graph1.addNode(srcChild2);
        graph1.addNode(srcChild3);
        graph1.addNode(srcChild4);
        graph1.addNode(srcChild5);

        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 5);

        List<Integer> list = graph1.dfs(1, 5);
        for (Integer in : list) {
            System.out.print("->" + in);
        }

    }
}
