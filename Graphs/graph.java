import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.*;

import org.w3c.dom.Node;

class graph {
    LinkedHashMap<node, LinkedList<node>> graph;

    public graph() {
        graph = new LinkedHashMap<>();
    }

    public boolean addEdge(node u, node v) {
        if (graph == null) {
            graph = new LinkedHashMap<>();
            LinkedList<node> adj = new LinkedList<>();
            LinkedList<node> adj1 = new LinkedList<>();
            adj.add(v);
            adj1.add(u);
            graph.put(u, adj);
            graph.put(v, adj1);
            return true;
        } else {
            if (graph.containsKey(u)) {
                LinkedList<node> adj = graph.get(u);
                adj.add(v);
                graph.put(u, adj);
                if (graph.containsKey(v)) {
                    LinkedList<node> adj1 = graph.get(v);
                    adj1.add(u);
                    graph.put(v, adj1);
                } else {
                    LinkedList<node> adj1 = new LinkedList<>();
                    adj1.add(u);
                    graph.put(v, adj1);
                }
                return true;
            } else {
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

    public void traverse() {
        for (Map.Entry<node, LinkedList<node>> data : graph.entrySet()) {
            ArrayList<Integer> ar = new ArrayList<>();
            node obj = data.getKey();
            LinkedList<node> obj1 = data.getValue();
            for (node fre : obj1) {
                ar.add(fre.value);
            }

            System.out.println(obj.value + "->" + ar);
        }
    }

    public void bfs(node obj, node obj1) {
        ArrayDeque<node> queu = new ArrayDeque<>();
        queu.add(obj);
        obj.searched = true;
        // System.out.println(first.value);
        while (!queu.isEmpty()) {
            node first = queu.remove();
            // System.out.println(first.value);
            if (first.value == obj1.value) {
                // System.out.println("Found " + obj1.value);
                break;
            }
            // System.out.println(first.value);
            LinkedList<node> adj = graph.get(first);
            for (node fre : adj) {
                if (fre.searched == false) {
                    // System.out.println(fre.value);
                    fre.parent = first;
                    queu.add(fre);
                    fre.searched = true;
                }
            }
        }

        ArrayList<node> ar = new ArrayList<>();
        ar.add(obj1);
        node next = obj1.parent;
        while (next != null) {
            ar.add(next);
            next = next.parent;
        }
        Collections.reverse(ar);
        String s = "";
        for (node n : ar) {
            s = s + (n.value + "->");
            // System.out.print(n.value);
        }
        System.out.println(s.substring(0, s.length() - 2));

    }

    public void dfs(node node1) {
        System.out.println(node1.value);
        node1.searched = true;
        LinkedList<node> nod = graph.get(node1);
        for (node bj : nod) {
            if (bj.searched == false) {
                dfs(bj);
            }
        }
    }
}