import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CycleDetection_trying
{
    public static void main(String a[])
    {
        Graph g=new Graph(9);
        /* 
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(4,8);
        g.addEdge(5,8);
        g.addEdge(6,8);
        g.addEdge(7,8);  */
        g.addEdge(1, 2);
        g.addEdge(1,3);
        g.addEdge(3,2 );
        g.addEdge(2, 1);
        /*  
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(5,7);
        g.addEdge(5,8); */
        g.printGraph();
        g.DFSUtil(1);
        //g.BFT();
    }
}
class Graph
{
    int n;
    LinkedList adj[];
    boolean visited[];
    Stack<Integer> recursionStack;
    Graph(int n)
    {
        adj=new LinkedList[n];
        this.n=n;
        for(int i=0;i<n;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    void printGraph()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(i+"->");
            Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                System.out.print(itr.next()+" ");
            }
            System.out.println();
        }
    }
    void DFSUtil(int start)
    {
        visited=new boolean[n];
        recursionStack=new Stack<>(); 
        DFS(start);

    }
    void DFS(int start)
    {
        System.out.print(start+" ");
        visited[start]=true;
        recursionStack.add(start);
        Iterator<Integer> itr=adj[start].iterator();
        while(itr.hasNext())
        {
            int x=itr.next();
            if(recursionStack.contains(x))
            {
                System.out.println("there is a cycle due to "+x);
            }
            if(!visited[x])
            {
                DFS(x);
            }                
        }   
        Object o=new Integer(start);
        recursionStack.remove(o);
    }
} 
