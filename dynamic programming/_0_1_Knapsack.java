import java.util.Scanner;
public class _0_1_Knapsack
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter Capacity of the Knapsack");
        int capacity=sc.nextInt();
        System.out.println("Enter no of objects");
        n=sc.nextInt();
        System.out.println("Enter "+(n)+" Profit");
        int profit[]=new int[n];
        for(int i=0;i<n;i++)
        {
            profit[i]=sc.nextInt();
        }
        System.out.println("Enter "+(n)+" Weight");
        int weight[]=new int[n];
        for(int i=0;i<n;i++)
        {
            weight[i]=sc.nextInt();
        }

        int ans=solve(profit,weight,capacity);
        System.out.println("Maximum profit is "+ans);

    }
    static int solve(int profit[],int weight[],int capacity)
    {
        int n=profit.length;
        int w=capacity;
        int arr[][]=new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
        {
            arr[i][0]=0;
        }
        for(int i=0;i<w+1;i++)
        {
            arr[0][i]=0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(weight[i-1]>j)
                {
                    arr[i][j]=arr[i-1][j];
                }
                else{
                    if(arr[i-1][j]>profit[i-1]+arr[i-1][j-weight[i-1]])
                    {
                        arr[i][j]=arr[i-1][j];
                    }
                    else{
                        arr[i][j]=profit[i-1]+arr[i-1][j-weight[i-1]];
                        capacity-=weight[i-1];
                    }
                }
            }
        }
        return arr[n][w];
    }
}
