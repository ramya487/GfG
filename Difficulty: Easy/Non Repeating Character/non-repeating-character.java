//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        for (int i = 0; i<n; i++){
            char c = s.charAt(i);
            if (!mp.containsKey(c)){
                mp.put(c, 1);
            }else{
                mp.put(c, mp.get(c)+1);
            }
        }
        for (int i = 0; i<n;i++){
            char c = s.charAt(i);
            int v = mp.get(c);
            if (v == 1) return c;
        }
        return '$';
    }
}
