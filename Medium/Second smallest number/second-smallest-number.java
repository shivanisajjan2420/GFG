//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        int[] num = new int[D]; // create an array to store the digits of the number
    for (int i = D - 1; i > 0; i--) { // loop from D-1 to 1
        int d = Math.min(S - 1, 9); // calculate the maximum digit value that can be placed at the current index
        num[i] = d; // store the digit in the array
        S -= d; // subtract the digit value from the sum
    }
    if (S > 9) { // if the remaining sum is greater than 9, it means there is no possible number with given sum and number of digits
        return "-1";
    }
    num[0] = S; // store the remaining sum at the first index
    for (int i = D - 1; i > 0; i--) { // loop from D-1 to 1
        if (num[i] != 0 && num[i - 1] != 9) { // if the current digit and the previous digit are not equal to 0 and 9 respectively
            num[i] -= 1; // decrement the current digit
            num[i - 1] += 1; // increment the previous digit
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < D; j++) {
                sb.append(num[j]); // construct the final string using StringBuilder
            }
            return sb.toString(); // return the second smallest number
        }
    }
    return "-1"; // if no second smallest number is possible, return -1


    }
}