//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int l=0;
        int h=n-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(l<=h)
        {
            int mid =(l+h)/2;
            if(arr[l]<=arr[mid])
            {

                if(arr[l]<ans)
                {
                    ans=arr[l];
                    index=l;
                }
                
                l=mid+1;
            }
            else
            {
                if(arr[mid]<ans)
                {
                    ans=arr[mid];
                    index=mid;
                }
                
                h=mid-1;
            }
        }
        return index;
    }
}