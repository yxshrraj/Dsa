//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair
{
    int row;
    int col;
    int tm;
    
    Pair(int _row, int _col , int _tm)
    {
        row= _row;
        col = _col;
        tm = _tm;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n= grid.length;
        int m= grid[0].length;
         int [][]vis =new int[n][m];
        int cntFresh=0;
        Queue <Pair> q = new LinkedList<>();    
        for(int i=0; i<n; i++)
        {
            for(int j=0 ; j<m ;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                if(grid[i][j]==1)
                  cntFresh++;
                else
                 vis[i][j]=0;
                 
                 
            }
        }
        int tm=0;
        int drow[]= {-1,0,+1,0};
        int dcol[] ={0,1,0,-1};
        int count=0;
        
        while(!q.isEmpty())
        {
           int r= q.peek().row;
           int c= q.peek().col;
           int t= q.peek().tm;
           tm =Math.max(tm,t);
           q.remove();
           
           for(int i=0 ;i<4;i++)
           {
               int nrow= r+drow[i];
               int ncol = c+dcol[i];
               
    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 &&grid[nrow][ncol]==1 )
               {
                   q.offer(new Pair(nrow,ncol,t+1));
                   vis[nrow][ncol]=2;
                   count++;
               }
           }
           
        }
        if(count!=cntFresh)
           return -1;
           
           return tm;
        
        
    }
}