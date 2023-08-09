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
   
    int findMaxSum(int arr[], int n) {
        int [] dp =new int[n];
        Arrays.fill(dp,-1);
       
          dp[0]=arr[0];
          
          for(int ind=1; ind<n; ind++)
          {
              int take =arr[ind];

              if(ind>1)
               take += dp[ind-2];
               
               
               int nottake = 0+ dp[ind-1];
               dp[ind]=Math.max(nottake,take);
          }
          
          return dp[n-1];
        
    }
}
