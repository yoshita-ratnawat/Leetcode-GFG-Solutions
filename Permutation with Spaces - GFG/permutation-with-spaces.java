//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String ip){
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        String op = ""+ip.charAt(0);
        ip = ip.substring(1);
        space(ip,op,ans);
        return ans;
    }
    
     void space(String ip, String op, ArrayList<String> ans){
        if(ip.length() == 0){
            ans.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op1 += " ";
        op1 += ip.charAt(0);
        op2 += ip.charAt(0);
        ip = ip.substring(1);

        space(ip,op1,ans);
        space(ip,op2,ans);
        return;
    }
    
}