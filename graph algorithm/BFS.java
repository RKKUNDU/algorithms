import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS
{
    public static void main(String a[])
    {
        Graph g=new Graph(9);
        /* g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(4,8);
        g.addEdge(5,8);
        g.addEdge(6,8);
        g.addEdge(7,8); */
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(5,7);
        g.addEdge(5,8);
        //g.addEdge(3,8);
        //g.addEdge(3,4);
        g.printGraph();
        g.BFSUtil(1);
        g.BFT();
    }
}
class Graph
{
    int n;
    LinkedList adj[];
    Queue<Integer> q;
    boolean visited[];
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
        adj[dest].add(src);
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
    void BFSUtil(int start)
    {
        q=new LinkedList<Integer>();
        visited=new boolean[n];
        System.out.print("BFS order : ");
        BFS(start);

    }
    void BFS(int start)
    {
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty())
        {
            int el=q.poll();
            System.out.print(el+" ");
            Iterator<Integer> itr=adj[el].iterator();
            while(itr.hasNext())
            {
                int x=itr.next();
                if(!visited[x])
                {
                    q.add(x);
                    visited[x]=true;
                }    
            }
        }
    }
    void BFT()
    {
        q=new LinkedList<Integer>();
        visited=new boolean[n];
        System.out.print("BFT : ");
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                BFS(i);
        }

    }
    void showQueue()
    {
        Iterator<Integer> itr=q.iterator();
        System.out.print("Queue -> ");
        while(itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }
        System.out.println(".....");
    }
} 
