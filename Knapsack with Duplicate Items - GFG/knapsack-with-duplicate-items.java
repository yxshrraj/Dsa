//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
  static int func(int wt[] , int val[] ,int W, int ind,int [][] dp)
    {
        if(ind==0)
        {
           return (W/wt[0])*val[0];
        }
        if(dp[ind][W]!=-1) return dp[ind][W];
        int pick=Integer.MIN_VALUE;
        if(wt[ind]<=W)
        {
            pick = val[ind]+ func(wt,val,W-wt[ind],ind,dp);
        }
        int notpick = func(wt,val,W,ind-1,dp);
        
        return dp[ind][W]=Math.max(pick,notpick);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        
        int dp[][] =new int[N][W+1];
        for(int row[] :dp)
        {
            Arrays.fill(row,-1);
        }
        return func(wt ,val, W ,N-1,dp);
    }
}



