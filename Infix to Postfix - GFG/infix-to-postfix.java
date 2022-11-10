//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String str) {
        // Your code here
         Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //if scanned character is a operand add it to ans
            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            }

            //if scanned character is a '(' push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }

            //if scanned character is an ')' then pop out the characters until '(' is encountered
            //and append it to ans string
            else if(ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else{  // operator is encountered
                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    ans += stack.peek();
                    stack.pop();
                }
                stack.push(ch);
            }
        }

        //all the elements of given string are iterated
        // hence pop all the elements left in stack and append them to ans string
        while(!stack.isEmpty()){
            //Since all the elements are iterated and now we find '(' then it would be a invalid string
            if(stack.peek() == '(') return "Invalid Expression";
            else{
                ans += stack.peek();
                stack.pop();
            }
        }
        return ans;
    }
    
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}