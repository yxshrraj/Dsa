//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        if(n==1)  return "1";
        
        String s =lookandsay(n-1);
        StringBuilder res = new StringBuilder();
        int counter =0;
        for(int i=0 ;i< s.length();i++)
        {
            counter++;
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1))
            {
                res.append(counter).append(s.charAt(i));
                counter=0;
            }
        }
        return res.toString();
    }
}
