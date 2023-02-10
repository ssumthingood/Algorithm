import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static String str;
	static int N;
	static char[][] board;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int answer1 = 0;
	static int answer2 = 0;
	// 사방 탐색 메소드와 방향 변수
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static boolean inBoard(int nowR, int nowC) {
		return (nowR >= 0 && nowR < N && nowC >= 0 && nowC < N);
	}

	static void bfs1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited1[i][j]) continue;
				else {
					visited1[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] next = q.poll();
						for (int k = 0; k < 4; k++) {
							int nextR = next[0] + dir[k][0];
							int nextC = next[1] + dir[k][1];
							if (inBoard(nextR, nextC)) {
								if ((board[nextR][nextC] == board[next[0]][next[1]])
									&& (visited1[nextR][nextC] == false)) {
									q.add(new int[] { nextR, nextC });
									visited1[nextR][nextC] = true;
								}
							}
						}
					}
					answer1++;
				}
			}
		}
	}

	static void bfs2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited2[i][j]) 
					continue;
				else {
					visited2[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] next = q.poll();
						for (int k = 0; k < 4; k++) {
							int nextR = next[0] + dir[k][0];
							int nextC = next[1] + dir[k][1];
							if (inBoard(nextR, nextC)) {
								if ((board[nextR][nextC] == board[next[0]][next[1]])
									&& (visited2[nextR][nextC] == false)) {
									q.add(new int[] { nextR, nextC });
									visited2[nextR][nextC] = true;
								}
							}
						}
					}
					answer2++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = Integer.parseInt(str);
		board = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		bfs1();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'G')
					board[i][j] = 'R';
			}
		}
		bfs2();
		StringBuilder sb = new StringBuilder();
		sb.append(answer1).append(" ").append(answer2);
		System.out.println(sb);
	}
}
