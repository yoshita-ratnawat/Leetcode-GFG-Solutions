//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String str1,String str2)
    {
        if(str1.length() != str2.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for(int i = 0; i < str2.length(); i++){
            char c = str2.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }else{
                return false;
            }
        }

        return true;
    }
}