import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N, M;
    static char[][] maze;
    static int[][] move;
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 아래, 오른쪽, 위쪽, 왼쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        maze = new char[N][M];
        move = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j);
            }
        }


        bfs(0, 0);
        System.out.println(move[N - 1][M - 1]);
        for (int[] aa : move) {
            System.out.println(Arrays.toString(aa));
        }
    }

    public static void bfs(int n, int m) {
        Node origin = new Node(n, m);
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(origin);
        visited[n][m] = true;
        move[0][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.x][cur.y] = true;

            // end check
            if (cur.x == N - 1 && cur.y == M - 1) {
                break;
            }

            for (int[] dir : dirs) {
                int nextX = cur.x + dir[0];
                int nextY = cur.y + dir[1];

                if (isMoveable(nextX, nextY)) {
                    queue.add(new Node(nextX, nextY));
                    move[nextX][nextY] = move[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static boolean isMoveable(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }

        if (x >= N || y >= M) {
            return false;
        }

        if (maze[x][y] != '1') {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return true;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
