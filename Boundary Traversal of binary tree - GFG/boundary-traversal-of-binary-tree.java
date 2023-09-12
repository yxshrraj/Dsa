//{ Driver Code Starts
import java.io.*;
import java.util.*;

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
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
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
        
                  // Create the right child for the current node
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
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public boolean isLeaf(Node root)
    {
        if(root.left==null && root.right==null)
        {
            return true;
        }
        return false;
    }
    public void leftree(Node root, ArrayList<Integer> ans)
    {
        
        Node temp=root.left;
        while(temp!=null)
        {
            if(isLeaf(temp)==false) ans.add(temp.data);
            if(temp.left!=null)
            {
                  temp=temp.left;
            }
            else
            {
                temp=temp.right;
            }
          
        }
    }
    public void leafnode(Node root,ArrayList<Integer> ans)
    {
        if(isLeaf(root))
        {
            ans.add(root.data);
            
        }
        if(root.left!=null) leafnode(root.left,ans);
        if(root.right!=null) leafnode(root.right,ans);
    }
    public void rightree(Node root, ArrayList<Integer> ans)
    {
        Node temp=root.right;
        ArrayList<Integer> tmp= new ArrayList<>();
        while(temp!=null)
        {
           if(isLeaf(temp)==false) tmp.add(temp.data);
          if(temp.right!=null) temp=temp.right;
          else
          {
                 temp=temp.left;
          }
        }
        for(int i=tmp.size()-1; i>=0;--i)
        {
            ans.add(tmp.get(i));
        }
        
        
           
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(isLeaf(node)==false) ans.add(node.data);
	    leftree(node,ans);
	    leafnode(node,ans);
	    rightree(node,ans);
	    
	    return ans;
	}
}


// Left traversal of the tree - > 1 2 
// Leaf Node traversal -> 4 8 9 6 7 
// Right Node traversal ->  3 x(1)

// 1 2 4 8 9 6 7 33