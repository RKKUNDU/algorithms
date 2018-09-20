import java.util.Scanner;
//lobb number
//L(m,n)=(2m+1/(n+m+1))* (2n c n+m)
public class LobbNumber
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        System.out.println("Enter value of m");
        int m=sc.nextInt();
        int ans=solve(n,m);
        System.out.println("Lobb Numeber for n="+n+" & m="+m+" is "+ans);
    }
    static int solve(int n,int m)
    {
        int arr[][]=new int [2*n+1][n+m+1];
        int x=  (2*m+1)*BinomialCoefficient(2*n,n+m,arr)/(n+m+1);
      /*   for(int i=0;i<2*n+1;i++)
        {
            for(int j=0;j<n+m+1;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        } */
        return x;
    }
    static int  BinomialCoefficient(int n,int m,int arr[][])
    {
        if(n==m)
            return arr[n][m]=1;
        if(n==0)
            return arr[n][m]=1;
        return arr[n][m]=BinomialCoefficient(n-1,m,arr)*n/(n-m);
        //could used 
        //(n,m)=(n-1.m-1)+(n-1,m)
    }
}
