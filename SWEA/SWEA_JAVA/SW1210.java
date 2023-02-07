import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static boolean[][] visited;
	static int[] location;
	static int answer;
	static boolean inBoard(int r, int c) {
		if(r<100 && r>=0 && c<100 && c>=0) {
			return true;
		}
		return false;
	}
	static void dfs(int startR, int startC) {
		if(startR==0) {
			answer = startC;
			return;
		}
		
		if(inBoard(startR,startC+1) && board[startR][startC+1]>0 && visited[startR][startC+1]==false) {
			visited[startR][startC+1]=true;
			dfs(startR,startC+1);
		}
		else if(inBoard(startR,startC-1) && board[startR][startC-1]>0 && visited[startR][startC-1]==false) {
			visited[startR][startC-1]=true;
			dfs(startR,startC-1);
		}else{
			visited[startR-1][startC]=true;
			dfs(startR-1,startC);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str != null) {
			int K = Integer.parseInt(str);
			answer = 0;
			board = new int[100][100];
			visited = new boolean[100][100];
			location = new int[2];
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] == 2) {
						location[0] = i;
						location[1] = j;
					}
				}
			}
			
			visited[location[0]][location[1]] = true;
			dfs(location[0],location[1]);
			
			System.out.println("#"+K+" "+answer);
			answer = 0;
			str = br.readLine();
		}
	}

}
