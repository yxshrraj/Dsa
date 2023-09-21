//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    // static int func(int ind, int wt[], int val[], int W , int [][]dp)
    // {
    //     if(ind==0)
    //     {
    //         if(wt[0]<=W)
    //         {
    //             return val[0];
    //         }
    //         else
    //         {
    //             return 0;
    //         }
    //     }
    //     if(dp[ind][W]!=-1) return dp[ind][W];
        
        
    //     int pick= Integer.MIN_VALUE;
    //     if(wt[ind]<=W)
    //     {
    //         pick= val[ind]+ func(ind-1,wt,val,W-wt[ind],dp);
    //     }
    //     int notpick= 0+ func(ind-1,wt,val,W,dp);
    //     return dp[ind][W]= Math.max(pick,notpick);
    // }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]= new int[n][W+1];
        
         for(int i= wt[0] ; i<=W ;i++)
         {
             dp[0][i]=val[0];
         }
         for(int ind=1; ind<n ;ind++)
         {
             for(int w=0; w<=W; w++)
             {
                 int notake= 0+ dp[ind-1][w];
                 int take= Integer.MIN_VALUE;
                 if(wt[ind]<=w)
                 {
                     take= val[ind]+ dp[ind-1][w-wt[ind]];
                 }
                 dp[ind][w]=Math.max(take,notake);
             }
         }
         return dp[n-1][W];
         
    } 
}


