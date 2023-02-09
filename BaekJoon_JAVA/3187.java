import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 사방 탐색 메소드와 방향 변수
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static boolean inBoard(int nowR, int nowC, int R, int C) {
		if (nowR >= 0 && nowR < R && nowC >= 0 && nowC < C) {
			return true;
		} else
			return false;
	}

	static int C;
	static int R;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[][] visited;
	static char[][] board;
	static int wolves = 0;
	static int sheeps = 0;
	static int partW = 0;
	static int partS = 0;

	// bfs 수행 메소드
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		while (q.size() > 0) {
			int[] go = q.poll();

			if (visited[go[0]][go[1]] == false) {
				if (board[go[0]][go[1]] == 'k') {
					partS++;
				} else if (board[go[0]][go[1]] == 'v') {
					partW++;
				}

				visited[go[0]][go[1]] = true;
				for (int i = 0; i < 4; i++) {
					if (inBoard(go[0] + dir[i][0], go[1] + dir[i][1], R, C)
							&& board[go[0] + dir[i][0]][go[1] + dir[i][1]] != '#'
							&& visited[go[0] + dir[i][0]][go[1] + dir[i][1]] == false) {
						q.add(new int[] { go[0] + dir[i][0], go[1] + dir[i][1] });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];

		// 보드 만들기 늑대면, 양이면
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char value = str.charAt(j);
				if (value == 'k') {
					sheeps++;
				} else if (value == 'v') {
					wolves++;
				}
				board[i][j] = value;
			}
		}
        
		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				if (board[j][k] != '#' && visited[j][k] == false) {
					bfs(j, k);
					if (partW >= partS) {
						sheeps -= partS;
					} else {
						wolves -= partW;
					}
				}
				partS = 0;
				partW = 0;
			}
		}
		System.out.println(sheeps + " " + wolves);
	}
}