//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
       if(s.length()%2!=0) return -1;
       
       int open=0 ,close=0 ,rev=0;
       for(int i=0 ;i<s.length() ;i++)
       {
           if(s.charAt(i)=='{')
             open++;
            else
            {
                if(open==0) close++;
                else
                 open--;
            }
       }
       rev= (int)(Math.ceil(open/2.0)+ Math.ceil(close/2.0));
       return rev;
    }
}