import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class where{
		int r;
		int c;
		int dis;
		boolean broken;

		public where(int r,int c, int dis, boolean broken){
		this.r=r;
		this.c=c;
		this.dis=dis;
		this.broken = broken;
		}
	}
	
	
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static boolean inBoard(int nowR, int nowC, int R, int C) {
		if (nowR >= 0 && nowR < R && nowC >= 0 && nowC < C) {
			return true;
		} else
			return false;
	}

	static int R;
	static int C;
	static BufferedReader br;
	static StringTokenizer st;
	static int answer = -1;
	static int[][] board;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C][2];
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				int value = Integer.parseInt(str.charAt(j) + "");
				board[i][j] = value;
			}
		}
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<where> nextGo = new LinkedList<>();
		nextGo.add(new where (0, 0, 1, false));
		while (!nextGo.isEmpty()) {
			where next = nextGo.poll();
			if (next.r == R - 1 && next.c == C - 1) {
				if (answer == -1) {
					answer = next.dis;
				} else {
					answer = Math.min(answer, next.dis);
				}
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nowR = next.r;
				int nowC = next.c;
				int newR = next.r + dir[i][0];
				int newC = next.c + dir[i][1];
				if(!inBoard(newR,newC,R,C)) continue;
				
				if(board[newR][newC] ==0) {
					if(next.broken==false && visited[newR][newC][0]==false) { //갈 수 있는곳이고 전에 벽을 깬 적이 없을 때 
						nextGo.add(new where(newR,newC,next.dis+1,false));
						visited[newR][newC][0] = true;
					}else if(next.broken==true && visited[newR][newC][1]==false) { // 갈 수 있는곳이고 전에 벽을 깬 적이 있을 때 
						nextGo.add(new where(newR,newC,next.dis+1,true));
						visited[newR][newC][1] = true;
					}
				}else { //벽을 만났는데 벽을 깰수있을 때 -> 깨버리기 
					if(next.broken==false) {
						nextGo.add(new where(newR,newC,next.dis+1,true));
						visited[newR][newC][1] = true;
					}
				}
			}
		}
	}
}
