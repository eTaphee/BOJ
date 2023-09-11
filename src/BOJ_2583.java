import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int area = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(tokenizer.nextToken());
            int fromY = Integer.parseInt(tokenizer.nextToken());
            int toX = Integer.parseInt(tokenizer.nextToken());
            int toY = Integer.parseInt(tokenizer.nextToken());

            for (int row = fromY; row < toY; row++) {
                for (int col = fromX; col < toX; col++) {
                    board[row][col] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                area = 0;
                dfs(i, j);
                if (area > 0) {
                    list.add(area);
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void dfs(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (board[x][y] != 0) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        area++;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            dfs(nextX, nextY);
        }
    }
}
