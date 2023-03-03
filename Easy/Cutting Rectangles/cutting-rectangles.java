//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long B = Long.parseLong(input_line[1]);

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<Long>();
            ans = ob.minimumSquares(L, B);
            System.out.print(ans.get(0)+" ");
            System.out.println(ans.get(1));
        }
    }
}
// } Driver Code Ends

class Solution{
    static long __gcd(long a,long b){
        if(a==0)return b;
        return __gcd(b%a,a);
//User function Template for Java
    }
    static List<Long> minimumSquares(long L, long B)
    {
        List<Long> ans = new ArrayList<>();
        long a = __gcd(L,B);
        long b = (L*B)/(a*a);
        ans.add(b);
        ans.add(a);
        return ans;// code here
    }
}