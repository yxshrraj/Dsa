//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        StringBuilder ans = new StringBuilder();
        int i = S.length() - 1;
        while (i >= 0)
        {
            int j = i;
            while (i >= 0 && S.charAt(i) != '.') i--;
            if (ans.length() > 0)
                ans.append(".");
            ans.append(S.substring(i + 1, j + 1));
            i--;
        }
        return ans.toString();
    }
}
