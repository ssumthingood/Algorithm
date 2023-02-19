import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br;

	static void bfs(int num, int count) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { num, count });

		while (!q.isEmpty()) {
			int[] next = q.poll();
			if (next[0] == 1) {
				System.out.println(next[1]);
				break;
			} else {
				if (next[0] % 3 == 0) {
					q.add(new int[] { next[0] / 3, next[1] + 1 });
				}

				if (next[0] % 2 == 0) {
					q.add(new int[] { next[0] / 2, next[1] + 1 });
				}

				q.add(new int[] { next[0] - 1, next[1] + 1 });
			}

		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		bfs(N, 0);
	}

}