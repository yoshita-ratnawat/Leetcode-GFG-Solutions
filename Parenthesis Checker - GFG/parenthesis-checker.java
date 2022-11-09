//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String str)
    {
        // add your code here
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            } else{
                if(stack.isEmpty()) return false;
                char ch = stack.peek();
                stack.pop();
                if(ch == '(' && str.charAt(i) == ')' ||ch == '[' && str.charAt(i) == ']'|| ch == '{' && str.charAt(i) == '}'){
                    continue;
                }else{
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
