//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    static boolean isAnagram(int alp[],int temp[]){
        for(int i=0;i<26;i++){
            if(alp[i] != temp[i])
            return false;
        }
        return true;
    }
    static Node createList(Node i , Node j){
        Node start = new Node(' ');
        Node curr = start;
        while(i != j){
            curr.next = new Node(i.data);
            curr = curr.next;
            i = i.next;
        }
        curr.next = new Node(i.data);
        return start.next;
    }
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int alp[] = new int[26];
        int temp[] = new int[26];
        for(int i=0;i<s.length();i++){
            alp[s.charAt(i)-'a']++;
        }
        Node i = head;
        Node j = head;
        int count = 0;
        while(j != null){
            count++;
            temp[j.data-'a']++;
            if(count == s.length()){
                boolean check = isAnagram(alp,temp);
                if(check){
                     Node a = createList(i,j);
                     ans.add(a);
                     Arrays.fill(temp,0);
                     count = 0;
                     j = j.next;
                     i = j;
                }
                else{
                    temp[i.data-'a']--;
                    i = i.next;
                    j=j.next;
                    count--;
                }
            }
            else{
            j = j.next;
            }
        }
        // if(ans.isEmpty()){
        //     Node d = new Node('-1');
        //     ans.add(d);
        // }
        
        return ans;
    }
}