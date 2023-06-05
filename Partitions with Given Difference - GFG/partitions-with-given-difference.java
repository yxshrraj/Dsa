//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    int mod=1000000007;
    public int partition(int []arr, int sum)
    {
        int n= arr.length;
        int [][]dp= new int[n][sum+1];
        if(arr[0]==0) dp[0][0]=2;
        else
          dp[0][0]=1;
          
         if(arr[0]!=0 && arr[0]<=sum)
           dp[0][arr[0]]=1;
           
         for(int ind=1; ind<n ;ind++)
         {
             for(int target=0 ;target<=sum ;target++)
             {
                 int nottake = dp[ind-1][target];
                 int take=0;
                 if(arr[ind]<=target)
                  take= dp[ind-1][target-arr[ind]];
                  dp[ind][target]=(nottake + take)%mod;
             }
             
         }
         return dp[n-1][sum];
    }

    public int countPartitions(int n, int d, int arr[])
    {
        
        int totalsum=0;
        for(int i=0;i<n;i++)
          {
        totalsum+=arr[i];
           }
      
      
      if(totalsum-d<0 || (totalsum-d)%2==1)
        return 0;
        
      return partition(arr,(totalsum-d)/2);
    }
}