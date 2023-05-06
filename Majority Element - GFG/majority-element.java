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
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (mp.containsKey(a[i])) {
                mp.put(a[i], mp.get(a[i]) + 1);
            } else {
                mp.put(a[i], 1);
            }
        }
        int majorityCount = size / 2;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }
        return -1;
    }
}