import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static LinkedList<Integer>[] graph;
    static int[] parents;
    static boolean[] visited;

    public static void dfs(int num) {
        visited[num] = true;
        for (int v : graph[num]) {
            if (!visited[v]) {
                parents[v] = num;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new LinkedList[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] lines = br.readLine().split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            if (graph[a] == null) {
                graph[a] = new LinkedList<>();
            }
            if (graph[b] == null) {
                graph[b] = new LinkedList<>();
            }
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }

    }
}