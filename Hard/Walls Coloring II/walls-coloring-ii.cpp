//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    typedef pair<int, int> pi;

    int minCost(vector<vector<int>> &costs) {

        // write your code here

      int n=costs.size();

        int k=costs[0].size();

        if(k==1 && n>1) {

            return -1;

        }

        priority_queue<pi, vector<pi>, greater<pi>>q;

        for(int i=1;i<n;i++) {

            for(int l=0;l<k;l++){

                q.push({costs[i-1][l],l});

            }

            

            for(int j=0;j<k;j++) {

            int m=INT_MAX;

            //pq

            pair<int,int>p=q.top();

            if(p.second!=j)

               m=p.first;

            else{

                pair<int,int>w=q.top();

                q.pop();

                m=q.top().first;

                q.push(w);

                

            }

            

            

            costs[i][j]=costs[i][j]+m;

            }

            while(q.size()!=0)

              q.pop();

           

        }

        int ans=INT_MAX;

        for(int i=0;i<k;i++) {

            ans=min(ans,costs[n-1][i]);

        }

        return ans;
}

};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        vector<vector<int>> costs(n, vector<int>(k));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) cin >> costs[i][j];
        }
        Solution obj;
        cout << obj.minCost(costs) << endl;
    }
}
// } Driver Code Ends