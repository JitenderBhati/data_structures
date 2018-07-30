import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.w3c.dom.Node;

class graph
{
    LinkedHashMap<node, LinkedList<node>> graph;
    public graph()
    {
        graph = new LinkedHashMap<>();
    } 

    public boolean addEdge(node u, node v)
    {
        if(graph==null)
        {
            graph = new LinkedHashMap<>();
            LinkedList<node> adj = new LinkedList<>();
            LinkedList<node> adj1 = new LinkedList<>();
            adj.add(v);
            adj1.add(u);
            graph.put(u, adj);
            graph.put(v, adj1);
            return true;
        }
        else
        {
            if(graph.containsKey(u))
            {
                LinkedList<node> adj = graph.get(u);
                adj.add(v);
                graph.put(u,adj);
                if(graph.containsKey(v))
                {
                    LinkedList<node> adj1 = graph.get(v);
                    adj1.add(u);
                    graph.put(v,adj1);
                }
                else
                {
                    LinkedList<node> adj1 = new LinkedList<>();
                    adj1.add(u);
                    graph.put(v, adj1); 
                }
                return true;
            }
            else
            {
                LinkedList<node> adj = new LinkedList<>();
                LinkedList<node> adj1 = new LinkedList<>();
                adj.add(v);
                adj1.add(u);
                graph.put(u, adj);
                graph.put(v, adj1);
                return true;
            }
        }
    }

    public void traverse()
    {
        for(Map.Entry<node, LinkedList<node>> data: graph.entrySet())
        {
            ArrayList<Integer> ar = new ArrayList<>();
            node obj = data.getKey();
            LinkedList<node> obj1 = data.getValue();
            for(node fre:obj1)
            {
                ar.add(fre.value);
            }

            System.out.println(obj.value+ "->"+ ar);
        }
    }
}