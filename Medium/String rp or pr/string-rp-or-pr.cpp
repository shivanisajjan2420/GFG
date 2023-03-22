//{ Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution{   
public:
    long long solve(int X,int Y,string S){
      //code here
      long long ans = 0;
      stack<char> st;
      if(X > Y) {
          for(long long i = 0; i < S.size(); i++) {
              if(st.empty()) {
                  st.push(S[i]);
              }
              else {
                  if(S[i] == 'r') {
                      if(st.top() == 'p') {
                          ans += X;
                          st.pop();
                      }
                      else
                        st.push(S[i]);
                  }
                  else
                    st.push(S[i]);
              }
          }
          vector<char> temp;
          while(!st.empty()) {
              temp.push_back(st.top());
              st.pop();
          }
          reverse(temp.begin(), temp.end());
          for(int i = 0; i < temp.size(); i++) {
              if(st.empty()) {
                  st.push(temp[i]);
              }
              else {
                  if(temp[i] == 'p') {
                      if(st.top() == 'r') {
                          ans += Y;
                          st.pop();
                      }
                      else
                        st.push(temp[i]);
                  }
                  else
                    st.push(temp[i]);
              }
          }
      }
      else {
          for(long long i = 0; i < S.size(); i++) {
              if(st.empty()) {
                  st.push(S[i]);
              }
              else {
                  if(S[i] == 'p') {
                      if(st.top() == 'r') {
                          ans += Y;
                          st.pop();
                      }
                      else
                        st.push(S[i]);
                  }
                  else
                    st.push(S[i]);
              }
          }
          vector<char> temp;
          while(!st.empty()) {
              temp.push_back(st.top());
              st.pop();
          }
          reverse(temp.begin(), temp.end());
          for(int i = 0; i < temp.size(); i++) {
              if(st.empty()) {
                  st.push(temp[i]);
              }
              else {
                  if(temp[i] == 'r') {
                      if(st.top() == 'p') {
                          ans += X;
                          st.pop();
                      }
                      else
                        st.push(temp[i]);
                  }
                  else
                    st.push(temp[i]);
              }
          }
      }
      return ans;
    }
};

//{ Driver Code Starts.
signed main()
{
  int t;
  cin>>t;
  while(t--)
  {
      int X,Y;
      cin>>X>>Y;
      string S;
      cin>>S;
      Solution obj;
      long long answer=obj.solve(X,Y,S);
      cout<<answer<<endl;
  }
}
// } Driver Code Ends