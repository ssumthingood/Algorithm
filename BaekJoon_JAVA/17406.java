import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] arr;
	static int N;
	static int M;
	static int K;
	static int[][] list;
	static int[][] temp;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	static void makePermutation(int size, ArrayList<int[]> myList) {
		if (size == K) {
			makeRotate(myList);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				myList.add(list[i]);
				makePermutation(size + 1, myList);
				int[] out = myList.remove(myList.size() - 1);
				visited[i] = false;
			}
		}
	}

	static void makeRotate(ArrayList<int[]> myList) {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			q.add(myList.get(i));
		}
		while (!q.isEmpty()) {
			int[] order = q.poll();
			temp = rotate(order[0] - 1, order[1] - 1, order[2]);
		}
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += temp[i][j];
			}
			answer= Math.min(answer, sum);
		}
	}

	static int[][] rotate(int o1, int o2, int o3) {
		int[][] temp2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp2[i][j] = temp[i][j];
			}
		}
		for (int i = 1; i <=o3; i++) {
			for (int j = o1 + i; j > o1 - i; j--) {
				temp2[j - 1][o2 - i] = temp[j][o2 - i];
			}
			for (int j = o2 - i; j < o2 + i; j++) {
				temp2[o1 - i][j + 1] = temp[o1 - i][j];
			}
			for (int j = o1 - i; j < o1 + i; j++) {
				temp2[j + 1][o2 + i] = temp[j][o2 + i];
			}
			for (int j = o2 + i; j > o2 - i; j--) {
				temp2[o1 + i][j - 1] = temp[o1 + i][j];
			}
		}
		return temp2;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			list[i][0] = s1;
			list[i][1] = s2;
			list[i][2] = s3;
		}
		visited = new boolean[K];
		makePermutation(0, new ArrayList<int[]>());
		System.out.println(answer);
	}

}
