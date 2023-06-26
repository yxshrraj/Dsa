//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int row;
    int col;
    
    Pair(int _row, int _col)
    {
        row=_row;
        col=_col;
    }
}


class Solution {

    int numberOfEnclaves(int[][] grid) {
        
        int n= grid.length;
        int m= grid[0].length;
        int [][] vis = new int[n][m];
        
        Queue<Pair> q =new LinkedList<>();
        
        for(int i=0; i<n ;i++)
        {
            for(int j=0 ;j<m ;j++)
            {
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.offer(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        
        int drow[] ={-1,0,+1,0};
        int dcol[]={0,1,0,-1};
        
        
        while (!q.isEmpty())
        {
            int row= q.peek().row;
            int col= q.peek().col;
            q.remove();
            
            for(int i=0 ;i<4;i++)
            {
                int nrow= row+drow[i];
                int ncol =col +dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 &&  ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    q.offer(new Pair(nrow,ncol));
                   vis[nrow][ncol]=1;
                }
            }
        }
        
        int count=0;
        for(int i=0 ;i<n ;i++)
        {
            for(int j=0; j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    count++;
                }
            }
        }
        return count;
        
        
        
        
    }
}