//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        int maxlen=0 ;
        int curlen=0;
        int last=-1;
        
        for(int i=0 ;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
                if(!st.isEmpty())
                {
                      st.pop();
                      if(!st.isEmpty()) {
                          curlen=i-st.peek();
                          
                      }
                      else
                        curlen= i-last;
                     
                      maxlen= Math.max(maxlen,curlen);
                
                }
                else
                {
                    last=i;
                }
            }
        }
        return maxlen;
    }
};