import java.util.Scanner;
//Given a n*n matrix where all numbers are distinct, find the maximum length path 
//(starting from any cell) such that all cells along the path are in increasing order with 
//a difference of 1.
//We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or 
//(i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.
public class LongestPathInAMatrix
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of rows");
        int n=sc.nextInt();
        int array[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter "+(n)+" element of row "+(i+1));
            for(int j=0;j<n;j++)
            {
                array[i][j]=sc.nextInt();
            }
        }
        int ans=solve(array);
        System.out.println("The longest path in the matrix is "+ans);
    }
    static int solve(int array[][])
    {
        int n=array.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[i][j]==-1)
                {
                    func(i,j,array,dp);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(dp[i][j]+" ");
                if(max<dp[i][j])
                    max=dp[i][j];
            }
            System.out.println();
        }
        return max;
    }
    static int func(int i,int j,int arr[][],int dp[][])
    {
        int n=arr.length;
        if(i<0||j<0||i>=n||j>=n)
            return 0;
        if(i+1<n&&arr[i+1][j]-arr[i][j]==1)
        {
            return dp[i][j]=func(i+1,j,arr,dp)+1;
        }    
        else if(i>0&&arr[i-1][j]-arr[i][j]==1)
        {
            return dp[i][j]=func(i-1,j,arr,dp)+1;
        }
        else if(j<n-1&&arr[i][j+1]-arr[i][j]==1)
        {
            return dp[i][j]=func(i,j+1,arr,dp)+1;
        }
        else if(j>0&&arr[i][j-1]-arr[i][j]==1)
        {
            return dp[i][j]=func(i,j-1,arr,dp)+1;
        }
        return dp[i][j]=1;
    }
}
