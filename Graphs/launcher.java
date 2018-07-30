class launcher {
    public static void main(String[] args) {
        graph obj = new graph();
        node node1 = new node(1);
        node node2 = new node(2);
        node node3 = new node(3);
        node node4 = new node(4);
        node node5 = new node(5);

        obj.addEdge(node1, node2);
        obj.addEdge(node1, node4);
        obj.addEdge(node1, node5);
        obj.addEdge(node2, node3);
        obj.addEdge(node3, node4);
        obj.addEdge(node4, node5);

        // obj.traverse();

        obj.bfs(node1, node5);

    }
}