//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        // Initialize a variable to store the minimum length of all sticks
    int minLen = Integer.MAX_VALUE;
    // Initialize a variable to store the total length of all sticks used in squares/rectangles
    long totalLen = 0;
    // Initialize a variable to store the total count of sticks used in squares/rectangles
    long totalCount = 0;
    
    // Loop through all the sticks
    for(int i = 0; i < N; i++) {
    //check if number of sticks is greater than 1 , then that stick can be included
    if(B[i]>1){
        // Calculate the maximum number of squares/rectangles that can be made with the current stick
        int maxCount = B[i] / 2;
        // Calculate the total length of all sticks used in squares/rectangles with the current stick
        totalLen += maxCount * 2 * A[i];
        // Increment the total count of sticks used in squares/rectangles with the current stick
        totalCount += maxCount;
         // If the current stick length is less than the minimum length, update the minimum length
        if(A[i] < minLen) {
            minLen = A[i];
        }
    }
    }
    
    // If the total count of sticks used in squares/rectangles is not a multiple of 4,
    // remove the length of two sticks with minimum length
    if(totalCount %2==1) {
        totalLen -= minLen * 2;
    }
    
    // Return the total length of all sticks used in squares/rectangles
    return totalLen;

        // code here
    }
} 