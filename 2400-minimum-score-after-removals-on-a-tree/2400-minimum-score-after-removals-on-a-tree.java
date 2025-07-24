
class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] inTime, outTime, subtreeXor;
    int time = 1;
    int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        this.inTime = new int[n];
        this.outTime = new int[n];
        this.subtreeXor = new int[n];
        this.tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        // DFS to compute subtree XOR and in/out times
        totalXor = dfs(0, -1);

        // Build list of child nodes of each edge (ensuring direction)
        int[] edgeNodes = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            edgeNodes[i] = (inTime[u] < inTime[v]) ? v : u;
        }

        int minScore = Integer.MAX_VALUE;

        // Try all pairs of removed edges
        for (int i = 0; i < edgeNodes.length; i++) {
            for (int j = i + 1; j < edgeNodes.length; j++) {
                int a = edgeNodes[i];
                int b = edgeNodes[j];
                int x, y, z;

                if (isAncestor(a, b)) {
                    x = subtreeXor[b];
                    y = subtreeXor[a] ^ x;
                    z = totalXor ^ subtreeXor[a];
                } else if (isAncestor(b, a)) {
                    x = subtreeXor[a];
                    y = subtreeXor[b] ^ x;
                    z = totalXor ^ subtreeXor[b];
                } else {
                    x = subtreeXor[a];
                    y = subtreeXor[b];
                    z = totalXor ^ x ^ y;
                }

                int max = Math.max(x, Math.max(y, z));
                int min = Math.min(x, Math.min(y, z));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    private int dfs(int node, int parent) {
        inTime[node] = time++;
        int xor = nums[node];
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                xor ^= dfs(neighbor, node);
            }
        }
        outTime[node] = time++;
        subtreeXor[node] = xor;
        return xor;
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}
