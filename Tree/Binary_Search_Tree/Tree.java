public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public void addData(int data) {
        root = insertData(root, data);
    }

    private Node insertData(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) {
            root.left = insertData(root.left, data);
        } else if (data > root.data) {
            root.right = insertData(root.right, data);
        }
        return root;
    }

    public void print() {
        traverse(root);
    }

    private void traverse(Node root) {
        if (root == null) {
            System.out.println("Cannot traverse");
        } else {
            if (root.left != null) {
                traverse(root.left);
            }
            System.out.println(root.data);
            if (root.right != null) {
                traverse(root.right);
            }
        }
    }

    public Node search(int data) {
        return searchData(root, data);
    }

    private Node searchData(Node root, int data) {
        if (root.data == data) {
            return root;
        } else if (data < root.data) {
            if(root.left!=null)
            return searchData(root.left, data);
        } else if (data > root.data) {
            if(root.right!=null)
            return searchData(root.right, data);
        }

        return null;
    }
}