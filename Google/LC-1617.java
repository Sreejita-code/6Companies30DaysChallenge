import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubtreesWithMaxDistance {

    public static int[] countSubtreesWithMaxDistance(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n - 1];

        for (int d = 1; d < n; d++) {
            for (int root = 1; root <= n; root++) {
                int[] distances = new int[n + 1];
                Arrays.fill(distances, -1);
                distances[root] = 0;
                dfs(tree, root, -1, distances, d);
                for (int i = 1; i <= n; i++) {
                    if (distances[i] == d) {
                        result[d - 1]++;
                    }
                }
            }
        }

        return result;
    }

    private static void dfs(List<List<Integer>> tree, int node, int parent, int[] distances, int remainingDistance) {
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                distances[neighbor] = distances[node] + 1;
                dfs(tree, neighbor, node, distances, remainingDistance);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}};
        int[] result = countSubtreesWithMaxDistance(n, edges);

        System.out.println("Result: " + Arrays.toString(result));
    }
}
