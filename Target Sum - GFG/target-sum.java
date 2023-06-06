//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int mindifference(int [] arr, int sum)
    {
        int n= arr.length;
        int [][]dp =new int[n][sum+1];
        if(arr[0]==0) dp[0][0]=2;
        else
         dp[0][0]=1;
         
        if(arr[0]!=0 && arr[0]<=sum)
        {
            dp[0][arr[0]]=1;
        }
        
        for(int ind=1; ind<n;ind++)
        {
            for(int target=0; target<=sum; target++)
            {
                int nottake= dp[ind-1][target];
                int take =0;
                if(arr[ind]<=target)
                {
                    take= dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]= take + nottake;
            }
        }
        return dp[n-1][sum];
    }
    
    
    
    
    
    static int findTargetSumWays(int[] A , int N, int target) {
       int totalsum =0;
       for(int i=0 ;i<N ;i++)
       {
           totalsum+=A[i];
       }
       if(totalsum-target <0 || (totalsum-target)%2==1)
         return 0;
        
        return mindifference(A,(totalsum-target)/2);
    }
};