import java.util.Scanner;
//Consider a devotee wishing to give offerings to temples along a mountain range.
//The temples are located in a row at different heights. Each temple should receive at least one
//offering. If two adjacent temples are at different altitudes,
//then the temple that is higher up should receive more offerings than the one that is lower down.
//If two adjacent temples are at the same height, then their offerings relative to each other does
//not matter. Given the number of temples and the heights of the temples in order,
//find the minimum number of offerings to bring

//https://www.geeksforgeeks.org/temple-offerings/
public class TempleOfferings
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        System.out.println("Enter "+(n)+" element");
        int array[]=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        int ans=solve(array);
        System.out.println("The minimum number of offerings to bring "+ans);
    }
    static int solve(int array[])
    {
        int n=array.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++)
        {
            if(array[i]>array[i-1])
                left[i]=left[i-1]+1;
            else    
                left[i]=1;    
        }
        right[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            if(array[i]>array[i+1])
                right[i]=right[i+1]+1;
            else    
                right[i]=1;    
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=(left[i]>right[i])?left[i]:right[i];
        }
        return ans;
    }
}
