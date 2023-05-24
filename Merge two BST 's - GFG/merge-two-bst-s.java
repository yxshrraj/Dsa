//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public void addtostack(Node root , Stack <Node> st)
    {
        if(root==null)
          return;
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
    public List<Integer> merge(Node root1,Node root2)
    {
       List<Integer> list = new ArrayList<>();
       if(root1==null && root2==null)
         return list;
        Stack<Node> st1= new Stack<>();
        Stack<Node> st2= new Stack<>();
        
        addtostack(root1,st1);
        addtostack(root2,st2);
        while(!st1.isEmpty() && !st2.isEmpty())
        {
            if(st1.peek().data<=st2.peek().data)
            {
                list.add(st1.peek().data);
                addtostack(st1.pop().right,st1);
            }
            else{
                list.add(st2.peek().data);
                addtostack(st2.pop().right,st2);
            }
        }
        while(!st1.isEmpty())
        {
             list.add(st1.peek().data);
                addtostack(st1.pop().right,st1);
        }
        while(!st2.isEmpty())
        {
            list.add(st2.peek().data);
                addtostack(st2.pop().right,st2); 
        }
        return list;
    }
}
