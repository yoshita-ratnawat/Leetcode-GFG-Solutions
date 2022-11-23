//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
         int[] index = new int[arr.length];
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
         for(int i = 0; i< arr.length; i++){
             if(s1.isEmpty()){
                 index[i] = -1;
             }else if(s1.peek() > arr[i]){
                 index[i] = s2.peek();
             }else{
                 while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() <= arr[i]){
                     s1.pop();
                     s2.pop();
                 }
                 if(s1.isEmpty()){
                     index[i] = -1;
                 }else{
                     index[i] = s2.peek();
                 }
             }
             s1.push(arr[i]);
             s2.push(i);
         }
         
         for(int i = 0; i < index.length; i++){
             index[i] = i - index[i];
         }
         
         return index;

      
      
    //BRUTE FORCE APPROACH TIMELIMIT EXCEEDS
    //   ans[0] = 1;
    //   for(int i = 1; i< arr.length; i++){
    //       int count = 1;
    //       for(int j = i - 1; j>= 0; j--){
    //           if(arr[j] > arr[i]){
    //               break;
    //           }else if(arr[j] <= arr[i]){
    //               count++;
    //           }
    //       }
    //       ans[i] = count;
    //   }
    //   return ans;
    // }
    }  
}