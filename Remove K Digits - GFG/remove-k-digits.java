//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
    //   if(S.length()==K)
    //      return '0';
         
        Stack<Character> st= new Stack<>();
        StringBuilder ans= new StringBuilder();
        
        for(int i=0 ;i<S.length() ;i++)
        {
            while(!st.isEmpty() && K>0 && st.peek()> S.charAt(i))
            {
                st.pop();
                K--;
            }
            st.push(S.charAt(i));
        }
         while(K>0)
        {
            st.pop();
            K--;
        }
        while(!st.isEmpty())
        {
            ans.append(st.pop());
            
        }
       
        ans.reverse();
        
        while(ans.length()>1 && ans.charAt(0)=='0')
        {
            ans.deleteCharAt(0);
        }
        return ans.toString();
         
    }
}