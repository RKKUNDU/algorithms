import java.util.Scanner;
public class LongestCommonSubsequence
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        String str1,str2;
        System.out.println("Enter String 1");
        str1=sc.nextLine();
        System.out.println("Enter String 2");
        str2=sc.nextLine();
        int ans=solve(str1,str2);
        System.out.println("Length of the longest common subsequence "+ans);

    }
    static int solve(String str1,String str2)
    {
        //str1 in column
        //str2 in row
        /*
            str1-------------->  (n)
        s   ???????????????????
        t   ???????????????????
        r   ???????????????????
        2   ???????????????????
        (m) ???????????????????

        */
        int n=str1.length();
        int m=str2.length();
        int arr[][]=new int[m+1][n+1];
        for(int i=0;i<n+1;i++)
        {
            arr[0][i]=0;
        }
        for(int i=0;i<m+1;i++)
        {
            arr[i][0]=0;
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(str1.charAt(j-1)==str2.charAt(i-1))
                {
                    arr[i][j]=1+arr[i-1][j-1];
                }
                else{
                    arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr[m][n];
    }
    static int max(int a,int b)
    {
        return a>b?a:b;
    }
}
