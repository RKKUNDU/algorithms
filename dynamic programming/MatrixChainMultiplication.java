import java.util.Scanner;

public class MatrixChainMultiplication
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter value of n");
        n=sc.nextInt();
        System.out.println("Enter "+(n+1)+" value of dimension");
        int dimension[]=new int[n+1];
        for(int i=0;i<n+1;i++)
        {
            dimension[i]=sc.nextInt();
        }
        int ans=solve(dimension);
        System.out.println("Minimum cost for this matrix chain multiplication is "+ans);

    }
    static int solve(int dimension[])
    {
        int n=dimension.length-1;
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            arr[i][i]=0;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n-i;j++)
            {
                int l=j+i;
                arr[j][l]=Integer.MAX_VALUE;
                for(int k=j;k<l;k++)
                {
                    int x=arr[j][k]+arr[k+1][l]+dimension[j]*dimension[k+1]*dimension[l+1];
                    if(x<arr[j][l])
                    {
                        arr[j][l]=x;
                    }
                }
            }
        }
        return arr[0][n-1];
    }
}
