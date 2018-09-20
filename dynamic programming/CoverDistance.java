import java.util.Scanner;
//Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
public class CoverDistance
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of elements");
        int n=sc.nextInt();
        int ans=solve(n);
        System.out.println("Number of ways to cover the distance "+ans);
    }
    static int solve(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++)
        {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
