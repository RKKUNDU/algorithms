import java.util.Scanner;
// Given two strings str1 and str2 and below operations that can be performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
// Insert
// Remove
// Replace
public class EditDistance
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
        System.out.println("Minimum Edit Cost "+ans);
    }
    static int solve(String str1,String str2)
    {
        int n=str1.length();
        int m=str2.length();
        int arr[][]=new int[n+1][m+1];
        for(int i=0;i<m+1;i++)
        {
            arr[0][i]=i;
        }
        for(int i=0;i<n+1;i++)
        {
            arr[i][0]=i;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1];
                }
                else{
                    //insert (i-1,j)
                    //remove (i,j-1)
                    //replace(i-1,j-1)
                    arr[i][j]=1+min(arr[i-1][j],arr[i][j-1],arr[i-1][j-1]);
                }
            }
        }
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return arr[n][m];
    }
    static int min(int a,int b,int c)
    {
        if(a<=b&&a<=c)
            return a;
        else if(b<=a&&b<=c)
            return b;
        else     
            return c;
    }
}
