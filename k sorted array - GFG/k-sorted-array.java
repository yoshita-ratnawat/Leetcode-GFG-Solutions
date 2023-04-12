//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{ 
    static String isKSortedArray(int arr[], int n, int k) 
    { 
        // code here
        int[] aux = Arrays.copyOf(arr,arr.length);
        Arrays.sort(aux);
        
        for(int i = 0; i < arr.length; i++){
            int j = binarySearch(aux,arr[i]);
            if(k < Math.abs(i-j)) return "No";
        }
        
        return "Yes";
    }
    
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    int k=Integer.parseInt(br.readLine());
		    Solution ob=new Solution();
		    String ans=ob.isKSortedArray(a,n,k);
		    System.out.println(ans);
		    
		}
	}
}
// } Driver Code Ends