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
    
    // static int ks ( int []wt , int val[],int ind ,int W, int [][]dp)
    // {
    //     if(ind==0)
    //     {
    //         if(wt[0]<=W) return val[0];
    //         else
    //           return 0;
    //     }
    //     if(dp[ind][W]!=-1)
    //     {
    //         return dp[ind][W];
    //     }
    //     int notTaken = 0+ ks(wt,val,ind-1,W,dp);
    //     int taken= Integer.MIN_VALUE;
        
    //     if(wt[ind]<=W)
    //     {
    //         taken= val[ind]+ks(wt,val,ind-1,W-wt[ind],dp);
    //     }
    //     return dp[ind][W]= Math.max(notTaken,taken);
        
        
    // }
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
       
       int dp[][] = new int[n][W+1];
      for(int i=wt[0]; i<=W;i++)       
      {
          dp[0][i]=val[0];
      }
      for(int ind=1; ind<n;ind++)
       {
           for(int j=0; j<=W;j++)
           {
               int nottake= dp[ind-1][j];
               int take= Integer.MIN_VALUE;
               if(wt[ind]<=j)
               {
                   take= val[ind]+ dp[ind-1][j-wt[ind]];
               }
               dp[ind][j]=Math.max(nottake ,take);
           }
       }
       return dp[n-1][W];
                
    } 
}


