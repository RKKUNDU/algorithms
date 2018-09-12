import java.util.Scanner;
public class SubsetSum
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of elements");
        int n=sc.nextInt();
        System.out.println("Enter "+(n)+" element");
        int array[]=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println("Enter key");
        int key=sc.nextInt();
        boolean ans=solve(array,key);
        System.out.println("Is subset sum possible ? \n->"+ans);

    }
    static boolean solve(int array[],int key)
    {
        int n=array.length;
        int w=key;
        boolean arr[][]=new boolean[n+1][w+1];
        for(int i=0;i<n+1;i++)
        {
            arr[i][0]=true;
        }
        for(int i=1;i<w+1;i++)
        {
            arr[0][i]=false;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(array[i-1]>j)
                {
                    arr[i][j]=arr[i-1][j];
                }
                else{
                    arr[i][j]=arr[i-1][j] || arr[i-1][j-array[i-1]];
                }
            }
        }
        return arr[n][w];
    }
}
