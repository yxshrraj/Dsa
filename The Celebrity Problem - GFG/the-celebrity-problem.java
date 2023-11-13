//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    boolean knows(int a , int b,int M[][],int n)
    {
        if(M[a][b]==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack <Integer> st = new Stack<>();
    	
    	for(int i=0; i<n;i++)
    	{
    	    st.push(i);
    	}
    	while(st.size()>1)
    	{
    	    int a= st.peek();
    	    st.pop();
    	    
    	    int b=st.peek();
    	    st.pop();
    	   if(knows(a,b,M,n))
    	   {
    	      st.push(b);
    	   }
    	   else
    	   {
    	       st.push(a);
    	   }
    	}
    	int ans= st.peek();
    	int rowcnt=0;
    	for(int i=0;i<n;i++)
    	{
    	    if(M[ans][i]==0)
    	      rowcnt++;
    	}
    	if(rowcnt!=n)
    	{
    	    return -1;
    	}
    	
    	int onecnt=0;
    	for(int i=0;i<n;i++)
    	 {
    	     if(M[i][ans]==1)
    	     {
    	         onecnt++;
    	     }
    	 }
    	 if(onecnt!=n-1)
    	 {
    	     return -1;
    	 }
    	 return ans;
    }
}