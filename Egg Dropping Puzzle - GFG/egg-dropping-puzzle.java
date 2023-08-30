//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // dp[i][j] will be the minimum number of attempts needed for i eggs and j floors.
	    int dp[][] = new int[n + 1][k + 1];
	    
	    // Initializing the dp array
	    for (int i = 1; i <= n; i++) 
	    {
	        dp[i][0] = 0; // Zero floors require zero moves
	        dp[i][1] = 1; // One floor requires one move
	    }
	    
	    for (int j = 1; j <= k; j++) 
	    {
	        dp[1][j] = j; // With one egg, we need to try each floor one by one
	    }
	    
	    for (int i = 2; i <= n; i++) 
	    {
	        for (int j = 2; j <= k; j++) 
	        {
	            dp[i][j] = Integer.MAX_VALUE;
	            
	            for (int x = 1; x <= j; x++) 
	            {
	                // We drop an egg from the xth floor.
	                // 1. If it breaks, we have dp[i - 1][x - 1] floors to check.
	                // 2. If it doesn’t break, we have dp[i][j - x] floors to check.
	                int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
	                
	                // Take the minimum number of moves for each scenario
	                dp[i][j] = Math.min(res, dp[i][j]);
	            }
	        }
	    }
	    
	    return dp[n][k];
	}
}
