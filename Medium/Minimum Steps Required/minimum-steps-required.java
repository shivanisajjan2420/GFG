//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
	int consA = 0;
		int consB = 0;
		int tempA = 0;
		int tempB = 0;
		for(int i = 0; i < str.length(); i++){
		    if(str.charAt(i) == 'a' && tempA == 0){
		        consA = consA + 1;
		        tempA = 1;
		        tempB = 0;
		    }
		    if(str.charAt(i) == 'b' && tempB == 0){
		        consB = consB + 1;
		        tempB = 1;
		        tempA = 0;
		    }
		}
				return Math.min(consA, consB) + 1;
	}
}