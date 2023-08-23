import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11725 {
    public static boolean dfs(ArrayList<Integer>[] list, HashSet<Integer> visited, int[] arr, int num) {
        if (!visited.add(num)) {
            return false;
        }
        for (int a : list[num]) {
            if (dfs(list, visited, arr, a)) {
                arr[a] = num;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] lines = br.readLine().split(" ");
            int data1 = Integer.parseInt(lines[0]);
            int data2 = Integer.parseInt(lines[1]);
            list[data1].add(data2);
            list[data2].add(data1);
        }

        int[] arr = new int[N + 1];
        HashSet<Integer> visited = new HashSet<>();
        dfs(list, visited, arr, 1);

        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}