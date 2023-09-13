import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(0, 0, map[0][0]);
        System.out.println(dp[0][0]);

        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int dfs(int x, int y, int H) {
        if (!enableMove(x, y)) {
            return 0;
        }

        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (visited[x][y]) {
            return dp[x][y];
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (enableMove(nextX, nextY) && map[nextX][nextY] < map[x][y]) {
                dp[x][y] += dfs(nextX, nextY, map[x][y]);
            }

        }

        return dp[x][y];
    }

    public static boolean enableMove(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y < N);
    }
}
