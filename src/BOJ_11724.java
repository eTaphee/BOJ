import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }
        System.out.println(count);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int linked : graph.get(node)) {
            dfs(graph, visited, linked);
        }
    }
}
