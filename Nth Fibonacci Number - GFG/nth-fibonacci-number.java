//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int mod = 1000000007;
    static int nthFibonacci(int n){
        int prev2=0;
        int prev=1;
        
        int ans=0;
        for(int i=2;i<=n;i++)
        {
            ans=(prev+prev2)%mod;
            prev2=prev;
            prev=ans;
        }
        return ans;
        
        
    }
}