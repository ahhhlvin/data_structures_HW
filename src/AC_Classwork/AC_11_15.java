package AC_Classwork;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by alvin2 on 11/15/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class AC_11_15
{


    /**
     * Created by alvin2 on 11/15/15.
     * Alvin Kuang
     * C4Q Access Code 2.1
     */
    public static class Graph
    {
        HashMap<String, Vertex> vertices;


        public Graph()
        {
            vertices = new HashMap<>();
        }


        // "..." creates a list/array of iterables to increase efficiency !
        public void addVertices(String... names)
        {
            for(String name : names)
            {
                addVertex(name);
            }
        }

        public void addVertex(String name)
        {
            vertices.put(name, new Vertex(name));
        }

        public void addDirectedEdge(String from, String to, int weight)
        {
            Vertex fromVertex = vertices.get(from);
            Vertex toVertex = vertices.get(to);

            if(fromVertex == null || toVertex == null)
            {
                return;
            }

            fromVertex.neighbors.put(toVertex, weight);
        }

        public void addUndirectedEdge(String from, String to, int weight)
        {
            addDirectedEdge(from, to, weight);
            addDirectedEdge(to, from, weight);

        }

        public Set<Vertex> getNeighbors (String name) {
            Vertex v = vertices.get(name);
            if (v == null) {
                return Collections.EMPTY_SET;
            }

            return v.getNeighbors();
        }


        public int getWeight(String from, String to)
        {
            Vertex fromVertex = vertices.get(from);
            Vertex toVertex = vertices.get(to);
            if(fromVertex == null || toVertex == null)
            {
                return - 1;
            }

            Integer weight = fromVertex.neighbors.get(toVertex);
            if(weight == null) throw new IllegalStateException("Edge doesn't exist!");

        return weight;
        }

    }

    /**
     * Created by alvin2 on 11/15/15.
     * Alvin Kuang
     * C4Q Access Code 2.1
     */
    public static class Vertex
    {
        // name of vertex
        String name;

        // vertices of the neighbor from current vertex and their individual weights (int)
        HashMap<Vertex, Integer> neighbors;

        public Vertex(String name)
        {
            this.name = name;
            this.neighbors = new HashMap<>();
        }

        public Set<Vertex> getNeighbors()
        {
            return neighbors.keySet();
        }

        @Override
        public String toString()
        {
            return name;
        }
    }


    public static void main(String[] args)
    {


        Graph listGraph = new Graph();

        listGraph.addVertex("V1");
        listGraph.addVertex("V2");
        listGraph.addVertex("V3");
        listGraph.addVertex("V4");
        listGraph.addVertex("V5");
        listGraph.addVertex("V6");
        listGraph.addVertex("V7");

        // OR

//        listGraph.addVertices("V1", "V2", "V3", "V4", "V5", "V6", "V7");


        listGraph.addDirectedEdge("V1", "V4", 1);
        listGraph.addDirectedEdge("V1", "V2", 2);
        listGraph.addDirectedEdge("V2", "V4", 3);
        listGraph.addDirectedEdge("V2", "V5", 10);
        listGraph.addDirectedEdge("V3", "V6", 5);
        listGraph.addDirectedEdge("V3", "V1", 4);
        listGraph.addDirectedEdge("V4", "V5", 2);
        listGraph.addDirectedEdge("V4", "V7", 4);
        listGraph.addDirectedEdge("V4", "V6", 8);
        listGraph.addDirectedEdge("V4", "V3", 2);
        listGraph.addDirectedEdge("V5", "V7", 4);
        listGraph.addDirectedEdge("V7", "V6", 1);

        System.out.println(listGraph.getWeight("V1", "V5"));
    }
}
