//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   static int mod=1000000007;
    
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int [][]dp= new int[n][m];
        
        for(int i=0; i<n ;i++)
        {
            for(int j=0; j<m;j++)
            {
                if( grid[i][j]==0) dp[i][j]=0;
               else if(i==0 && j==0) dp[i][j]=1;
                else
                {
                int up=0, left=0;
                if(i>0) up=dp[i-1][j];
                if(j>0) left= dp[i][j-1];
                
                dp[i][j]=(up+left)%mod;
                }
                    
                }
            
        }
        return dp[n-1][m-1];
    }
};