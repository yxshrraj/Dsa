//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long countpaths(int i, int j , int m ,int n,long [][]dp)
    {
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        return dp[i][j]=countpaths(i,j+1,m,n,dp)+countpaths(i+1,j,m,n,dp);
    }
    
    
    long numberOfPaths(int m, int n) {
        // Code Here
        long [][]dp =new long[m][n];
        for(long row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return countpaths(0,0,m,n,dp);
        
    }
    
}