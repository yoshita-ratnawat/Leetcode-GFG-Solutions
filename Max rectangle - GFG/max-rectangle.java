//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int[] arr = new int[m];
        for(int i = 0; i< m ; i++){
            arr[i] = M[0][i];
        }
        
        int mx = MAH(arr);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(M[i][j] == 0){
                    arr[j] = 0;
                }else{
                    arr[j] += M[i][j];
                }
            }
            mx = Math.max(mx, MAH(arr));
        }
        
        return mx;
    }
    
     public int MAH(int[] heights) {
        int[] nsr = NSR(heights);
        int[] nsl = NSL(heights);
        int[] width = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            width[i] = nsr[i] - nsl[i] -1;
        } 
        int[] area = new int[width.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< area.length; i++){
            area[i] = width[i]*heights[i];
            if(area[i] > max){
                max = area[i];
            }
        }
        return max;
    }

    public int[] NSL(int[] arr){
        int[] index = new int[arr.length];
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
         for(int i = 0; i< arr.length; i++){
             if(s1.isEmpty()){
                 index[i] = -1 ;
             }else if(s1.peek() < arr[i]){
                 index[i] = s2.peek();
             }else{
                 while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() >= arr[i]){
                     s1.pop();
                     s2.pop();
                 }
                 if(s1.isEmpty()){
                     index[i] = -1;
                 }else{
                     index[i] = s2.peek() ;
                 }
             }
             s1.push(arr[i]);
             s2.push(i);
         }

         return index;
    }

        public int[] NSR(int[] arr){

        int[] index = new int[arr.length];
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
         for(int i = arr.length-1; i >= 0; i--){
             if(s1.isEmpty()){
                 index[i] = arr.length;
             }else if(s1.peek() < arr[i]){
                 index[i] = s2.peek();
             }else{
                 while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() >= arr[i]){
                     s1.pop();
                     s2.pop();
                 }
                 if(s1.isEmpty()){
                     index[i] = arr.length;
                 }else{
                     index[i] = s2.peek();
                 }
             }
             s1.push(arr[i]);
             s2.push(i);
         }
         return index;
        }
    
}