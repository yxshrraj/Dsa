//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        // code here
        int n = s.length();
int maxlength = 0;
String ans = "";
int[][] dp = new int[n][n];
for (int diff = 0; diff < n; diff++) {
    for (int i = 0, j = i + diff; j < n; i++, j++) {
        if (i == j) {
            dp[i][j] = 1;
        } else if (diff == 1) {
            dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 0;
        } else {
            if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
            }
        }
        if (dp[i][j] != 0) {
            if (j - i + 1 > maxlength) {
                maxlength = j - i + 1;
                ans = s.substring(i, i + maxlength);
            }
        }
    }
}
return ans;
    }
}