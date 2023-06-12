//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack <Integer> st= new Stack<>();
        for(int i=0 ;i <asteroids.length ;i++)
          {
              if(st.isEmpty() || asteroids[i]>0)
              {
                  st.push(asteroids[i]);
              }
              else
              {
                  while(!st.isEmpty())
                  {
                     int top = st.peek();
                     if(top<0)
                     {
                      st.push(asteroids[i]);
                      break;
                      }
                  
                  
                      int modval= Math.abs(asteroids[i]);
                      
                      if(modval==top)
                        {
                            st.pop();
                            break;
                        }
                       else if(modval < top)
                       {
                           break;
                       }
                       else
                       {
                           st.pop();
                            if(st.isEmpty())
                            {
                                st.push(asteroids[i]);
                                break;
                            }
                       }
                  }
                  
              }
          
           }
           int len= st.size();
           int ans[] = new int[len];
           for(int i=len-1; i>=0 ;i--)
           {
               ans[i]=st.pop();
           }
           return ans;
    }
}
