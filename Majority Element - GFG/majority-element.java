//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
      int el=0;
        int cnt=0;
        for(int i=0 ; i<size;i++)
        {
            if(cnt==0)
             {
             cnt+=1;
             el=a[i];
             }
            else if(a[i]==el)
            {
              
              cnt++;
            }

            else
             cnt--;
        }
        int cnt1=0;
        for(int i=0;i<size;i++)
        {
            if(a[i]==el)
              cnt1++;
        }
        if(cnt1>(a.length)/2)
         return el;

        return -1;
        
    }
}