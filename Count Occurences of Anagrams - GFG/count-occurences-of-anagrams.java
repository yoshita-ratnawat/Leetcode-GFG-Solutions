//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String ptr, String s) {
        // code here
        Map<Character, Integer> m = new HashMap<>();
		for (char ch : ptr.toCharArray()) {
			if (m.containsKey(ch))
				m.put(ch, m.get(ch) + 1);
			else
				m.put(ch, 1);
		}
		int count = m.size();

		int strSize = s.length();
		int k = ptr.length();
		int i = 0;
		int j = 0;
		int ans = 0;

		while (j < strSize) {
			char jth = s.charAt(j);
			if (m.containsKey(jth)) {
				m.put(jth, m.get(jth) - 1);
				if (m.get(jth) == 0)
					count--;
			}
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				if (count == 0)
					ans++;
				char start = s.charAt(i);
				if (m.containsKey(start)) {
					m.put(start, m.get(start) + 1);
					if (m.get(start) == 1)
						count++;
				}
				i++;
				j++;

			}
		}
		return ans;
    }
}