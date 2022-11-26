//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        // code here
        int i=0,j=0;
     long sum=0,maximum=0;
      while(j<N){
         sum=sum+Arr.get(j);   // for adding all elements of a window 
         
         if(j-i+1<k){
             j++;       
           }
        else if(j-i+1==k){
        maximum=Math.max(sum,maximum);    // store the maximum values 
                                 
        sum=sum-Arr.get(i);       //just reomove the first element of privious
                          // and window before move.. on to the next window
          i++;
          j++;
        }
    
      }
     return maximum;
    }
}