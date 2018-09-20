import java.util.Scanner;
//Partition a set into two subsets such that the difference of subset sums is minimum
public class Partition
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
        int ans=solve(array);
        System.out.println("The minimum difference between two sets is "+ans);
    }
    static int solve(int array[])
    {
        int n=array.length;
        int sumTotal=0;
        for(int i=0;i<n;i++)
        {
            sumTotal+=array[i];
        }
        int w=sumTotal;
        boolean arr[][]=new boolean[n+1][w+1];
        for(int i=1;i<w+1;i++)
        {
            arr[0][i]=false;
        }
        for(int i=0;i<n+1;i++)
        {
            arr[i][0]=true;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                //exclude the i'th element ...
                //if already this sum (j) can be formed .then its true else false
                arr[i][j]=arr[i-1][j];
                if(array[i-1]<=j)
                {
                    //include i'th element
                    arr[i][j]=arr[i][j] || arr[i-1][j-array[i-1]];
                    
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=sumTotal/2;i>=0;i--)
        {
            if(arr[n][i])
            {
                min=sumTotal-2*i;
                break;
            }
        }
        return min;
    }
}
