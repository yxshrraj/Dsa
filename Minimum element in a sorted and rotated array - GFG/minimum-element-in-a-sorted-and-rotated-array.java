//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int l=0;
        int h= n-1;
        int min=Integer.MAX_VALUE;
        while(l<=h)
        {
            int mid= (l+h)/2;
            if(arr[l]<=arr[mid])
            {
                min= Math.min(min,arr[l]);
                l=mid+1;
            }
            else
            {
                min=Math.min(min,arr[mid]);
                h=mid-1;
            }
        }
        return min;
    }
}
