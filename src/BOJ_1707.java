import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707 {
    static int K = 0;
    static ArrayList<ArrayList<Integer>>[] graphArr;
    static ArrayList<Integer>[] graphColorArr;
    static boolean bipartite;
    final static int RED = 1;
    final static int BLUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        graphArr = new ArrayList[K];
        graphColorArr = new ArrayList[K];

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < K; i++) {
            graphArr[i] = new ArrayList<>();
            graphColorArr[i] = new ArrayList<>();
            ArrayList<ArrayList<Integer>> graph = graphArr[i];
            ArrayList<Integer> graphColor = graphColorArr[i];
            graph.add(new ArrayList<>()); // 1부터 접근하기 위해 0 더미
            graphColor.add(0);
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < V; j++) {
                graph.add(new ArrayList<>()); // vertex
                graphColor.add(0);
            }
            int E = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < E; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            bipartite = true;
            for (int j = 1; j < V; j++) {
                if (bipartite) {
                    dfs(graph, graphColor, j, RED);
                }
                else {
                    break;
                }
//                if (!bfs(graph, graphColor, j, RED)) {
//                    bipartite = false;
//                    break;
//                }
            }

            if (bipartite) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> graphColor, int node, int color) {
        if (graphColor.get(node) != 0) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        graphColor.set(node, color);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curColor = graphColor.get(cur);

            for (int adjacency : graph.get(cur)) {
                if (graphColor.get(adjacency) == 0) {
                    queue.add(adjacency);
                    graphColor.set(adjacency, curColor * -1);
                } else if (curColor == graphColor.get(adjacency)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> graphColor, int node, int color) {
        if (graphColor.get(node) != 0) {
            return;
        }

        graphColor.set(node, color);

        for (int adjacency : graph.get(node)) {
            if (graphColor.get(adjacency) == color) {
                bipartite = false;
                return;
            }
            dfs(graph, graphColor, adjacency, color * -1);
        }
    }
}
