import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
    static int[][] forest;
    static int[][] dp;
    static int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, 0));
            }
        }

        System.out.println(max);
//        printForest();
    }

    public static int dfs(int x, int y, int bamboo) {
        if (x < 0 || x >= forest.length || y < 0 || y >= forest.length) {
            return 0;
        }

        // 현재 지역의 대나무가 이전 대나무보다 같거나 적으면 중지
        if (forest[x][y] <= bamboo) {
            return 0;
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        // 최초 방문 시 1로 변경
        dp[x][y] = 1;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < forest.length && nextY >= 0 && nextY < forest.length && forest[nextX][nextY] > bamboo) {
                dp[x][y] = Math.max(dp[x][y], dfs(nextX, nextY, forest[x][y]) + 1);
            }
        }

        return dp[x][y];
    }

    public static void printForest() {
        for (int[] arr : dp) {
            for (int num : arr) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}
