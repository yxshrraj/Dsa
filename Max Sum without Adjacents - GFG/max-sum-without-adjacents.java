//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    //  int f(int ind , int arr[], int [] dp)
    //  {
         
    //      if(ind==0) return arr[0];
    //      if(ind< 0) return 0;
    //      if(dp[ind]!=-1) return dp[ind];
    //      int ans= 0;
         
    //      int take = f(ind-2 , arr,dp) +arr[ind];
    //      int nottake = 0 +f(ind-1,arr,dp);
    //      ans = Math.max(take,nottake);
    //      dp[ind]=ans;
    //      return dp[ind];
         
    //  }
    int findMaxSum(int arr[], int n) {
        int [] dp =new int[n];
        Arrays.fill(dp,-1);
        dp[0]= arr[0];
          
        
        for(int i=1 ; i<n ;i++)
        {
              int take= arr[i] ;
              if(i>1)
              {
                  take+=dp[i-2];
                 
              }
               int nottake = 0+ dp[i-1];
               
            
            dp[i]=Math.max(nottake,take);
        }
        return dp[n-1];
    
    }
}