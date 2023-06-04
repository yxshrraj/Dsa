//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    int totalsum=0; 
	    for(int i=0 ; i<n ; i++)
	    {
	        totalsum+=arr[i];
	    }
	    int sum= totalsum;
	     boolean dp[][]= new boolean[n][sum+1];
    
       for(int i=0; i<n; i++){
        dp[i][0] = true;
    }
    
    if(arr[0]<=sum)
        dp[0][arr[0]] = true;
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=sum; target++){
            
            boolean notTaken = dp[ind-1][target];
    
            boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];
        
            dp[ind][target]= notTaken||taken;
        }
    }
     int mini = Integer.MAX_VALUE;
     for(int i=0 ; i<=totalsum ;i++)
     {
         if(dp[n-1][i]==true)
         {
             int diff= Math.abs(i-(totalsum-i));
             mini=Math.min(mini,diff);
         }
     }
    
     return mini;
    
	} 
	
}
