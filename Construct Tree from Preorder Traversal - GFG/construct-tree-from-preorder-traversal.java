//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            String input_line1[] = read.readLine().trim().split("\\s+");
            int pre[] = new int[n];
            for(int i=0;i<n;i++){
                pre[i] = Integer.parseInt(input_line1[i]);
            }

            String input_line2[] = read.readLine().trim().split("\\s+");
            char preLN[] = new char[n];
            for(int i=0;i<n;i++){
                preLN[i] = input_line2[i].charAt(0);
            }
            Solution obj = new Solution();
            Node root = obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
class Solution{
    public Node constTree(int n, int[] pre, char[] preLN, int[] index) {
    if (index[0] >= n) return null;
    Node root = new Node(pre[index[0]]);
    index[0]++;
    if (preLN[index[0] - 1] == 'N') {
        root.left = constTree(n, pre, preLN, index);
        root.right = constTree(n, pre, preLN, index);
    }
    return root;
}

public Node constructTree(int n, int[] pre, char[] preLN) {
    if (n == 0) return null;
    int[] index = {0};
    return constTree(n, pre, preLN, index);
}

}