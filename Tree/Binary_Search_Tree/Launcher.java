import java.util.*;

public class Launcher
{
    public static void main(String[] args)
    {
        Tree obj = new Tree();
        for(int i=0; i<10; i++)
        {            
            obj.addData(new Random().nextInt(50));
        }
        obj.print();
        Node node = obj.search(25);
        if(node!=null)
        {
            System.out.print("Found! " + node.data);
        }
        else
        {
            System.out.println("Data Not Found");
        }

        
    }
}