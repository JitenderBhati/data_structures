
class node
{
    int value;
    boolean searched;
    node parent = null;
    public node(int value)
    {
        this.value   = value;
        this.searched = false;
    }
}