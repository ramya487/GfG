//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());

        while (t-- > 0) {
            String line = scanner.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxIndexDiff(nums));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find the maximum index difference.
    int maxIndexDiff(int[] arr) {
        int n = arr.length;
        int[] lmin = new int[n];
        int[] rmax = new int[n];
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        
        lmin[0] = arr[0];
        rmax[n-1] = arr[n-1];
        for (int i = 1; i<n; i++){
            lmin[i] = Math.min(lmin[i-1], arr[i]);
        }
        for (int i = n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        
        int ret = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        
        // System.out.println(Arrays.toString(lmin));
        // System.out.println(Arrays.toString(rmax));
        
        while (i<n && j<n){
            if (lmin[i]<=rmax[j]){
                ret = Math.max(ret,j-i);
                j++;
            }else i++;
        }
        
        return ret;
    }
}