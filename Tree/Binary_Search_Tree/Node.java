public class Node
{
    int data;
    Node left, right;

    public Node()
    {
        this.data=0;
        this.left=null;
        this.right=null;
    }

    public Node(int n)
    {
        this.data=n;
        this.right=null;
        this.left=null;
    }
}